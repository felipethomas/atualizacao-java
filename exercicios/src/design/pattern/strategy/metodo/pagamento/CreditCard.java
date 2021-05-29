package design.pattern.strategy.metodo.pagamento;

/**
 * Dummy credit card class.
 */
public class CreditCard {
	
	private int amount;
	private String number;
	private String date;
	private String cvv;

	CreditCard(String number, String date, String cvv) {
		this.amount = 100_000;
		this.number = number;
		this.date = date;
		this.cvv = cvv;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getCvv() {
		return cvv;
	}
}
