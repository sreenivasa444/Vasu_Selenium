package testNGRealtime;

	    import org.openqa.selenium.WebDriver;
	    import org.openqa.selenium.WebElement;
	    import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	    public class LoginPage {
	    private WebDriver driver;

	    @FindBy(id = "txtUsername")
	    private WebElement usernameInput;

	    @FindBy(id = "txtPassword")
	    private WebElement passwordInput;

	    @FindBy(id = "btnLogin")
	    private WebElement loginButton;

	    public LoginPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver,this);
	    }

	    public void enterUsername(String username) {
	    usernameInput.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	    passwordInput.sendKeys(password);
	    }

	    public void clickLoginButton() {
	    loginButton.click();
	    }
	    }

