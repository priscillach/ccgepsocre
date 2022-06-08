package org.wzq.bioplat.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
        dynamicTableNameParser.setTableNameHandlerMap(new HashMap<String, ITableNameHandler>(2) {{
            put("dif_gene_als", (metaObject, sql, tableName) -> {
                // 获取传入参数 year，如果有的话做为后缀，没有的话则使用当前年份作为后缀
                Object param = getParamValue("contrastid", metaObject);
                int contrastid = Integer.parseInt(String.valueOf(param))-1;
//                System.out.println(tableName + "_" + contrastid/10000);
                return tableName + "_" + contrastid/10000;
            });
        }});
        paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));
        return paginationInterceptor;
    }

    /**
     * 获取参数值
     */
    private Object getParamValue(String title, MetaObject metaObject){
        //获取参数
        Object originalObject = metaObject.getOriginalObject();
        JSONObject originalObjectJSON = JSON.parseObject(JSON.toJSONString(originalObject));
        JSONObject boundSql = originalObjectJSON.getJSONObject("boundSql");
        try {
            JSONObject parameterObject = boundSql.getJSONObject("parameterObject");
            return parameterObject.get(title);
        }catch (Exception e) {
            return null;
        }
    }
}


