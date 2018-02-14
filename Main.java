package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.*;
import javafx.scene.layout.GridPane;
import javafx.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main extends Application {
	TextField t1 = new TextField();
	TextField t2 = new TextField();
	TextField t3 = new TextField();
	TextField t4 = new TextField();
	TextField t5 = new TextField();
	@Override
	public void start(Stage primaryStage) {
		
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		Label l1 = new Label("Annual Interest Rate:");
		t1.setAlignment(Pos.TOP_RIGHT);
		pane.setHgap(5);
		pane.setVgap(10);
		pane.add(l1, 0, 0);
		pane.add(t1, 1, 0);
		pane.setHalignment(t1, HPos.RIGHT);
		Label l2 = new Label("Number of Years:");
		t2.setAlignment(Pos.TOP_RIGHT);
		pane.add(l2, 0, 1);
		pane.add(t2, 1, 1);
		pane.setHalignment(t2, HPos.RIGHT);
		Label l3 = new Label("Loan Amount:");
		t3.setAlignment(Pos.TOP_RIGHT);
		pane.add(l3, 0, 2);
		pane.add(t3, 1, 2);
		pane.setHalignment(t3, HPos.RIGHT);
		Label l4 = new Label("Monthly Payment:");
		t4.setAlignment(Pos.TOP_RIGHT);
		pane.add(l4, 0, 3);
		pane.add(t4, 1, 3);
		pane.setHalignment(t4, HPos.RIGHT);
		Label l5 = new Label("Total Payment:");
		t5.setAlignment(Pos.TOP_RIGHT);
		t5.setEditable(false);
		t4.setEditable(false);
		pane.add(l5, 0, 4);
		pane.add(t5, 1, 4);
		pane.setHalignment(t5, HPos.RIGHT);
		Button b1 = new Button("Calculate");
		pane.add(b1, 1, 5);
		pane.setHalignment(b1, HPos.RIGHT);
		b1.setOnAction(e -> {calculateLoanPayment();});
		Scene scene = new Scene(pane);
		primaryStage.setTitle("LoanCalculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void calculateLoanPayment() {
		
		double interest = Double.parseDouble(t1.getText());
		double years = Double.parseDouble(t2.getText());
		double amount = Double.parseDouble(t3.getText());
		double monthlyPayment = getMonthlyPayment(interest, amount, years);
		double totalPayment = getTotalPayment(monthlyPayment, years);
		t4.setText(String.format("$%.2f", monthlyPayment));
		t5.setText(String.format("$%.2f", totalPayment));
	}
	
	public double getMonthlyPayment(double interest, double amount, double years) {
		
		double monthlyRate = interest/1200;
		double monthlyPayment = amount * monthlyRate / (1- (1/Math.pow(1+monthlyRate, years*12)));
		return monthlyPayment;
	}
	
	public double getTotalPayment(double monthlyPayment, double years) {
		
		double totalPayment = monthlyPayment * years * 12;
		return totalPayment;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
