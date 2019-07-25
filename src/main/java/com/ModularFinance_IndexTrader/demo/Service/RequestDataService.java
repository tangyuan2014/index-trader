package com.ModularFinance_IndexTrader.demo.Service;

import com.ModularFinance_IndexTrader.demo.CustomizeConfig;
import com.ModularFinance_IndexTrader.demo.Entity.SourceData;
import com.ModularFinance_IndexTrader.demo.Entity.StockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RequestDataService {
	private final CustomizeConfig customizeConfig;
	private final RestTemplate restTemplate;

	@Autowired
	public RequestDataService(CustomizeConfig customizeConfig, RestTemplate restTemplate) {
		this.customizeConfig = customizeConfig;
		this.restTemplate = restTemplate;
	}

	public List<StockData> getDataList() {
		SourceData sourceData = restTemplate.getForObject(customizeConfig.getBaseUrl(), SourceData.class);
		List<StockData> data = sourceData.getData();
		return data;
	}
}
