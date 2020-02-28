package com.bcp.atlas.currencyexchange.model;

import lombok.Data;

/**
 * @author dante on 2020-02-28.
 * @project currency-exchange
 */
@Data
public final class ExchangeRate {

  private String name;
  private Double value;

}
