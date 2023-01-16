package de.hdawg.rankinginfo.importer.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import de.hdawg.rankinginfo.importer.exception.FilenameFormatException;
import de.hdawg.rankinginfo.importer.exception.UnknownNationalityException;
import de.hdawg.rankinginfo.importer.model.Federation;
import de.hdawg.rankinginfo.importer.model.Ranking;
import de.hdawg.rankinginfo.importer.model.Nationality;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * reads and maps ranking-file contents into the internal model.
 */
@Slf4j
public class RankingFileProcessor {

  private static final List<Integer> ALLOWED_MONTHS = List.of(1, 4, 7, 10);

  /**
   * read a list of rankings from an input file.
   *
   * @param filename name of csv-file with official overall rankings.
   * @return list of rankings
   */
  public List<Ranking> readRankingsFromImportFile(String filename) {
    Path path = Paths.get(filename);
    if (Files.exists(path) && Files.isRegularFile(path)) {
      try {
        LocalDate rankingPeriod = getPeriodFromFilename(filename);
        List<Ranking> rankings = readAndMapImportFile(filename, rankingPeriod);
        log.info("read {} unique rankings from file {}", rankings.size(), filename);
        return rankings;
      } catch (FilenameFormatException | IOException | CsvException ex) {
        log.warn("file {} is no valid import file. Nothing will be imported", filename);
        return Collections.emptyList();
      }
    } else {
      log.warn("file {} was not found or is not a valid file. Nothing will be imported", filename);
      return Collections.emptyList();
    }
  }

  LocalDate getPeriodFromFilename(String filename) {
    String[] datePart = filename.split("\\.")[0].split("_");
    if (datePart.length == 2) {
      int year = Integer.parseInt(datePart[1].substring(0, 4));
      int month = Integer.parseInt(datePart[1].substring(4, 6));
      int day = Integer.parseInt(datePart[1].substring(6, 8));

      if (year >= 2000 && ALLOWED_MONTHS.contains(month) && day == 1) {
        return LocalDate.of(year, month, day);
      } else {
        log.error("No valid date could be extracted from the file {}", filename);
        throw new FilenameFormatException("No valid date could be extracted from the file");
      }
    } else {
      log.error("No date could be found when inspecting the import file {}", filename);
      throw new FilenameFormatException("No date could be found when inspecting the import file");
    }
  }

  private List<Ranking> readAndMapImportFile(String filename, LocalDate period) throws IOException, CsvException {
    List<Ranking> rankings = new ArrayList<>();

    CSVParser parser = new CSVParserBuilder()
        .withSeparator(',')
        .build();

    CSVReader reader = new CSVReaderBuilder(new FileReader(filename))
        .withCSVParser(parser)
        .build();

    List<String[]> lines = new ArrayList<>();
    lines = reader.readAll();
    reader.close();

    for (String[] line : lines) {
      rankings.add(mapRankingFromLine(line, period));
    }
    return rankings;
  }

  private Ranking mapRankingFromLine(String[] line, LocalDate period) {

    try {
      String dtbId = line[4].split(" ")[0];
      Federation federation = Federation.valueOf(line[4].split(" ")[1]);
      Nationality nationality = Nationality.valueOf(line[3]);

      return Ranking
        .builder()
        .lastname(line[1])
        .firstname(line[2])
        .nationality(nationality)
        .club(line[5])
        .points(line[6])
        .rankingPeriod(period)
        .ageGroup("U18")
        .position(Integer.parseInt(line[0]))
        .dtbId(dtbId)
        .federation(federation)
        .overallYouthRanking(true)
        .yearOfBirthRanking(false)
        .build();

    } catch (IllegalArgumentException e) {
      String msg = "the given nationality " + line[3] + "is not mappable in the current version.";
      log.error(msg);
      throw new UnknownNationalityException(msg);
    }
  }
}
