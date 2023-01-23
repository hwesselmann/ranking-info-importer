package de.hdawg.rankinginfo.importer.model;

/**
 * model enum for German Tennis federations.
 */
public enum Federation {
  BAD("Baden"),
  BB("Berlin-Brandenburg"),
  BTV("Bayern"),
  HAM("Hamburg"),
  HTV("Hessen"),
  RPF("Rheinland-Pfalz"),
  SLH("Schleswig-Holstein"),
  STB("Saarland"),
  STV("Sachsen"),
  TMV("Mecklenburg-Vorpommern"),
  TNB("Niedersachsen-Bremen"),
  TSA("Sachsen-Anhalt"),
  TTV("Thüringen"),
  TVM("Mittelrhein"),
  TVN("Niederrhein"),
  WTB("Würtemberg"),
  WTV("Westfalen");

  private final String longName;

  Federation(String longName) {
    this.longName = longName;
  }

  /**
   * get the long value for the enum value.
   *
   * @return long name of enum value
   */
  public String value() {
    return longName;
  }
}
