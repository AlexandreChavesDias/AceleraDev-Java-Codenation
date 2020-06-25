package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {

		if (salarioBase < 1039.0)
			return Math.round(0.0);

		double salarioLiquido = salarioBase;

		// -INSS
		salarioLiquido -= calcularInss(salarioBase);
		// -IRSS
		salarioLiquido -= calcularIrrf(salarioLiquido);

		return Math.round(salarioLiquido);
	}

	private double calcularInss(double salarioBase) {

		double percentualInss;

		// Até R$ 1.500,00 8%
		if (salarioBase <= 1500.0) {
			percentualInss = 0.08;

		} // De R$ 1.500,01 até R$ 4.000,00 9%
		else if (salarioBase >= 1500.01 && salarioBase <= 4000.0) {
			percentualInss = 0.09;

		} else {// Acima de R$ 4.000,00 11%
			percentualInss = 0.11;
		}
		return salarioBase * percentualInss;
	}

	private double calcularIrrf(double salarioBruto) {
		double percentualIrrf;

		// Até R$ 3.000,00 ISENTO
		if (salarioBruto <= 3000.0) {
			return 0.0;
		}
		// De R$ 3.000,01 até R$ 6.000,00 7.5%
		else if (salarioBruto <= 6000.0) {
			percentualIrrf = 0.075;
		}
		// Acima de R$ 6.000,00 15%
		else {
			percentualIrrf = 0.15;
		}
		return salarioBruto * percentualIrrf;

	}
}
