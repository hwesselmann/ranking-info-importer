package de.hdawg.rankinginfo.importer.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * datasource for importer.
 */
public class Datasource {

  /**
   * fetch a datasource
   *
   * @return hikari datasource
   */
  public static HikariDataSource getDataSource() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(System.getenv("DB_JDBC_URL"));
    config.setUsername(System.getenv("DB_USER"));
    config.setPassword(System.getenv("DB_PASSWORD"));
    config.addDataSourceProperty("cachePrepStmts", "true");
    config.addDataSourceProperty("prepStmtCacheSize", "250");
    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    return new HikariDataSource(config);
  }
}
