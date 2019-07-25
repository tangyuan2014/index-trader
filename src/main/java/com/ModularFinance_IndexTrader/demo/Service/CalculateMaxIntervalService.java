package com.ModularFinance_IndexTrader.demo.Service;

import com.ModularFinance_IndexTrader.demo.Entity.BuySellPairStockData;
import com.ModularFinance_IndexTrader.demo.Entity.StockData;
import com.ModularFinance_IndexTrader.demo.Utils.BigDecimalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateMaxIntervalService {
	private final BigDecimalUtils bigDecimalUtils;

	@Autowired
	public CalculateMaxIntervalService(BigDecimalUtils bigDecimalUtils) {
		this.bigDecimalUtils = bigDecimalUtils;
	}

	public List<BuySellPairStockData> getMaxIndex(List<StockData> stockDataList) {
		int totalSize = stockDataList.size();
		int indexOfLow = totalSize - 1;

		List<BuySellPairStockData> list = new ArrayList<>();
		BigDecimal valueOfLow = BigDecimal.valueOf(Double.MAX_VALUE);
		BigDecimal maxProfit = BigDecimal.ZERO;

		for (int i = totalSize - 1; i >= 0; i--) {
			if (stockDataList.get(i).getLow().compareTo(valueOfLow) <= 0) {
				valueOfLow = stockDataList.get(i).getLow();
				indexOfLow = i;
			}
			BigDecimal res = bigDecimalUtils.sub(stockDataList.get(i).getHigh().doubleValue(), valueOfLow.doubleValue());
			if (res.compareTo(maxProfit) == 0) {
				list.add(generateNewPair(stockDataList, indexOfLow, i));
			}
			if (res.compareTo(maxProfit) >= 1) {
				maxProfit = res;
				list.clear();
				list.add(generateNewPair(stockDataList, indexOfLow, i));
			}
		}
		return list;
	}

	private BuySellPairStockData generateNewPair(List<StockData> stockDataList, int numOfLow, int numOfHigh) {
		BuySellPairStockData anotherBuySellPairStockData = new BuySellPairStockData();
		anotherBuySellPairStockData.setBuyStockData(stockDataList.get(numOfLow));
		anotherBuySellPairStockData.setSellStockData(stockDataList.get(numOfHigh));
		return anotherBuySellPairStockData;
	}
}
