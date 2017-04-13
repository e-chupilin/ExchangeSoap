package by.training.wolterskluwer.exchange.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import by.training.wolterskluwer.exchange.exception.ExchangeException;
import by.training.wolterskluwer.exchange.model.Order;

@WebService
public interface ExchangeService {
	@WebMethod
	@WebResult(name = "result")
	double getCurrencyExchange(@WebParam(name = "order")Order order) throws ExchangeException;
}
