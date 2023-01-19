package de.hdawg.rankinginfo.importer.repository;

import de.hdawg.rankinginfo.importer.model.Ranking;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * class providing storage operations for rankings.
 */
public class RankingRepository {

  private JdbcTemplate jdbcTemplate;

  /**
   * stores rankings in batches of 100.
   *
   * @param rankings list of rankings to store
   */
  public void storeRankings(List<Ranking> rankings) {
    jdbcTemplate.batchUpdate("INSERT INTO RANKING " + "(DTBID, RANKINGPERIOD, LASTNAME, FIRSTNAME, POINTS, RANKINGPOSITION, NATIONALITY, FEDERATION, CLUB, AGEGROUP, YOBRANKINGS, OVERALLRANKING, ENDOFYEARRANKING) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", rankings, 100, (PreparedStatement ps, Ranking ranking) -> {
      ps.setString(1, ranking.getDtbId());
      ps.setDate(2, Date.valueOf(ranking.getRankingPeriod()));
      ps.setString(3, ranking.getLastname());
      ps.setString(4, ranking.getFirstname());
      ps.setString(5, ranking.getPoints());
      ps.setInt(6, ranking.getPosition());
      ps.setString(7, ranking.getNationality().toString());
      ps.setString(8, ranking.getFederation().toString());
      ps.setString(9, ranking.getClub());
      ps.setString(10, ranking.getAgeGroup());
      ps.setBoolean(11, ranking.getYearOfBirthRanking());
      ps.setBoolean(12, ranking.getOverallYouthRanking());
      ps.setBoolean(13, ranking.getEndOfYearRanking());
    });
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
}
