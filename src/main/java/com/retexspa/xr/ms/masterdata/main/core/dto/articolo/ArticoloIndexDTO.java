package com.retexspa.xr.ms.masterdata.main.core.dto.articolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.LinkedList;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
public class ArticoloIndexDTO {

  private String articoloId;
  // DONE IN INDEXAGGREGATE AND EVENTHANDLER
  private LinkedList<String> articoloIds;
  private LinkedList<String> tassonomiaIds;
  private LinkedList<String> articoloTassonomiaIds;
  private LinkedList<String> anagraficaServizioIds;
  private LinkedList<String> articoloInfoServizioIds;
  private LinkedList<String> figliIds;
  private LinkedList<String> articoloVenditaIds;
  private LinkedList<String> articoloNastroPrezziIds;
  private LinkedList<String> articoloEanIds;
  private LinkedList<String> commissioniServizioIds;

  public ArticoloIndexDTO() {}

  public ArticoloIndexDTO(String articoloId) {
    this.articoloId = articoloId;
  }

  public static String getIdFromArticolo(String articoloId) {
    return UUID.nameUUIDFromBytes(("/ArticoloIndex/" + articoloId).getBytes()).toString();
  }

  public String getArticoloId() {
    return this.articoloId;
  }

  public void setArticoloId(String articoloId) {
    this.articoloId = articoloId;
  }

  public LinkedList<String> getArticoloVenditaIds() {
    return this.articoloVenditaIds;
  }

  public void setArticoloVenditaIds(LinkedList<String> articoloVenditaIds) {
    this.articoloVenditaIds = articoloVenditaIds;
  }

  public LinkedList<String> getArticoloIds() {
    return this.articoloIds;
  }

  public void setArticoloIds(LinkedList<String> articoloIds) {
    this.articoloIds = articoloIds;
  }

  public LinkedList<String> getTassonomiaIds() {
    return tassonomiaIds;
  }

  public void setTassonomiaIds(LinkedList<String> tassonomiaIds) {
    this.tassonomiaIds = tassonomiaIds;
  }

  public LinkedList<String> getArticoloEanIds() {
    return articoloEanIds;
  }

  public void setArticoloEanIds(LinkedList<String> articoloEanIds) {
    this.articoloEanIds = articoloEanIds;
  }

  public LinkedList<String> getArticoloNastroPrezziIds() {
    return articoloNastroPrezziIds;
  }

  public void setArticoloNastroPrezziIds(LinkedList<String> articoloNastroPrezziIds) {
    this.articoloNastroPrezziIds = articoloNastroPrezziIds;
  }

  public LinkedList<String> getAnagraficaServizioIds() {
    return anagraficaServizioIds;
  }

  public void setAnagraficaServizioIds(LinkedList<String> anagraficaServizioIds) {
    this.anagraficaServizioIds = anagraficaServizioIds;
  }

  public LinkedList<String> getCommissioniServizioIds() {
    return commissioniServizioIds;
  }

  public void setCommissioniServizioIds(LinkedList<String> commissioniServizioIds) {
    this.commissioniServizioIds = commissioniServizioIds;
  }

  public LinkedList<String> getArticoloTassonomiaIds() {
    return articoloTassonomiaIds;
  }

  public void setArticoloTassonomiaIds(LinkedList<String> articoloTassonomiaIds) {
    this.articoloTassonomiaIds = articoloTassonomiaIds;
  }

  public LinkedList<String> getFigliIds() {
    return figliIds;
  }

  public void setFigliIds(LinkedList<String> figliIds) {
    this.figliIds = figliIds;
  }

  public LinkedList<String> getArticoloInfoServizioIds() {
    return articoloInfoServizioIds;
  }

  public void setArticoloInfoServizioIds(LinkedList<String> articoloInfoServizioIds) {
    this.articoloInfoServizioIds = articoloInfoServizioIds;
  }

  public static String getDetailNameArticolo() { return "articoloIds";}

  public static String getDetailNameTassonomia() {
    return "tassonomiaIds";
  }

  public static String getDetailNameArticoloTassonomia() {
    return "articoloTassonomiaIds";
  }

  public static String getDetailNameAnagraficaServizio() {
    return "anagraficaServizioIds";
  }

  public static String getDetailNameArticoloInfoServizo() {
    return "articoloInfoServizioIds";
  }

  public static String getDetailNameFigli() { return "figliIds"; }

  public static String getDetailNameArticoloVendita() {
    return "articoloVenditaIds";
  }

  public static String getDetailNameArticoloNastroPrezzi() {
    return "articoloNastroPrezziIds";
  }

  public static String getDetailNameArticoloEan() {
    return "articoloEanIds";
  }

  public static String getDetailNameCommissioneServizio() {
    return "commissioniServizioIds";
  }

}
