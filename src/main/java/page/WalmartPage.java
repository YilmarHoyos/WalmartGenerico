package page;

import org.openqa.selenium.By;

public class WalmartPage {

    private static By buscadorWalmart = By.xpath("//input[@class='k_a bo_b header-GlobalSearch-input mweb-Typeahead-input k_b']");    //Xpath para el buscador de walmart
    private static By btnSubmin = By.xpath("//button[@class='g_a bo_e GlobalHeaderSearchbar-submit g_c']");  //boton de busqueda
    private static By homePage = By.xpath("//a[@id='hf-home-link']");
    private static By Producto ;
    private static By verificacionProducto;

    public static By getHomePage() {
        return homePage;
    }

    public static void setProducto(String producto) {
        WalmartPage.Producto = By.xpath("//mark[contains(text(),'"+ producto +"')]//ancestor::a");
    }

    public static void setVerificacionProducto(String producto) {

        WalmartPage.verificacionProducto = By.xpath("//h1[contains(text(),'"+ producto +"')]");
    }

    public static By getBuscadorWalmart() {return buscadorWalmart;}

    public static By getBtnSubmin() {return btnSubmin;}

    public static By getProducto() {return Producto;}

    public static By getVerificacionProducto() {return verificacionProducto;}
}
