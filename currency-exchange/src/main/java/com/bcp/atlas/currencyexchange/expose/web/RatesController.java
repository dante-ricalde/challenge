package com.bcp.atlas.currencyexchange.expose.web;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE;

import com.bcp.atlas.currencyexchange.model.ExchangeRate;
import com.bcp.atlas.currencyexchange.service.ExchangeRateService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Mono;

/**
 * @author dante on 2020-02-28.
 * @project currency-exchange
 */
@RestController
@RequestMapping("/currency-exchange/rates")
@RequiredArgsConstructor
public class RatesController {

  private final ExchangeRateService exchangeRateService;

  @PutMapping(consumes = APPLICATION_STREAM_JSON_VALUE, produces = APPLICATION_STREAM_JSON_VALUE)
  public Single<ExchangeRate> update(@RequestBody Mono<ExchangeRate> exchangeRate) {
    return exchangeRateService.update(RxJava2Adapter.monoToSingle(exchangeRate));
  }

}
