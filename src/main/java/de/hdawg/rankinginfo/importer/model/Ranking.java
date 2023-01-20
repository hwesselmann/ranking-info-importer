package de.hdawg.rankinginfo.importer.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

/**
 * model class for a ranking used as basis for the ranking-info application.
 */
@Getter
@EqualsAndHashCode
@Builder
public class Ranking implements Comparable<Ranking> {
  private LocalDate rankingPeriod;
  private String dtbId;
  private String lastname;
  private String firstname;
  private String points;
  private Nationality nationality;
  private Federation federation;
  private String club;
  private String ageGroup;
  private Integer position;
  private Boolean yearOfBirthRanking;
  private Boolean overallYouthRanking;
  private Boolean endOfYearRanking;

  @Override
  public int compareTo(Ranking otherRanking) {
    return getPosition().compareTo(otherRanking.position);
  }
}
