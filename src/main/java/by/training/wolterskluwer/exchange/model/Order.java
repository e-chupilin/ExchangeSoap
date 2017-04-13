package by.training.wolterskluwer.exchange.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import by.training.wolterskluwer.exchange.enums.ExchangeCurrency;

@XmlRootElement(name = "order")
public class Order {
	@XmlElement(name = "money", required = true)
	private Double moneyToExchange;
	@XmlElement(name = "from", required = true)
	private ExchangeCurrency currencyFrom;
	@XmlElement(name = "to", required = true)
	private ExchangeCurrency currencyTo;
	
	
	public Double getMoney() {
		return moneyToExchange;
	}

	public ExchangeCurrency getFrom() {
		return currencyFrom;
	}

	public ExchangeCurrency getTo() {
		return currencyTo;
	}	
}
