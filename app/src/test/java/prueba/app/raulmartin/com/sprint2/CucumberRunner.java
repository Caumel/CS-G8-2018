package prueba.app.raulmartin.com.sprint2;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Created by marcela on 22/4/18.
 */

@RunWith(Cucumber.class)
@CucumberOptions( features = {"app/src/test/Resources/features/MoveBall.feature",
                                "app/src/test/Resources/features/Game.feature"})
public class CucumberRunner {
}






