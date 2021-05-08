package design.pattern.strategy.calculadora.imposto;

public class IPI implements Imposto {

	private double valor;

	public IPI(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}

	@Override
	public double calcular() {
		return this.valor * 0.20;
	}

}
