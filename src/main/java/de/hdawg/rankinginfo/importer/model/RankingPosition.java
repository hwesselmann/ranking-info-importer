package de.hdawg.rankinginfo.importer.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RankingPosition {
  private String ageGroup;
  private String variant;
  private Integer position;
}
