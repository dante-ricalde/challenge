package com.bcp.atlas.currencyexchange.expose.web;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE;

import com.bcp.atlas.currencyexchange.model.CurrencyExchange;
import com.bcp.atlas.currencyexchange.model.CurrencyExchangeResponse;
import com.bcp.atlas.currencyexchange.service.CurrencyExchangeService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

  private final CurrencyExchangeService currencyExchangeService;

  @PostMapping(value = "exchange", consumes = APPLICATION_STREAM_JSON_VALUE, produces = APPLICATION_STREAM_JSON_VALUE)
  public Single<CurrencyExchangeResponse> exchange(@RequestBody Mono<CurrencyExchange> currencyExchange) {
    return currencyExchangeService.exchange(RxJava2Adapter.monoToSingle(currencyExchange));

  }

}
