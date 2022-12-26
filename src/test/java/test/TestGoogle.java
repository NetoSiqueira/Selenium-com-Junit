package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;

import static core.DriverFactory.getDriver;

public class TestGoogle {
    @Test
    public void teste()  {
        getDriver().get("https://www.google.com");
        getDriver().manage().window().setSize(new Dimension(1200,765));
//        getDriver().manage().window().maximize();
        Assert.assertEquals("Google", getDriver().getTitle());
//        getDriver().quit();
    }

}
