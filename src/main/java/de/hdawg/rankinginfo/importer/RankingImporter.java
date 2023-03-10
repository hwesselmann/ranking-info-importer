package de.hdawg.rankinginfo.importer;

import de.hdawg.rankinginfo.importer.model.Ranking;
import de.hdawg.rankinginfo.importer.repository.Datasource;
import de.hdawg.rankinginfo.importer.repository.RankingRepository;
import de.hdawg.rankinginfo.importer.service.RankingCalculator;
import de.hdawg.rankinginfo.importer.service.RankingFileProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * main entry class for triggering a ranking-file import.
 */
@Slf4j
public class RankingImporter {

  /**
   * main method orchestrating the flow of a ranking file import process.
   */
  public void importRankings(String filename) {
    log.info("new ranking-file will be imported into the database");
    RankingFileProcessor rankingFileProcessor = new RankingFileProcessor();
    RankingCalculator rankingCalculator = new RankingCalculator();
    long importStarted = System.currentTimeMillis();
    List<Ranking> rankings = rankingFileProcessor.readRankingsFromImportFile(filename);
    if (!rankings.isEmpty()) {
      Map<String, Map<String, List<Ranking>>> calculatedRankings = rankingCalculator.calculateRankings(rankings);
      storeRankings(calculatedRankings);
    }
    long importFinished = System.currentTimeMillis();
    log.info("ranking import finished in {} miliseconds", (importFinished - importStarted));
  }

  private void storeRankings(Map<String, Map<String, List<Ranking>>> rankingsMap) {
    RankingRepository repository = new RankingRepository();
    repository.setJdbcTemplate(new JdbcTemplate(Datasource.getDataSource()));
    rankingsMap.forEach((key, rankingMap) -> {
      log.debug("storing entries of listing type {}", key);
      rankingMap
          .forEach((ageGroup, rankingList) -> repository.storeRankings(rankingList));
    });
  }
}
