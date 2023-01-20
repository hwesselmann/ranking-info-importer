package de.hdawg.rankinginfo.importer.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RankingTest {

  @DisplayName("verify the generated equal-method is correct")
  @Test
  void verifyEquals() {
    Ranking sutA = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 1,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    Ranking sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 1,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();

    boolean result = sutA.equals(sutB);
    assertTrue(result);
    result = sutB.equals(sutA);
    assertTrue(result);
  }

  @DisplayName("verify generated hashcode is correct")
  @Test
  void verifyHashcode(){
    Ranking sut = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").build();

    assertEquals(802024259, sut.hashCode());
  }
}
