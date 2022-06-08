package org.wzq.bioplat.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("contrast")
public class Contrast {

  private long contrastId;
  private String geoAccessionId;
  private String source;
  private String cosmicSampleName;
  private String tcgaClassification;
  private String gtExTissue;
  private long pertId;
  private double pertDose;
  private String controlType;
  private String pertDoseUnit;
  private String pertTimeUnit;
  private long pertTimeTreatment;
  private long pertTimeControl;
  private double ksScore;
  private double xCosScore;
  private double xSumScore;
  private double zhangScore;
  private double crisprScore;
  private double ksRank;
  private double xCosRank;
  private double xSumRank;
  private double zhangRank;
  private double crisprRank;

    @Override
    public String toString() {
        return "Contrast{" +
                "contrastId=" + contrastId +
                ", geoAccessionId='" + geoAccessionId + '\'' +
                ", source='" + source + '\'' +
                ", cosmicSampleName='" + cosmicSampleName + '\'' +
                ", tcgaClassification='" + tcgaClassification + '\'' +
                ", gtExTissue='" + gtExTissue + '\'' +
                ", pertId=" + pertId +
                ", pertDose=" + pertDose +
                ", controlType='" + controlType + '\'' +
                ", pertDoseUnit='" + pertDoseUnit + '\'' +
                ", pertTimeUnit='" + pertTimeUnit + '\'' +
                ", pertTimeTreatment=" + pertTimeTreatment +
                ", pertTimeControl=" + pertTimeControl +
                ", ksScore=" + ksScore +
                ", xCosScore=" + xCosScore +
                ", xSumScore=" + xSumScore +
                ", zhangScore=" + zhangScore +
                ", crisprScore=" + crisprScore +
                ", ksRank=" + ksRank +
                ", xCosRank=" + xCosRank +
                ", xSumRank=" + xSumRank +
                ", zhangRank=" + zhangRank +
                ", crisprRank=" + crisprRank +
                '}';
    }
}
