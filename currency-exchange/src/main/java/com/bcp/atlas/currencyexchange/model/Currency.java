package com.bcp.atlas.currencyexchange.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public final class Currency {

  private String from;
  private String to;

  @JsonCreator
  public Currency(@JsonProperty("from") String from, @JsonProperty("to") String to) {
    this.from = from;
    this.to = to;
  }
}