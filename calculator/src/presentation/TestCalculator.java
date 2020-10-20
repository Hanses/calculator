package presentation;

import logic.Calculator;
import logic.CalculatorFactory;

public class TestCalculator {

	public static void main(String[] args) {
		Calculator cal = CalculatorFactory.getCalculator();
		System.out.println("2+3 = " + cal.add(2, 3));
	}

}
