package org.wzq.bioplat.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DifGeneAls {

  private long entrezId;
  private Double logfc;
  private Double pvalue;
  private Double adjpvalue;
  private long contrastId;

  @Override
  public String toString() {
    return "DifGeneAls110000{" +
            "entrezId=" + entrezId +
            ", logfc=" + logfc +
            ", pvalue=" + pvalue +
            ", adjpvalue=" + adjpvalue +
            ", contrastId=" + contrastId +
            '}';
  }
}
