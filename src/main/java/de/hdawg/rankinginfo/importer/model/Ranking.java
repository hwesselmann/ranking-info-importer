package de.hdawg.rankinginfo.importer.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

/**
 * model class for a ranking used as basis for the ranking-info application.
 */
@Getter
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

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Ranking)) {
      return false;
    }
    final Ranking other = (Ranking) o;
    final Object thisrankingPeriod = this.getRankingPeriod();
    final Object otherrankingPeriod = other.getRankingPeriod();
    if (thisrankingPeriod == null ? otherrankingPeriod != null : !thisrankingPeriod.equals(otherrankingPeriod)) {
      return false;
    }
    final Object thisdtbId = this.getDtbId();
    final Object otherdtbId = other.getDtbId();
    if (thisdtbId == null ? otherdtbId != null : !thisdtbId.equals(otherdtbId)) {
      return false;
    }
    final Object thislastname = this.getLastname();
    final Object otherlastname = other.getLastname();
    if (thislastname == null ? otherlastname != null : !thislastname.equals(otherlastname)) {
      return false;
    }
    final Object thisfirstname = this.getFirstname();
    final Object otherfirstname = other.getFirstname();
    if (thisfirstname == null ? otherfirstname != null : !thisfirstname.equals(otherfirstname)) {
      return false;
    }
    final Object thispoints = this.getPoints();
    final Object otherpoints = other.getPoints();
    if (thispoints == null ? otherpoints != null : !thispoints.equals(otherpoints)) {
      return false;
    }
    final Object thisnationality = this.getNationality();
    final Object othernationality = other.getNationality();
    if (thisnationality == null ? othernationality != null : !thisnationality.equals(othernationality)) {
      return false;
    }
    final Object thisfederation = this.getFederation();
    final Object otherfederation = other.getFederation();
    if (thisfederation == null ? otherfederation != null : !thisfederation.equals(otherfederation)) {
      return false;
    }
    final Object thisclub = this.getClub();
    final Object otherclub = other.getClub();
    if (thisclub == null ? otherclub != null : !thisclub.equals(otherclub)) {
      return false;
    }
    final Object thisageGroup = this.getAgeGroup();
    final Object otherageGroup = other.getAgeGroup();
    if (thisageGroup == null ? otherageGroup != null : !thisageGroup.equals(otherageGroup)) {
      return false;
    }
    final Object thisposition = this.getPosition();
    final Object otherposition = other.getPosition();
    if (thisposition == null ? otherposition != null : !thisposition.equals(otherposition)) {
      return false;
    }
    final Object thisyearOfBirthRanking = this.getYearOfBirthRanking();
    final Object otheryearOfBirthRanking = other.getYearOfBirthRanking();
    if (thisyearOfBirthRanking == null ? otheryearOfBirthRanking != null : !thisyearOfBirthRanking.equals(otheryearOfBirthRanking)) {
      return false;
    }
    final Object thisoverallYouthRanking = this.getOverallYouthRanking();
    final Object otheroverallYouthRanking = other.getOverallYouthRanking();
    if (thisoverallYouthRanking == null ? otheroverallYouthRanking != null : !thisoverallYouthRanking.equals(otheroverallYouthRanking)) {
      return false;
    }
    final Object thisendOfYearRanking = this.getEndOfYearRanking();
    final Object otherendOfYearRanking = other.getEndOfYearRanking();
    return thisendOfYearRanking == null ? otherendOfYearRanking == null : thisendOfYearRanking.equals(otherendOfYearRanking);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
