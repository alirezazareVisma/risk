package nl.workshop.riskanalysis;

import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class TradingRiskCalculator implements RiskCalculator{

	public Double calculateRisk(Map<String, Object> map) {
		return 0.0;
	}

}
