package org.wzq.bioplat.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PertByIDDAO extends ElasticsearchRepository<PertByID, Integer> {


}
