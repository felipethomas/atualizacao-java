package design.pattern.strategy.calculadora.imposto;

public class ICMS implements Imposto {

	private double valor;

	public ICMS(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}

	@Override
	public double calcular() {
		return this.valor * 0.10;
	}

}
