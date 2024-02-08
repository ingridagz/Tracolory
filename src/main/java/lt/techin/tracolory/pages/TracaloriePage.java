package lt.techin.tracolory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TracaloriePage extends BasePage {


    public TracaloriePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='item-name']")
    WebElement itemInput;
    @FindBy(xpath = "//input[@id='item-calories']")
    WebElement calorieInput;
    @FindBy(xpath = "//form[@class='col']/div/button[1]")
    WebElement addMealButton;

    @FindBy(xpath = "//ul[@id='item-list']/li[1]")
    WebElement firstItem;

    @FindBy(xpath = "//ul[@id='item-list']/li[last()]")
    WebElement lastItem;

    @FindBy(css = "ul > li")
    List<WebElement> items;

    @FindBy(xpath = "//i[@class='edit-item fa fa-pencil']")
    WebElement pencilButton;

    @FindBy(css = ".delete-btn")
    WebElement deleteMailButton;

    @FindBy(css = ".btn.orange.update-btn")
    WebElement updateMealButton;

    public void addNewItemValue(String newItemText) {
        itemInput.sendKeys(newItemText);
    }

    public void addNewCalorieValue(String newCalorieText) {
        calorieInput.sendKeys(newCalorieText);
    }

    public void clickAddMealButton() {
        addMealButton.click();
    }

    public String getFirstElementText() {
        return firstItem.getText();
    }

    public String getLastElementText() {
        return lastItem.getText();
    }

    public int isNewItemOnList() {
        return items.size();
    }
    public void goToPencilButton() {
            Actions goTo = new Actions(driver);
            goTo.moveToElement(pencilButton).perform();
            pencilButton.click();
        }

    public void clickDeleteMailButton() {
        deleteMailButton.click();
    }

    public boolean isElementInList(String deleteElementText) {
        for (WebElement item : items) {
            if (item.getText().equals(deleteElementText)) {
                return false;
            }
        }
        return true;
    }

    public void clearOldCalorieValue() {
        calorieInput.clear();
    }

    public void clickUpdateMealButton() {
        updateMealButton.click();
    }

    public String updatedCalorieValue(){
        return getLastElementText().split(":")[1].trim();
    }
}
