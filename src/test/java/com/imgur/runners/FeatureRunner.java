package com.imgur.runners;


import io.cucumber.junit.CucumberOptions;

//@ExtendWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features", glue = {"by/onliner"}
)
public class FeatureRunner{


}
