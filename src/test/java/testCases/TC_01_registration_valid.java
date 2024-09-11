package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.homePage;
import pageObjects.registrationObjects;
import testBase.test_base;

public class TC_01_registration_valid extends test_base {

    @DataProvider(name = "registrationData")
    public Object[][] provideData() throws IOException {
        return readExcelData("testData/Test_data.xlsx");
    }

    private Object[][] readExcelData(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum();
            Object[][] data = new Object[rowCount][6];
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < 6; j++) {
                    if (row.getCell(j) != null) { // Check for null cells
                        switch (row.getCell(j).getCellType()) {
                            case STRING:
                                data[i - 1][j] = row.getCell(j).getStringCellValue();
                                break;
                            case NUMERIC:
                                // Check if the cell is formatted as a number and handle it accordingly
                                if (j == 3) { // Assuming phone number is in column 4 (index 3)
                                    data[i - 1][j] = String.valueOf((long) row.getCell(j).getNumericCellValue());
                                } else {
                                    data[i - 1][j] = String.valueOf(row.getCell(j).getNumericCellValue());
                                }
                                break;
                            default:
                                data[i - 1][j] = "";
                                break;
                        }
                    } else {
                        data[i - 1][j] = "";
                    }
                }
            }
            return data;
        }
    }


    @Test(dataProvider = "registrationData")
    public void test(String firstName, String lastName, String email, String phoneNumber, String password, String confirmPassword) {
        logger.info("*******this test case is started **************");

        homePage hp = new homePage(driver);
        hp.clckReg();
        logger.info("&&&&goes to homepage after clicking***********");

        registrationObjects rg = new registrationObjects(driver);
        rg.enterFname(firstName);
        rg.enterlname(lastName);
        rg.enterEmail(email);
        rg.enterMobile(phoneNumber);
        rg.enterPassword(password);
        rg.confirmPassword(confirmPassword);
        rg.clickCheckbox();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Scroll to the register button
        WebElement registerButton = driver.findElement(By.xpath("//input[@value='Register']"));
        js.executeScript("arguments[0].scrollIntoView(true);", registerButton);

        // Wait until the button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));

        // Click using JavaScript as a fallback
        js.executeScript("arguments[0].click();", registerButton);
    }
}
