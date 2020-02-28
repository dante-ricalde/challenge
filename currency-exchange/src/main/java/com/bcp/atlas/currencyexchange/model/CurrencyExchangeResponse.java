package com.bcp.atlas.currencyexchange.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author dante on 2020-02-28.
 * @project currency-exchange
 */
@Builder
@Data
public final class CurrencyExchangeResponse {

  private double amount;
  private double exchangedAmount;

  private Currency currency;
  private double rate;

}
