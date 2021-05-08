package design.pattern.strategy.calculadora.imposto;

public class CalculadoraDeImposto {

	public static void main(String[] args) {
		CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
		ICMS icms = new ICMS(100.0);
		IPI ipi = new IPI(100.0);
		
		System.out.println(calculadora.calcular(icms));
		System.out.println(calculadora.calcular(ipi));
	}

	public double calcular(Imposto imposto) {
		return imposto.calcular();
	}

}
