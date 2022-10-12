package de.hdawg.rankinginfo.importer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FilenameFormatException extends RuntimeException {
  private String message;
}
