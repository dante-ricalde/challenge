package com.bcp.atlas.currencyexchange.service;

import com.bcp.atlas.currencyexchange.model.Currency;
import com.bcp.atlas.currencyexchange.model.CurrencyExchange;
import com.bcp.atlas.currencyexchange.model.CurrencyExchangeResponse;
import com.bcp.atlas.currencyexchange.repository.RateRepository;
import io.reactivex.Single;
import java.util.function.DoubleUnaryOperator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dante on 2020-02-28.
 * @project currency-exchange
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {

  private final RateRepository rateRepository;

  public Single<CurrencyExchangeResponse> exchange(Single<CurrencyExchange> currencyExchange) {
    return currencyExchange
        .flatMap(ce -> {
          log.info("exchange invoked for => {}", ce);
          if ("USD".equalsIgnoreCase(ce.getCurrency().getFrom())) {
            return getCurrencyExchangeResponse(ce, ce.getCurrency().getTo(),
                rate -> ce.getAmount() * rate);
          } else if ("USD".equalsIgnoreCase(ce.getCurrency().getTo())) {
            return getCurrencyExchangeResponse(ce, ce.getCurrency().getFrom(),
                rate -> ce.getAmount() / rate);
          } else {
            return rateRepository.findByName(ce.getCurrency().getFrom())
                .flatMap(fromRate -> {
                  double auxAmount = ce.getAmount() / fromRate.getValue();
                  return getCurrencyExchangeResponse(ce, ce.getCurrency().getTo(),
                      rate -> auxAmount * rate);
                });
          }
        });
  }

  private Single<CurrencyExchangeResponse> getCurrencyExchangeResponse(
      final CurrencyExchange ce,
      final String currencyToSearch,
      final DoubleUnaryOperator exchangedAmount) {
    return rateRepository.findByName(currencyToSearch)
        .map(toRate -> CurrencyExchangeResponse
            .builder()
            .amount(ce.getAmount())
            .exchangedAmount(exchangedAmount.applyAsDouble(toRate.getValue()))
            .rate(toRate.getValue())
            .currency(Currency
                .builder()
                .from(ce.getCurrency().getFrom())
                .to(ce.getCurrency().getTo())
                .build())
            .build());
  }

}
