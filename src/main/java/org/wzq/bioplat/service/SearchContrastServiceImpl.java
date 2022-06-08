package org.wzq.bioplat.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzq.bioplat.dao.Contrast;
import org.wzq.bioplat.mapper.ContrastMapper;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@Service
public class SearchContrastServiceImpl extends ServiceImpl<ContrastMapper, Contrast> implements SearchContrastService{
    @Autowired
    ContrastMapper contrastMapper;
    public List<Contrast> getByPertId(long pertId){
        List<Contrast> list = contrastMapper.getByPertId(pertId);

        list.forEach(item->{
            item.setPertDose(new BigDecimal(String.valueOf(item.getPertDose())).round(new MathContext(6, RoundingMode.HALF_UP)).doubleValue());
        });
        return list;
    }
    public Contrast getByContrastId(long contrastId){
        return contrastMapper.getByContrastId(contrastId);
    }
}
