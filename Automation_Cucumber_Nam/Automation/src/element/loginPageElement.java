package element;

public class loginPageElement {
	String loginTitle = "Đăng nhập";
	String usernameField = "//android.widget.LinearLayout[@index=1]/android.widget.EditText[@index=1]";
	String passwordField = "//android.widget.LinearLayout[@index=2]/android.widget.EditText[@index=1]";
	String loginButton = "//android.widget.LinearLayout[@index=0]/android.widget.Button[@index=4]";
	String text = "//android.widget.TextView[@index=5]";
	String registerButton = "//android.widget.LinearLayout[@index=0]/android.widget.Button[@index=6]";
	
	public String getElementXPath(String element) {
		switch (element) {
			case "LOGIN_TITLE":
				return loginTitle;
			case "USERNAME":
				return usernameField;
			case "PASSWORD":
				return passwordField;
			case "LOGIN_BUTTON":
				return loginButton;
			case "REGISTER_BUTTON":
				return registerButton;
			case "TEXT":
				return text;
			default:
				return "Can't find any element";
		}
	}
}
