package design.pattern.strategy.metodo.pagamento;

/**
 * Common interface for all strategies.
 */
public interface PayStrategy {
	
	boolean pay(int paymentAmount);

	void collectPaymentDetails();
}
