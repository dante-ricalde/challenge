package com.bcp.atlas.currencyexchange.service;

import com.bcp.atlas.currencyexchange.model.ExchangeRate;
import com.bcp.atlas.currencyexchange.repository.RateRepository;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.adapter.rxjava.RxJava2Adapter;

/**
 * @author dante on 2020-02-28.
 * @project currency-exchange
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateService {

  private final RateRepository rateRepository;

  public Single<ExchangeRate> update(Single<ExchangeRate> exchangeRate) {
    return exchangeRate
        .flatMap(er -> {
          log.info("Updating exchange rate => {}", er);
          return rateRepository.findByName(er.getName())
              .flatMap(rate -> {
                rate.setValue(er.getValue());
                return RxJava2Adapter.monoToSingle(rateRepository.save(rate)
                    .map(updatedRate -> er));
              });
        });
  }

}
