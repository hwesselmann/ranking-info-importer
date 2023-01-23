package de.hdawg.rankinginfo.importer.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * exception for errors in the import file naming.
 */
@RequiredArgsConstructor
@Getter
public class FilenameFormatException extends RuntimeException {
  private final String message;
}
