package week4.HA;

// Execution class Elements
public class ExecutionClassElements {

	public static void main(String[] args) {
		Button button = new Button();
		button.click();
		button.setText("Submit");
		button.submit();

		TextField textField = new TextField();
		textField.click();
		textField.setText("Hello");
		System.out.println("Text: " + textField.getText());

		CheckBoxButton checkBoxButton = new CheckBoxButton();
		checkBoxButton.click();
		checkBoxButton.setText("Check");
		checkBoxButton.submit();
		checkBoxButton.clickCheckButton();

		RadioButton radioButton = new RadioButton();
		radioButton.click();
		radioButton.setText("Select");
		radioButton.submit();
		radioButton.selectRadioButton();
	}
}