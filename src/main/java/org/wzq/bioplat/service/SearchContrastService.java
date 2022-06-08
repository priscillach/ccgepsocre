package org.wzq.bioplat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.wzq.bioplat.dao.Contrast;

import java.util.List;

public interface SearchContrastService extends IService<Contrast> {
    public List<Contrast> getByPertId(long pertId);
    public Contrast getByContrastId(long contrastId);
}
