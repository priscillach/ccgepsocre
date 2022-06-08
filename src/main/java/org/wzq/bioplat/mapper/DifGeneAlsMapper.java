package org.wzq.bioplat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wzq.bioplat.dao.DifGeneAls;

import java.util.List;

@Mapper
public interface DifGeneAlsMapper extends BaseMapper<DifGeneAls> {
    @Select("select * from dif_gene_als where contrast_id=#{contrastid}")
    List<DifGeneAls> getBycontrastId(@Param("contrastid")long contrastid);
}
