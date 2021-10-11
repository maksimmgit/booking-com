package com.booking.api.runners;


import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "io.qameta.allure.cucumberjvm.AllureCucumberJvm"
        },
        features = "src/test/resources/features/api", glue = {"com/booking/api"}
)
public class FeatureRunnerTest {


}
