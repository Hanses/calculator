package logic;

public class CalculatorImpl implements Calculator {

	@Override
	public double add(double operand1, double operand2) {
		return operand1 + operand2;
	}

	@Override
	public double subtract(double operand1, double operand2) {
		return operand1 - operand2;
	}

	@Override
	public double multiply(double operand1, double operand2) {
		return operand1 * operand2;
	}

	@Override
	public double divide(double operand1, double operand2) {
		if (operand2 == 0.0) {
			return 0.0;
		} else {
			return operand1 / operand2;
		}
	}

	@Override
	public double sqrt(double operand) {
		return Math.sqrt(operand);
	}

	@Override
	public double clear() {
		return 0;
	}

}
