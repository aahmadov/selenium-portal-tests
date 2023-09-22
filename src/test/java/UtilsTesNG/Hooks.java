package UtilsTesNG;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @After
    public void after(Scenario scenario) {
        SetProperty.closeDriverTestNG();
    }
}
