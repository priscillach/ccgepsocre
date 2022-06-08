package org.wzq.bioplat.service;

import lombok.Data;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.wzq.bioplat.dao.Pert;
import org.wzq.bioplat.dao.PertByID;
import org.wzq.bioplat.dao.PertByIDDAO;
import org.wzq.bioplat.utils.HtmlCSSHelper;
import org.wzq.bioplat.utils.JsonHelper;
import org.wzq.bioplat.utils.RedisHelper;

import java.util.*;

@Service
@Data
@ConfigurationProperties(prefix = "searchredisserviceimpl")
public class SearchRedisServiceImpl implements SeachRedisService{
    private Integer limit;
    @Autowired
    PertByIDDAO pertByIDDAO;
    @Autowired
    RedisHelper redisHelper;

    @Override
    public String darkQueryLimit(String pname){
        System.out.println(pname);
        Set<Pert> set=new LinkedHashSet<>();
        Map<String,Float> weightMap=new HashMap<>();
        weightMap.put("alias.keyword",10.0F);
        weightMap.put("alias.lowercase",5.0F);
        weightMap.put("alias.ngram",1.0F);
        int estimatePageSize=60;
        PageRequest pageRequest=PageRequest.of(0,estimatePageSize);
        QueryBuilder termQueryBuilder= QueryBuilders.multiMatchQuery(pname).fields(weightMap);
        Iterable<PertByID> pids=pertByIDDAO.search(termQueryBuilder,pageRequest);
        for(PertByID pid:pids){
            Pert pert=(Pert)redisHelper.getKey("Pert:"+String.valueOf(pid.getPert_id()));
            pert.setHighLightAlias(HtmlCSSHelper.highLight(pid.getAlias(),pname));
            pert.setAlias(pid.getAlias());
            set.add(pert);
            if(set.size()>=limit)
                break;
        }
        String res=JsonHelper.objectToJson(set);
        return res;
    }

    @Override
    public Set<Pert> darkQueryAll(String pname){
        Set<Pert> set=new LinkedHashSet<>();
        Map<String,Float> weightMap=new HashMap<>();
        weightMap.put("alias.keyword",10.0F);
        weightMap.put("alias.lowercase",5.0F);
        weightMap.put("alias.ngram",1.0F);
        QueryBuilder termQueryBuilder= QueryBuilders.multiMatchQuery(pname).fields(weightMap);
        Iterable<PertByID> pids=pertByIDDAO.search(termQueryBuilder);
        for(PertByID pid:pids){
            Pert pert=(Pert)redisHelper.getKey("Pert:"+String.valueOf(pid.getPert_id()));
            pert.setHighLightAlias(HtmlCSSHelper.highLight(pid.getAlias(),pname));
            pert.setAlias(pid.getAlias());
            set.add(pert);
        }
        return set;
    }

}
