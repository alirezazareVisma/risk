package nl.workshop.data.loader.trade;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trade")
public class Trade {

	private int id;
	private Date date;
	private float tradeValue;
	private String countryId;

	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	@XmlElement(name="date") 
	public Date getDate() {
		return date;
	}

	@XmlElement(name="tradeValue") 
	public float getTradeValue() {
		return tradeValue;
	}

	@XmlElement(name="countryId") 
	public String getCountryId() {
		return countryId;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTradeValue(float tradeValue) {
		this.tradeValue = tradeValue;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

}
