package by.training.wolterskluwer.exchange.exception;

import javax.xml.ws.WebFault;

public class ExchangeException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExchangeException() {
		super();
	}

	public ExchangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExchangeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExchangeException(String message) {
		super(message);
	}

	public ExchangeException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return "ExchangeException [getMessage()=" + getMessage() + "]";
	}
}