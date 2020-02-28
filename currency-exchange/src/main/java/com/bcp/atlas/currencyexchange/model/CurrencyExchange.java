package com.bcp.atlas.currencyexchange.model;

import lombok.Data;

/**
 * @author dante on 2020-02-28.
 * @project currency-exchange
 */
@Data
public final class CurrencyExchange {

  private double amount;
  private Currency currency;

}
