package com.cybertek.tests.WebTables;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
public class WebTables extends TestBase {
    @BeforeMethod
    public void setUpTest() {
        String url = ConfigurationReader.getProperty("url") + "/tables";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test//TODO print the whole table
    public void tables() {
        WebElement tableOne = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(tableOne.getText());
    }
    @Test//TODO print the headers
    public void headers() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());
        System.out.println(BrowserUtils.getElementsText(headers));
        //TODO Find cell (cell 2) in a table in relation to other cell (cell 1) in same row:
        WebElement email = driver.findElement(By.xpath("//table[@id='table1']//td[.='Jason']/../td[3]"));
        System.out.println("email= " + email.getText());
    }
    @Test //TODO get table size
    public void size() {
        //get nr of cols
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Numbers of colums:" + headers.size());
        //get nr of rows including header
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Numbers of rows: " + rows.size());
        //get nr of rows NOT including header
        List<WebElement> rowsNotIncludingHeader = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        System.out.println("Numbers of rowsNotIncludingHeader: " + rowsNotIncludingHeader.size());
    }
    @Test //TODO GET SINGLE ROW BY INDEX
    public void getSingleRowByIndex() {
        //TODO get the first row (in the body)
        WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println(row.getText());
        // TODO get the first row (in the body) dynamic xpath
        String xpath = getTableRowXpath(3);
        row = driver.findElement(By.xpath(xpath));
        System.out.println(row.getText());
    }
        @Test
        public void getSingleBasedByIndex(){
            WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
            System.out.println(cell.getText());

        String xpath1 = getCellpathByIndex(2,4);
        cell = driver.findElement(By.xpath(xpath1));
        System.out.println(cell.getText());

    }
    // TODO getTableRowXpath based on index
    public static String getTableRowXpath(int index) {
        String xpath2 = "//table[@id='table1']/tbody/tr[" + index + "]";
        return xpath2;
    }
    public static String getCellpathByIndex(int row,int column){
            String xpath3 = "//table[@id='table1']/tbody/tr["+row+"]/td["+column+"]";
            return xpath3;
        }

        @Test //go through the table using loops and get all values
    public void allValues(){
        //get number of rows
            int rowCount = getRowCount();
            //get number of cols
            int colsCount = getColsCount();

            for (int i = 1; i <=rowCount ; i++) {
                for (int j = 1; j <=colsCount ; j++) {
                    String xpath = getCellpathByIndex(i, j);
                    WebElement cell = driver.findElement(By.xpath(xpath));
                    System.out.println(cell.getText());
                 }
            }
       }
        public int getRowCount(){
        return driver.findElements(By.xpath("//table[@id='table1']//tbody//tr")).size();
        }
        public int getColsCount(){
        return driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        }
    }



