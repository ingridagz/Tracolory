package lt.techin.tracolory.tests;

import lt.techin.tracolory.pages.TracaloriePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TracaloriePageTest extends BasePageTest {

    @Test
    void addNewItemAToListTest() {
        TracaloriePage tracaloriePage = new TracaloriePage(driver);

        tracaloriePage.addNewItemValue("cheese");
        tracaloriePage.addNewCalorieValue("1000");
        tracaloriePage.clickAddMealButton();

        String actual = tracaloriePage.getFirstElementText();

        Assertions.assertEquals("cheese: 1000 Calories", actual,"No ability to add item");
        System.out.println(actual);
    }

    @Test
    void countOfItemsBeforeAfterTest() {
        TracaloriePage tracaloriePage = new TracaloriePage(driver);

        int itemCountBefore = tracaloriePage.isNewItemOnList();
        System.out.println(("Result: Number of inputs before is: " + itemCountBefore));

        tracaloriePage.addNewItemValue("cheese");
        tracaloriePage.addNewCalorieValue("1000");
        tracaloriePage.clickAddMealButton();

        tracaloriePage.addNewItemValue("milk");
        tracaloriePage.addNewCalorieValue("2000");
        tracaloriePage.clickAddMealButton();

        int itemCountAfter = tracaloriePage.isNewItemOnList();
        System.out.println(("Result: Number of inputs after is: " + itemCountAfter));
    }

    @Test
    void deleteItemFromListTest() {
        TracaloriePage tracaloriePage = new TracaloriePage(driver);

        tracaloriePage.addNewItemValue("cheese");
        tracaloriePage.addNewCalorieValue("1000");
        tracaloriePage.clickAddMealButton();

        tracaloriePage.addNewItemValue("milk");
        tracaloriePage.addNewCalorieValue("2000");
        tracaloriePage.clickAddMealButton();

        tracaloriePage.goToPencilButton();
        tracaloriePage.clickDeleteMailButton();

        String deleteElementText = tracaloriePage.getLastElementText();
        System.out.println("Result: Is the item '" + deleteElementText + "' still in the list? "
                + tracaloriePage.isElementInList(deleteElementText));
    }

    @Test
    void UpdateItemTest() {

        TracaloriePage tracaloriePage = new TracaloriePage(driver);

        tracaloriePage.addNewItemValue("cheese");
        tracaloriePage.addNewCalorieValue("1000");
        tracaloriePage.clickAddMealButton();

        tracaloriePage.goToPencilButton();
        tracaloriePage.clearOldCalorieValue();
        tracaloriePage.addNewCalorieValue("2000");

        tracaloriePage.clickUpdateMealButton();

        Assertions.assertEquals("2000 Calories", tracaloriePage.updatedCalorieValue(), "No ability to update");
    }

    @Test
    void addNewItemAToListTestWithEmptyInput(){
        TracaloriePage tracaloriePage = new TracaloriePage(driver);

        int itemCountBefore = tracaloriePage.isNewItemOnList();
        System.out.println(("Result: Number of inputs before is: " + itemCountBefore));

        tracaloriePage.addNewItemValue("");
        tracaloriePage.addNewCalorieValue("");
        tracaloriePage.clickAddMealButton();

        tracaloriePage.addNewItemValue("");
        tracaloriePage.addNewCalorieValue("");
        tracaloriePage.clickAddMealButton();

        int itemCountAfter = tracaloriePage.isNewItemOnList();
        System.out.println(("Result: Number of inputs after is: " + itemCountAfter));
    }
}
