package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static core.DriverFactory.getDriver;

public class TesteGoogle {
    @Test
    public void teste()  {
        getDriver().get("https://www.google.com");
        getDriver().manage().window().setSize(new Dimension(1200,765));
//        getDriver().manage().window().maximize();
        Assert.assertEquals("Google", getDriver().getTitle());
//        getDriver().quit();
    }

}
