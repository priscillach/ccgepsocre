package org.wzq.bioplat.service;

import org.wzq.bioplat.dao.DifGeneAlsCouple;

import java.util.List;

public interface SearchDifGeneAlsService{
    public List<DifGeneAlsCouple> getBycontrastId(long contrastId);
}
