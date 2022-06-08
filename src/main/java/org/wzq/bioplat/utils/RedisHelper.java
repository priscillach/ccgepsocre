package org.wzq.bioplat.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
public class RedisHelper {
    @Autowired
    RedisTemplate redisTemplate;
    public Object getKey(String key){
        ValueOperations<String,Object> operations=redisTemplate.opsForValue();
        return operations.get(key);
    }

    public Set<Object> scan(String key, int countOneTime){
        return scan(key, Integer.MAX_VALUE, countOneTime);
    }

    public Set<Object> scan(String key, int limit, int countOneTime){
        Set<Object> result = new HashSet<>();
        try{
            ScanOptions options = ScanOptions.scanOptions()
                    .count(countOneTime)
                    .match(key).build();
            Cursor cursor = (Cursor) redisTemplate.executeWithStickyConnection(redisConnection ->
                    new ConvertingCursor<>(redisConnection.scan(options), redisTemplate.getKeySerializer()::deserialize));
            ValueOperations<String,Object> operations=redisTemplate.opsForValue();
            while(result.size()<limit&&cursor.hasNext()){
                result.add(operations.get(cursor.next()));
            }
            cursor.close();
        }catch(IOException exception){ }
        return result;
    }

    public Set<Object> keys(String key){
        return keys(key, Integer.MAX_VALUE);
    }

    public Set<Object> keys(String key, int limit){
        Set<String> set=redisTemplate.keys(key);
        Iterator<String> iterator = set.iterator();
        ValueOperations<String,Object> operations=redisTemplate.opsForValue();
        Set<Object> res=new HashSet<>();
        while(iterator.hasNext()&&limit>0){
            if(res.add(operations.get(iterator.next())))
                --limit;
        }
        return res;
    }
}
