package week4.HA;

//Additional subclass CheckBoxButton
public class CheckBoxButton extends Button {
	public void clickCheckButton() {
		System.out.println("Checkbox button clicked");
	}
}

//Another subclass RadioButton
class RadioButton extends Button {
	public void selectRadioButton() {
		System.out.println("Radio button selected");
	}
}