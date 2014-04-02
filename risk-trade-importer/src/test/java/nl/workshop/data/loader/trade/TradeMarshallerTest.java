package nl.workshop.data.loader.trade;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TradeMarshallerTest {
	@Autowired
	private Marshaller marshaller;

	@Autowired
	private Unmarshaller unmarshaller;

	@Test
	public void marshallerTest() throws XmlMappingException, IOException {
		String fileName = "trade.xml";
		Trade trade = new Trade();
		trade.setCountryId("NL");
		trade.setId(11);
		trade.setDate(new Date());
		trade.setTradeValue(22.2f);

		FileWriter writer = new FileWriter(fileName);
		StreamResult streamResult = new StreamResult(writer);
		marshaller.marshal(trade, streamResult);

		
		
		trade = null;
		assertNull(trade);
		
		File f = new File(fileName);
		FileInputStream fis = new FileInputStream(f);
		trade = (Trade) unmarshaller.unmarshal(new StreamSource(fis));

		assertNotNull(trade);
		assertEquals("NL", trade.getCountryId());
	
	}


}
