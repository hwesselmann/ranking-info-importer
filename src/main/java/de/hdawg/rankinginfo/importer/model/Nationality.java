package de.hdawg.rankinginfo.importer.model;

public enum Nationality {
  ARG("Argentinien"),
  AUS("Australien"),
  AUT("Österreich"),
  BEL("Belgien"),
  BIH("Bosnien-Herzegowina"),
  BLR("Belarus"),
  BRA("Brasilien"),
  BUL("Bulgarien"),
  CAN("Kanada"),
  CHN("China"),
  CRO("Kroatien"),
  CYP("Zypern"),
  CZE("Tschechien"),
  DEN("Dänemark"),
  ESP("Spanien"),
  EST("Estland"),
  FIN("Finnland"),
  FRA("Frankreich"),
  GBR("Großbritannien"),
  GEO("Georgien"),
  GER("Deutschland"),
  GRE("Griechenland"),
  HUN("Ungarn"),
  INA("Indonesien"),
  IND("Indien"),
  IRI("Iran"),
  IRL("Irland"),
  ITA("Italien"),
  JOR("Jordanien"),
  JPN("Japan"),
  KAZ("Kasachstan"),
  KGZ("Kirgistan"),
  LAT("Lettland"),
  LTU("Litauen"),
  LUX("Luxemburg"),
  MDA("Republik Moldau"),
  MEX("Mexiko"),
  MKD("Mazedonien"),
  MRI("Mauritius"),
  NAM("Nabimia"),
  NED("Niederlande"),
  NOR("Norwegen"),
  NZL("Neuseeland"),
  PER("Peru"),
  POL("Polen"),
  POR("Portugal"),
  ROU("Rumänien"),
  RSA("Südafrika"),
  RUS("Russland"),
  SER("Serbien"),
  SLO("Slowenien"),
  SRB("Serbien"),
  SUI("Schweiz"),
  SVK("Slowakei"),
  SWE("Schweden"),
  SYR("Syrien"),
  THA("Thailand"),
  TPE("Taiwan"),
  TUR("Türkei"),
  UKR("Ukraine"),
  USA("USA"),
  VEN("Venezuela"),
  VIE("Vietnam");

  private final String fullname;

  private Nationality(String longname) {
    this.fullname = longname;
  }
}
