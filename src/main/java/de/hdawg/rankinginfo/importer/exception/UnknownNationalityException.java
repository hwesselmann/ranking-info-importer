package de.hdawg.rankinginfo.importer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UnknownNationalityException extends RuntimeException {
  private final String message;
}
