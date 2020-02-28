package com.bcp.atlas.currencyexchange.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author dante on 2020-02-28.
 * @project currency-exchange
 */
@Builder
@Data
public class Rate {

  @Id
  private Long id;
  private String name;
  private Double value;
}
