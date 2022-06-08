package org.wzq.bioplat.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Data
@Setting(settingPath = "/static/json/pert-setting.json")
@Mapping(mappingPath = "/static/json/pert-mapping.json")
@Document(indexName = "pert")
public class PertByID {
    @Id
    private int id;
    private int pert_id;
    private String alias;


    @Override
    public String toString() {
        return "PertByID{" +
                "id=" + id +
                ", pert_id='" + pert_id + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }

    public PertByID(int id, int pert_id,String alias) {
        this.id = id;
        this.pert_id = pert_id;
        this.alias = alias;
    }

    public PertByID() {
    }
}
