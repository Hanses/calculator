package logic;

public class CalculatorFactory {
	private static Calculator calc = null;
	public static Calculator getCalculator() {
		if (calc == null) {
			calc = new CalculatorImpl();
		}
		return calc;
	}
}
