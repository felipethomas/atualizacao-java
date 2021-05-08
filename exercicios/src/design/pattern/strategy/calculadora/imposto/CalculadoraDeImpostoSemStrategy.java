package design.pattern.strategy.calculadora.imposto;

public class CalculadoraDeImpostoSemStrategy {
	
	public static void main(String[] args) {
		CalculadoraDeImpostoSemStrategy calculadora = new CalculadoraDeImpostoSemStrategy();
		
		System.out.println(calculadora.calcular("ICMS", 100.00));
		System.out.println(calculadora.calcular("IPI", 100.00));
	}

	public double calcular(String imposto, double valor) {
		if (imposto.equals("ICMS"))
			return valor * 0.10;
		else if (imposto.equals("IPI"))
			return valor * 0.20;
		else if (imposto.equals("NOVO_IMPOSTO"))
			return valor * 0.50;
		return valor;
	}

}
