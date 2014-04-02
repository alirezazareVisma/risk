package nl.workshop.riskanalysis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TradingRiskCalculatorTest {

	@Autowired
	private RiskCalculator riskCalculator;

	@Test
	public void returnsZero() {
		assertEquals(new Double(0.0), riskCalculator.calculateRisk(null));
	}

}
