package com.ModularFinance_IndexTrader.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockData {
	@JsonProperty("quote_date")
	private int quoteDate;
	private BigDecimal high;
	private BigDecimal low;
}
