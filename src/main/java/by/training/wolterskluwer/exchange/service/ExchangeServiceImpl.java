package by.training.wolterskluwer.exchange.service;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import by.training.wolterskluwer.exchange.exception.ExchangeException;
import by.training.wolterskluwer.exchange.generated.ConversionRate;
import by.training.wolterskluwer.exchange.generated.Currency;
import by.training.wolterskluwer.exchange.generated.CurrencyConvertor;
import by.training.wolterskluwer.exchange.generated.CurrencyConvertorSoap;
import by.training.wolterskluwer.exchange.interfaces.ExchangeService;
import by.training.wolterskluwer.exchange.model.Order;
import static by.training.wolterskluwer.exchange.constants.Constants.*;

@WebService(endpointInterface = "by.training.wolterskluwer.exchange.interfaces.ExchangeService")
public class ExchangeServiceImpl implements ExchangeService {
	private static final Logger LOGGER = Logger.getLogger(ExchangeServiceImpl.class);

	@Override
	public double getCurrencyExchange(Order order) throws ExchangeException {
		if (order.getFrom() == null || order.getTo() == null) {
			LOGGER.info("Error: currency is null.");
			throw new ExchangeException(ERROR_BAD_CURRENCY_SET);
		}
		
		LOGGER.info("Try to change " + order.getMoney() + " money. " + "From: " + order.getFrom() + " To: "
				+ order.getTo());
		ConversionRate rate = new ConversionRate();
		rate.setFromCurrency(Currency.fromValue(order.getFrom().toString()));
		rate.setToCurrency(Currency.fromValue(order.getTo().toString()));
		
		CurrencyConvertor convertor = new CurrencyConvertor();
		CurrencyConvertorSoap conv = convertor.getCurrencyConvertorSoap();
		
		String from = order.getFrom().toString();
		String to = order.getTo().toString();
		double ratio = conv.conversionRate(Currency.fromValue(from), Currency.fromValue(to));
		
		if (ratio < 0) {
			LOGGER.info("Error on external server. Ratio is negative.");
			throw new ExchangeException(ERROR_EXT_SERVER);
		}
		LOGGER.info("Ratio: " + ratio);
		return ratio * order.getMoney();
	}
}
