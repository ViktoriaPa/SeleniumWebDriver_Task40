package constants;

import org.openqa.selenium.By;

public class LocatorsConstants {
    public static final By LOGIN_BUTTON_ON_MAIN_PAGE = By.xpath("//a[@href='https://passport.yandex.com/auth?retpath=https%3A%2F%2Fmail.yandex.com']");
    public static final By USERNAME_FIELD = By.id("passp-field-login");
    public static final By LOGIN_BUTTON_ON_USERNAME_PAGE = By.id("passp:sign-in");
    public static final By PASSWORD_FIELD = By.id("passp-field-passwd");
    public static final By LOGIN_BUTTON_ON_PASSWORD_PAGE = By.id("passp:sign-in");
    public static final By USERNAME = By.xpath("//span[@class=\"user-account__name\"]");
    public static final By MULTISELECT = By.xpath("//select[@id=\"multi-select\"]");
    public static final By CONFIRM_BOX = By.xpath("//button[@onclick=\"myConfirmFunction()\"]");
    public static final By CONFIRM_BOX_MESSAGE = By.xpath("//p[@id=\"confirm-demo\"]");
    public static final By ALERT_BOX = By.xpath("//button[@onclick=\"myPromptFunction()\"]");
    public static final By ALERT_BOX_MESSAGE = By.xpath("//p[@id=\"prompt-demo\"]");
    public static final By GET_NEW_USER_BUTTON = By.xpath("//button[@id=\"save\"]");
    public static final By USER = By.xpath("//div[img and contains(text(), 'First Name ') and text()[contains(., \"Last Name\")]]");
    public static final By DOWNLOAD_PROGRESS_BUTTON = By.xpath("//button[@id=\"cricle-btn\"]");
    public static final By PERCENT_TEXT = By.xpath("//div[@class=\"percenttext\"]");
    public static final By SHOW_DROPDOWN = By.xpath("//select[@name=\"example_length\"]");
    public static final By TABLE = By.xpath("//table/tbody/tr");
    public static final By NEXT_BUTTON = By.xpath("//a[@id=\"example_next\"]");
}
