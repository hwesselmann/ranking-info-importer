package de.hdawg.rankinginfo.importer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.jdbc.core.JdbcTemplate;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SystemStubsExtension.class)
class RankingImporterIntegrationTest {

  @SystemStub
  private EnvironmentVariables environmentVariables;

  @DisplayName("run the complete import dance")
  @Test
  void performRankingImport(EnvironmentVariables environmentVariables) {
    environmentVariables.set("DB_JDBC_URL", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:/db.sql'");
    environmentVariables.set("DB_USER", "");
    environmentVariables.set("DB_PASSWORD", "");

    RankingImporter sut = new RankingImporter();
    String filename = "src/test/resources/AlphaGesamtranglisteJuniorenfuerJugendturnierveranstalter_20221001.csv";
    sut.importRankings(filename);

    JdbcTemplate jdbcTemplate = new JdbcTemplate(getDatasource());
    int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM RANKING;", Integer.class);

    assertEquals(11360, count);
    jdbcTemplate.execute("DROP TABLE RANKING");
  }

  private HikariDataSource getDatasource() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    config.setUsername("");
    config.setPassword("");
    config.addDataSourceProperty("cachePrepStmts", "true");
    config.addDataSourceProperty("prepStmtCacheSize", "250");
    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    return new HikariDataSource(config);
  }
}
