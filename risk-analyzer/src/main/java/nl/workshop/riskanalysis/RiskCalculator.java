package nl.workshop.riskanalysis;

import java.util.Map;


public interface RiskCalculator {
	Double calculateRisk(Map<String, Object> map);
}
