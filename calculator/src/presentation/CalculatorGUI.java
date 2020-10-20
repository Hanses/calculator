package presentation;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.Calculator;

public class CalculatorGUI {

	private Calculator calculator;
	private Stage stage;
	private double result;
	private TextField operandText;
	private TextField resultText;

	public CalculatorGUI(Stage stage, Calculator calculator) {
		this.stage = stage;
		this.calculator = calculator;
	}

	public void start() {
		stage.setTitle("Hanses Lommeregner");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 300, 400);
		stage.setScene(scene);

		Text scenetitle = new Text("Lommeregner");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 4, 1);

		operandText = new TextField();
		grid.add(operandText, 0, 1, 5, 1);

		resultText = new TextField();
		resultText.setEditable(false);
		grid.add(resultText, 0, 2, 5, 1);

		Button ciffer7 = new Button("7");
		ciffer7.setOnAction(e -> append(e));
		grid.add(ciffer7, 0, 3);
		Button ciffer8 = new Button("8");
		ciffer8.setOnAction(e -> append(e));
		grid.add(ciffer8, 1, 3);
		Button ciffer9 = new Button("9");
		ciffer9.setOnAction(e -> append(e));
		grid.add(ciffer9, 2, 3);
		Button ciffer4 = new Button("4");
		ciffer4.setOnAction(e -> append(e));
		grid.add(ciffer4, 0, 4);
		Button ciffer5 = new Button("5");
		ciffer5.setOnAction(e -> append(e));
		grid.add(ciffer5, 1, 4);
		Button ciffer6 = new Button("6");
		ciffer6.setOnAction(e -> append(e));
		grid.add(ciffer6, 2, 4);
		Button ciffer3 = new Button("1");
		ciffer3.setOnAction(e -> append(e));
		grid.add(ciffer3, 0, 5);
		Button ciffer2 = new Button("2");
		ciffer2.setOnAction(e -> append(e));
		grid.add(ciffer2, 1, 5);
		Button ciffer1 = new Button("3");
		ciffer1.setOnAction(e -> append(e));
		grid.add(ciffer1, 2, 5);
		Button ciffer0 = new Button("0");
		ciffer0.setOnAction(e -> append(e));
		grid.add(ciffer0, 0, 6);
		Button punktum = new Button(".");
		punktum.setOnAction(e -> append(e));
		grid.add(punktum, 1, 6);
		
		Button plus = new Button("+");
		plus.setOnAction(e -> handle((x,y) -> calculator.add(x,y)));
		grid.add(plus, 3, 3);
		Button minus = new Button("-");
		minus.setOnAction(e -> handle((x,y) -> calculator.subtract(x,y)));
		grid.add(minus, 4, 3);
		Button gange = new Button("*");
		gange.setOnAction(e -> handle((x,y) -> calculator.multiply(x,y)));
		grid.add(gange, 3, 4);
		Button divider = new Button("/");
		divider.setOnAction(e -> handle((x,y) -> calculator.divide(x,y)));
		grid.add(divider, 4, 4);
		Button sqrt = new Button("Sqrt");
		sqrt.setOnAction(e -> handle(x -> calculator.sqrt(x)));
		grid.add(sqrt, 3, 5, 2, 1);
		Button clear = new Button("C");
		clear.setOnAction(e -> handle(() -> calculator.clear()));
		grid.add(clear, 3, 6);
		Button delete = new Button("<-");
		delete.setOnAction(e -> delete());
		grid.add(delete, 4, 6);

		resultText.setText(Double.toString(result));
		
		stage.show();
	}
	
//	private void append(String s) {
//		operandText.setText(operandText.getText() + s);
//	}
//
	private void delete( ) {
		String text = operandText.getText();
		if (text.length() > 0) {
			operandText.setText(text.substring(0, text.length()-1));
		}
	}
	
	private void append(ActionEvent event) {
		String text = ((Button) event.getSource()).getText();
		operandText.setText(operandText.getText() + text);
	}
	
	private void handle(DoubleBinaryOperator operator) {
		try {
			double operand = Double.parseDouble(operandText.getText());
			result = operator.applyAsDouble(result, operand);
			resultText.setText(Double.toString(result));
			stage.show();
		} catch (NumberFormatException e) {
			operandText.setText("Not a number");
		} catch (RuntimeException e) {
			operandText.setText(e.getMessage());
		}
	}

	private void handle(DoubleUnaryOperator operator) {
		try {
			result = operator.applyAsDouble(result);
			resultText.setText(Double.toString(result));
			stage.show();
		} catch (RuntimeException e) {
			operandText.setText(e.getMessage());
		}
	}

	private void handle(DoubleSupplier operator) {
		result = operator.getAsDouble();
		resultText.setText(Double.toString(result));
		stage.show();
	}
}
