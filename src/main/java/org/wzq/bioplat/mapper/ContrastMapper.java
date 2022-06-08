package org.wzq.bioplat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.wzq.bioplat.dao.Contrast;

import java.util.List;

@Mapper
public interface ContrastMapper extends BaseMapper<Contrast> {
    @Select("select * from contrast where pert_id=#{pertId}")
    public List<Contrast> getByPertId(long pertId);
    @Select("select * from contrast where contrast_id=#{contrastId}")
    public Contrast getByContrastId(long contrastId);
}
