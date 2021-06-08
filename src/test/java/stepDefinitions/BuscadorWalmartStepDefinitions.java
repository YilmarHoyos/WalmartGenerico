package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.SeleniumWebDriver;
import net.thucydides.core.annotations.Steps;
import test.WalmartSteps;

public class BuscadorWalmartStepDefinitions {
    @Steps
    WalmartSteps walmartSteps = new WalmartSteps();

    @Given("^que me encuentro en la pagina de walmart$")
    public void queMeEncuentroEnLaPaginaDeWalmart() {

        SeleniumWebDriver.ChromeWebDriver("https://www.walmart.com/");

    }

    @When("^busco diferentes productos en el buscador$")
    public void buscoDiferentesProductosEnElBuscador() {
        walmartSteps.buscarPalabraEnWalmart();



    }

    @Then("^podre ver los productos buscados$")
    public void podreVerLosProductosBuscados() {

        SeleniumWebDriver.driver.quit();

    }
}
