package presentation;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.Calculator;
import logic.CalculatorFactory;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Calculator calc = CalculatorFactory.getCalculator();
		CalculatorGUI gui = new CalculatorGUI(primaryStage, calc);
		gui.start();
	}

}
