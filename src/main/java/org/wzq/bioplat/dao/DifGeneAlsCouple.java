package org.wzq.bioplat.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DifGeneAlsCouple {
    private long entrezId;
    private double logfc;
    private double pvalue;
    private double adjpvalue;
    private Double logfc2;
    private Double pvalue2;
    private Double adjpvalue2;
    private String color;

    @Override
    public String toString() {
        return "DifGeneAlsCouple{" +
                "entrezId=" + entrezId +
                ", logfc=" + logfc +
                ", pvalue=" + pvalue +
                ", adjpvalue=" + adjpvalue +
                ", logfc2=" + logfc2 +
                ", pvalue2=" + pvalue2 +
                ", adjpvalue2=" + adjpvalue2 +
                ", color=" + color +
                '}';
    }
}
