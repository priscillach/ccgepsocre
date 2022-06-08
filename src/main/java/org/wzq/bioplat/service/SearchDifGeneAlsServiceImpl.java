package org.wzq.bioplat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzq.bioplat.dao.Contrast;
import org.wzq.bioplat.dao.DifGeneAls;
import org.wzq.bioplat.dao.DifGeneAlsCouple;
import org.wzq.bioplat.mapper.DifGeneAlsMapper;
import org.wzq.bioplat.utils.RedisHelper;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchDifGeneAlsServiceImpl implements SearchDifGeneAlsService{
    public static final double LOGCONST=   27.026814668;
    @Autowired
    DifGeneAlsMapper difGeneAlsMapper;
    @Autowired
    SearchContrastServiceImpl searchContrastServiceImpl;
    @Autowired
    RedisHelper redisHelper;
    public List<DifGeneAlsCouple> getBycontrastId(long contrastId){
        Contrast contrast=searchContrastServiceImpl.getByContrastId(contrastId);
        String keypre="Gene:"+contrast.getTcgaClassification()+":";
        List<DifGeneAls> list = difGeneAlsMapper.getBycontrastId(contrastId);
        List<DifGeneAlsCouple> res=new ArrayList<>();
        for(DifGeneAls item:list){
            long enterezid=item.getEntrezId();
            DifGeneAls difGeneAls=(DifGeneAls)redisHelper.getKey(keypre+enterezid);
            Double itemLogfc=item.getLogfc();
            Double itemPvalue=item.getPvalue();
            Double itemAdjPvalue=item.getAdjpvalue();
            if(itemLogfc==null||itemPvalue==null||itemAdjPvalue==null)
                continue;

            double itemPvalueAround=new BigDecimal(String.valueOf(itemPvalue)).round(new MathContext(5, RoundingMode.HALF_UP)).doubleValue();
            double itemAdjPvalueAround=new BigDecimal(String.valueOf(itemAdjPvalue)).round(new MathContext(5, RoundingMode.HALF_UP)).doubleValue();
            if(difGeneAls==null)
                res.add(new DifGeneAlsCouple(enterezid,itemLogfc,itemPvalueAround,itemAdjPvalueAround,null,null,null,null));
            else{
                double difGeneAlsLocfcAround=new BigDecimal(String.valueOf(difGeneAls.getLogfc())).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
                double difGeneAlsPvalueAround=new BigDecimal(String.valueOf(difGeneAls.getPvalue())).round(new MathContext(5, RoundingMode.HALF_UP)).doubleValue();
                double difGeneAlsAdjPvalueAround=new BigDecimal(String.valueOf(difGeneAls.getAdjpvalue())).round(new MathContext(5, RoundingMode.HALF_UP)).doubleValue();
                String color=null;
                if(difGeneAlsPvalueAround<0.05){
                    double contribution=Math.pow(1-itemPvalueAround,LOGCONST)*Math.pow(1-difGeneAlsPvalueAround,LOGCONST);
                    contribution=(itemLogfc>0&&difGeneAlsLocfcAround<0||itemLogfc<0&&difGeneAlsLocfcAround>0)?contribution:-1*contribution;
                    color="";
                    if(contribution>0){
                        color+="1rgb(";
                        int coloritem=(int)Math.round((1-contribution)*255);
                        color+=coloritem+",255,"+coloritem+")";
                    }else{
                        color+="0rgb(";
                        int coloritem=(int)Math.round((1-Math.abs(contribution))*255);
                        color+="255,"+coloritem+","+coloritem+")";
                    }
                }
                res.add(new DifGeneAlsCouple(enterezid,itemLogfc,itemPvalueAround,itemAdjPvalueAround,difGeneAlsLocfcAround,difGeneAlsPvalueAround,difGeneAlsAdjPvalueAround,color));
            }

        }
        return res;
    }
}
