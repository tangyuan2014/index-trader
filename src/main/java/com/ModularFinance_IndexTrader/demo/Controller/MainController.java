package com.ModularFinance_IndexTrader.demo.Controller;

import com.ModularFinance_IndexTrader.demo.Entity.BuySellPairStockData;
import com.ModularFinance_IndexTrader.demo.Entity.SimplifiedBuySellPairStockData;
import com.ModularFinance_IndexTrader.demo.Entity.StockData;
import com.ModularFinance_IndexTrader.demo.Service.CalculateMaxIntervalService;
import com.ModularFinance_IndexTrader.demo.Service.RequestDataService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

	private final CalculateMaxIntervalService calculateMaxIntervalService;

	private final RequestDataService requestDataService;

	@Autowired
	public MainController(CalculateMaxIntervalService calculateMaxIntervalService, RequestDataService requestDataService) {
		this.calculateMaxIntervalService = calculateMaxIntervalService;
		this.requestDataService = requestDataService;
	}

	@GetMapping("/answertopuzzle")
	public List<SimplifiedBuySellPairStockData> answerToPuzzle() throws Exception {
		List<StockData> stockDataList = requestDataService.getDataList();
		List<BuySellPairStockData> listOfData = calculateMaxIntervalService.getMaxIndex(stockDataList);
		return getBestBuySell(listOfData);
	}

	private List<SimplifiedBuySellPairStockData> getBestBuySell(List<BuySellPairStockData> listOfData) {
		List<SimplifiedBuySellPairStockData> listOfSimplifiedBuySellPairStockData = Lists.newArrayList();
		for (BuySellPairStockData data : listOfData) {
			listOfSimplifiedBuySellPairStockData.add(new SimplifiedBuySellPairStockData(data));
		}
		return listOfSimplifiedBuySellPairStockData;
	}
}
