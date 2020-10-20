package logic;

public class CalculatorFactory {
	public static Calculator getCalculator() {
		return new CalculatorImpl();
	}
}
