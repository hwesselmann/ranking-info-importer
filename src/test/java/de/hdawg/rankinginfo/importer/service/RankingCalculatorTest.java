package de.hdawg.rankinginfo.importer.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RankingCalculatorTest {

  @DisplayName("check if a given player is in an age group given")
  @Test
  public void checkForAgeGroup() {
    RankingCalculator sut = new RankingCalculator();

    assertTrue(sut.isInAgeGroup("10800000", List.of(15, 16), LocalDate.of(2023, 7, 10)));
    assertTrue(sut.isInAgeGroup("10900000", List.of(13, 14), LocalDate.of(2023, 7, 10)));
    assertTrue(sut.isInAgeGroup("11000000", List.of(13, 14), LocalDate.of(2023, 7, 10)));
    assertTrue(sut.isInAgeGroup("10600000", List.of(15, 16, 17), LocalDate.of(2023, 7, 10)));
    assertFalse(sut.isInAgeGroup("10800000", List.of(11), LocalDate.of(2023, 7, 10)));
    assertFalse(sut.isInAgeGroup("11200000", List.of(12), LocalDate.of(2023, 7, 10)));
  }
}
