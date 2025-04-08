package features;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import io.cucumber.junit.CucumberOptions;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline")
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
            "features.homepage.steps",
            "features.search.steps",
            "features.generic"
        },
        plugin = { "pretty", "html:target/cucumber-reports" }
)

public class CucumberTestSuite {
        
}
