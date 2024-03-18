package week4.HA;

//Base class WebElement
public class WebElement {
	public void click() {
		System.out.println("WebElement clicked");
	}

	public void setText(String text) {
		System.out.println("Text set to: " + text);
	}
}

//Subclass Button
class Button extends WebElement {
	public void submit() {
		System.out.println("Button submitted");
	}
}

//Subclass TextField
class TextField extends WebElement {
	public String getText() {
		return "Text from TextField";
	}
}


