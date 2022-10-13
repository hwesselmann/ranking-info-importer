package de.hdawg.rankinginfo.importer.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ImportedRanking {
  private LocalDate rankingPeriod;
  private Long dtbId;
  private String lastname;
  private String firstname;
  private String points;
  private Nationality nationality;
  private Federation federation;
  private String club;
  private String ageGroup;
  private Integer position;
}
