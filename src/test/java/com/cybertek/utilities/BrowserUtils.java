package com.cybertek.utilities;
        import org.openqa.selenium.WebElement;

        import java.util.ArrayList;
        import java.util.List;
public class BrowserUtils {
    //takes a list of WebElements
    //returns a list of strings
    public static List<String> getElementsText(List<WebElement> listElem){
        List<String> listString = new ArrayList<>();
        for (WebElement eachElement:listElem) {
            listString.add(eachElement.getText());
        }
        return listString;
    }
}
