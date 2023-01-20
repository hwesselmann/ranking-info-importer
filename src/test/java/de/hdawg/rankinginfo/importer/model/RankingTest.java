package de.hdawg.rankinginfo.importer.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RankingTest {

  @DisplayName("verify the generated equal-method is correct")
  @Test
  void verifyEquals() {
    Ranking sutA = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 1,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();

    boolean result = sutA.equals(null);
    assertFalse(result);

    Ranking sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 1,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertTrue(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(null).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("123456789").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId(null).firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Musterfrau").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname(null).position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Klaus").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname(null).lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("21").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points(null).club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.AUT).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(null).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.WTV).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(null).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("TC Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club(null).nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U13").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup(null).build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(21).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(null).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);
  }

  @DisplayName("verify the generated equal-method is correct for boolean values")
  @Test
  void verifyEqualsForBooleanValues() {
    Ranking sutA = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 1,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();

    Ranking sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(true).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    boolean result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(null).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(true).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(null).overallYouthRanking(false).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(true).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);

    sutB = Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 2,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(null).ageGroup("U12").build();
    result = sutA.equals(sutB);
    assertFalse(result);
  }

  @DisplayName("verify generated hashcode is correct")
  @Test
  void verifyHashcode(){
    Ranking sut= Ranking.builder().dtbId("12345678").firstname("Max").lastname("Mustermann").position(20).points("22").club("Musterstadt").nationality(Nationality.GER).rankingPeriod(LocalDate.of(2022, 1,1)).federation(Federation.BB).yearOfBirthRanking(false).endOfYearRanking(false).overallYouthRanking(false).ageGroup("U12").build();

    assertEquals(802024259, sut.hashCode());
  }
}
