package de.hdawg.rankinginfo.importer.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * exception indication an unknown nationality is encountered.
 */
@RequiredArgsConstructor
@Getter
public class UnknownNationalityException extends RuntimeException {
  private final String message;
}
