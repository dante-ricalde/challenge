package com.bcp.atlas.currencyexchange.repository;

import com.bcp.atlas.currencyexchange.entity.Rate;
import io.reactivex.Single;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author dante on 2020-02-28.
 * @project currency-exchange
 */
public interface RateRepository extends ReactiveCrudRepository<Rate, Long> {

  @Query("SELECT * FROM rate WHERE name = :name")
  Single<Rate> findByName(String name);

}
