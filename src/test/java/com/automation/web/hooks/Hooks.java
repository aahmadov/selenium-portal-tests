package com.automation.web.hooks;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import static com.assertthat.selenium_shutterbug.core.Shutterbug.shootPage;

@Slf4j
public class Hooks {
    @Inject
    private WebDriver driver;

    @After
    public void after(Scenario scenario) {
        if(scenario.isFailed()) {
            takeScreenshot(scenario);
        }
        if (driver != null) {
            driver.quit();
        }
    }

    public void takeScreenshot(Scenario scenario) {
        BufferedImage image;

        try {
            image = shootPage(driver, Capture.FULL_SCROLL, 500).getImage();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", outputStream);
            outputStream.flush();
            byte[] imageInByte = outputStream.toByteArray();
            outputStream.close();
            scenario.attach(imageInByte, "image/png", "");

        } catch (Exception e) {
            log.warn("No screenshot taken for Test => {}", scenario.getName());
        }
    }
}
