package core;


import base.DSL;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

public class BasePage {
    protected DSL dsl = new DSL();

    @Rule
    public TestName testName = new TestName();

    @After
    public void fechar() throws IOException {
        TakesScreenshot screen = (TakesScreenshot) getDriver();
        File arquivo =screen.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "sreenshot" + File.separator  + testName.getMethodName() + ".jpg"));
        if (Propriedade.FECHAR_BROWSER)
                killDriver();
    }
}
