package de.hdawg.rankinginfo.importer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankingImporterIntegrationTest {

  @DisplayName("run the complete import dance")
  @Test
  void performRankingImport() {
    RankingImporter sut = new RankingImporter();
    String filename = "src/test/resources/AlphaGesamtranglisteJuniorenfuerJugendturnierveranstalter_20221001.csv";
    sut.importRankings(filename);
  }
}
