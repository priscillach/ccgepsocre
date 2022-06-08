package org.wzq.bioplat.service;

import org.wzq.bioplat.dao.Pert;

import java.util.Set;

public interface SeachRedisService {
    public String darkQueryLimit(String pname);
    public Set<Pert> darkQueryAll(String pname);
}
