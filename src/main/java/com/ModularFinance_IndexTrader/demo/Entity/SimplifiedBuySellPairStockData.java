package com.ModularFinance_IndexTrader.demo.Entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SimplifiedBuySellPairStockData {
	private int dateOfBuy;
	private int dateOfSell;
	private BigDecimal priceOfBuy;
	private BigDecimal priceOfSell;

	public SimplifiedBuySellPairStockData(BuySellPairStockData buySellPairStockData) {
		dateOfBuy = buySellPairStockData.getBuyStockData().getQuoteDate();
		dateOfSell = buySellPairStockData.getSellStockData().getQuoteDate();
		priceOfBuy = buySellPairStockData.getBuyStockData().getLow();
		priceOfSell = buySellPairStockData.getSellStockData().getHigh();
	}
}
