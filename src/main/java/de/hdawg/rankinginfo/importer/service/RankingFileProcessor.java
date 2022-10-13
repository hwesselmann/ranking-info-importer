package de.hdawg.rankinginfo.importer.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import de.hdawg.rankinginfo.importer.exception.FilenameFormatException;
import de.hdawg.rankinginfo.importer.model.Federation;
import de.hdawg.rankinginfo.importer.model.ImportedRanking;
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

@Slf4j
public class RankingFileProcessor {

  private static final List<Integer> ALLOWED_MONTHS = List.of(1, 4, 7, 10);

  public List<ImportedRanking> readRankingsFromImportFile(String filename) {
    Path path = Paths.get(filename);
    if (Files.exists(path) && Files.isRegularFile(path)) {
      try {
        LocalDate rankingPeriod = getPeriodFromFilename(filename);
        return readAndMapImportFile(filename, rankingPeriod);
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

  private List<ImportedRanking> readAndMapImportFile(String filename, LocalDate period) throws IOException, CsvException {
    List<ImportedRanking> importedRankings = new ArrayList<>();

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
      importedRankings.add(mapRankingFromLine(line, period));
    }
    return importedRankings;
  }

  private ImportedRanking mapRankingFromLine(String[] line, LocalDate period) {
    Long dtbId = Long.parseLong(line[4].split(" ")[0]);
    String federation = line[4].split(" ")[1];

    return ImportedRanking
      .builder()
      .lastname(line[1])
      .firstname(line[2])
      .nationality(Nationality.valueOf(line[3]))
      .club(line[5])
      .points(line[6])
      .rankingPeriod(period)
      .ageGroup("overall")
      .position(Integer.parseInt(line[0]))
      .dtbId(dtbId)
      .federation(Federation.valueOf(federation))
      .build();
  }
}
