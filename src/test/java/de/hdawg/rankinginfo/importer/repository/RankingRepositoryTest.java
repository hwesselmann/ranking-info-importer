package de.hdawg.rankinginfo.importer.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import de.hdawg.rankinginfo.importer.model.Federation;
import de.hdawg.rankinginfo.importer.model.Nationality;
import de.hdawg.rankinginfo.importer.model.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankingRepositoryTest {

  RankingRepository sut;
  JdbcTemplate jdbcTemplate;

  @BeforeEach
  void setUp() {
    sut = new RankingRepository();
    jdbcTemplate = new JdbcTemplate(getDataSource());
    sut.setJdbcTemplate(jdbcTemplate);
  }

  @DisplayName("store list of rankings into the datastore")
  @Test
  void testStoringRankingList() {
    LocalDate rankingPeriod = LocalDate.of(2022, 10, 1);
    List<Ranking> inRankings = new ArrayList<>();
    inRankings.add(createTestRankings(rankingPeriod, "10800001", Nationality.BEL, "1189,4", 60));
    inRankings.add(createTestRankings(rankingPeriod, "10800002", Nationality.GER, "1189,4", 60));
    inRankings.add(createTestRankings(rankingPeriod, "10800003", Nationality.GER, "1189,4", 110));
    inRankings.add(createTestRankings(rankingPeriod, "10800004", Nationality.GER, "Einst.", 110));
    inRankings.add(createTestRankings(rankingPeriod, "10800005", Nationality.JPN, "1189,4", 125));
    inRankings.add(createTestRankings(rankingPeriod, "10800006", Nationality.CRO, "1189,4", 125));
    inRankings.add(createTestRankings(rankingPeriod, "10800007", Nationality.GER, "1189,4", 126));
    inRankings.add(createTestRankings(rankingPeriod, "10800008", Nationality.GER, "PR", 126));
    inRankings.add(createTestRankings(rankingPeriod, "10800009", Nationality.GER, "1189,4", 400));
    inRankings.add(createTestRankings(rankingPeriod, "10800010", Nationality.GER, "1189,4", 401));

    sut.storeRankings(inRankings);

    assertEquals(0, getEntryCount());
  }

  private Ranking createTestRankings(LocalDate rankingPeriod, String dtbId, Nationality nationality, String points, int position) {
    return Ranking.builder()
        .rankingPeriod(rankingPeriod)
        .ageGroup("overall")
        .overallYouthRanking(false)
        .endOfYearRanking(false)
        .yearOfBirthRanking(false)
        .firstname("Max")
        .lastname("Tennismann")
        .federation(Federation.WTV)
        .nationality(nationality)
        .dtbId(dtbId)
        .club("TC Musterstadt")
        .points(points)
        .position(position)
        .build();
  }

  private HikariDataSource getDataSource() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(System.getenv("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:/db.sql'"));
    config.setUsername(System.getenv(""));
    config.setPassword(System.getenv(""));
    config.addDataSourceProperty("cachePrepStmts", "true");
    config.addDataSourceProperty("prepStmtCacheSize", "250");
    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    return new HikariDataSource(config);
  }

  private int getEntryCount() {
    return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM RANKING;", Integer.class);
  }
}
