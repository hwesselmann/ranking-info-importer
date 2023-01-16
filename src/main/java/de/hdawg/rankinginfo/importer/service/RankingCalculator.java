package de.hdawg.rankinginfo.importer.service;

import de.hdawg.rankinginfo.importer.model.Ranking;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class RankingCalculator {

  private static final int BASE_YEAR_FOR_AGE_CALCULATION = 2000;

  public Map<String, Map<String, List<Ranking>>> calculateRankings(List<Ranking> importRankings) {
    LocalDate rankingPeriod = importRankings.get(0).getRankingPeriod();
    log.info("U11 will be yob {} in the current ranking period.", rankingPeriod.getYear() - 11);
    Collections.sort(importRankings);
    Map<String, Map<String, List<Ranking>>> calculatedRankings = new HashMap<>();
    calculatedRankings.put("official", calculateOfficialAgeGroupRankings(importRankings, rankingPeriod));
    calculatedRankings.put("overall", calculateOverallAgeGroupRankings(importRankings, rankingPeriod));
    calculatedRankings.put("yearOfBirth", calculateYearOfBirthRankings(importRankings, rankingPeriod));

    // check if this is the final ranking for this year
    if (rankingPeriod.getMonthValue() == 12) {
      calculatedRankings.put("endOfYear", calculateFinalRankingsForThisYear(importRankings, rankingPeriod));
    }

    return calculatedRankings;
  }

  /**
   * calculate the official rankings published by the German Tennis Federation (U12, U14, U16, U18).
   *
   * @param rankings
   * @param rankingPeriod
   * @return
   */
  Map<String, List<Ranking>> calculateOfficialAgeGroupRankings(List<Ranking> rankings, LocalDate rankingPeriod) {
    List<Integer> ageGroups = List.of(12, 14, 16, 18);
    for (int ageGroup : ageGroups) {
      // create list of rankings to apply
      // calculate rankings
    }
    return Collections.emptyMap();
  }

  /**
   * calculate the rankings for all age groups while also taking younger players into account.
   *
   * @param rankings
   * @param rankingPeriod
   * @return
   */
  Map<String, List<Ranking>> calculateOverallAgeGroupRankings(List<Ranking> rankings, LocalDate rankingPeriod) {
    return Collections.emptyMap();
  }

  /**
   * calculate the rankings for each year of birth separately.
   *
   * @param rankings
   * @param rankingPeriod
   * @return
   */
  Map<String, List<Ranking>> calculateYearOfBirthRankings(List<Ranking> rankings, LocalDate rankingPeriod) {
    return Collections.emptyMap();
  }

  /**
   * calculate the final rankings for a year.
   *
   * @param rankings
   * @param rankingPeriod
   * @return
   */
  Map<String, List<Ranking>> calculateFinalRankingsForThisYear(List<Ranking> rankings, LocalDate rankingPeriod) {
    return Collections.emptyMap();
  }

  List<Ranking> performRankingCalculation(List<Ranking> ranings, LocalDate rankingPeriod, boolean isOverallRanking, boolean isYobRanking, boolean isEndOfYearRanking) {
    int lastRank = 0;
    int currentRank = 0;
    int rankingCounter = 1;

    return Collections.emptyList();
  }

  /**
   * check if a player is in a given list of age groups.
   * I am completely aware that someone needs to adapt the calculation in the year 2010
   * in case this app lives that long.
   *
   * @param dtbId id of player to check
   * @param ageGroup list of age groups to check against
   * @param rankingPeriod ranking period to verify against
   * @return is the given player part of the passed age groups?
   */
  boolean isInAgeGroup(String dtbId, List<Integer> ageGroup, LocalDate rankingPeriod) {
    int age = rankingPeriod.getYear() - (BASE_YEAR_FOR_AGE_CALCULATION + Integer.parseInt(dtbId.substring(1, 3)));
    return ageGroup.contains(age);
  }
}
