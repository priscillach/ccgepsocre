package org.wzq.bioplat.dao;

import lombok.Data;

import java.util.Objects;

@Data
public class Pert {
    private int pert_id;
    private String Pubchem_cid;
    private String Drugbank_id;
    private String Pubchem_title;
    private String source_name;
    private String CanonicalSMILES;
    private String InChIKey;
    private String alias;
    private String highLightAlias;
    public Pert(){};
    public Pert(int pert_id, String pubchem_cid, String drugbank_id, String pubchem_title, String source_name, String canonicalSMILES, String inChIKey, String alias) {
        this.pert_id = pert_id;
        this.Pubchem_cid = pubchem_cid;
        this.Drugbank_id = drugbank_id;
        this.Pubchem_title = pubchem_title;
        this.source_name = source_name;
        this.CanonicalSMILES = canonicalSMILES;
        this.InChIKey = inChIKey;
        this.alias=alias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pert)) return false;
        Pert pert = (Pert) o;
        return getPert_id() == pert.getPert_id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPert_id());
    }
}