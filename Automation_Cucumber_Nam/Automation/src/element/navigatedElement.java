package element;

public class navigatedElement {
	String menuIcon = "//android.view.View[@index=0]/android.widget.ImageButton[@index=0]";
	String loginText = "//android.widget.LinearLayout[@index=5]/android.widget.TextView[@index=1]";
	String usernameText = "//android.widget.LinearLayout[@index=0]/android.widget.LinearLayout[@index=0]/android.widget.TextView[@index=1]";
	
	public String getMenuIconXpath() {
		return menuIcon;
	}
	
	public String getLoginTextXPath() {
		return loginText;
	}
	
	public String getUsernameXPath() {
		return usernameText;
	}
}
