package test;

import driver.SeleniumWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.WalmartPage;
import utils.Excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WalmartSteps {
    public static ArrayList<Map<String, String>> lecturaExcel = new ArrayList<Map<String, String>>();

    public void escribirEnTexto(By elemento, String texto) {
        boolean validarElemento = false;
        while (validarElemento == false) {
            try {
                SeleniumWebDriver.driver.findElement(elemento).sendKeys(texto);
                validarElemento = true;
            } catch (Exception e) {
            }
        }

    }
    public String obtenerTexto(By elemento){ return SeleniumWebDriver.driver.findElement(elemento).getText();}
    public void validarTexto(By elemento, String texto) {
        assertEquals(obtenerTexto(elemento), texto);
    }
//Codigo para dar clic con el enter
/*             try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                } catch (Exception e){
                }

        */
    public void clicEnElElemento(By elemento) {  //esto es un metodo

                SeleniumWebDriver.driver.findElement(elemento).click();
    }
    public String obtenerTextoElemento(By elemento){
        boolean validarElemento = false;
        String textElemento ="";
        while (validarElemento== false){
            try {
                textElemento= SeleniumWebDriver.driver.findElement(elemento).getText();
                validarElemento=true;
            } catch (Exception e){}
        }
        return textElemento;
    }
    public void validarTextoEnPantalla(By elemento,String texto) { //lo que va en los parentecis es lo que va a recibir
        boolean validarTexto = false;
        if (obtenerTextoElemento(elemento).contains(texto)){
            validarTexto = true;
        }
        assertEquals(true, validarTexto);
    }
    public  void buscarPalabraEnWalmart()  {  //esto es un metodo
        try {
            lecturaExcel = Excel.readExcel("C:\\Users\\yilma\\OneDrive\\Escritorio\\Libro1.xlsx","Hoja1");
        } catch (IOException e){
            e.printStackTrace();
        }

        for (int i = 0; i < lecturaExcel.size(); i++){
            System.out.println(lecturaExcel.get(i).get("Productos"));


            escribirEnTexto(WalmartPage.getBuscadorWalmart(), lecturaExcel.get(i).get("Productos"));
            clicEnElElemento(WalmartPage.getBtnSubmin());
            WalmartPage.setProducto(lecturaExcel.get(i).get("Productos").split(" ")[0]);
            List<WebElement> listaDeproducto = SeleniumWebDriver.driver.findElements(WalmartPage.getProducto());
            listaDeproducto.get(0).click();
            try {
                Thread.sleep(2000);
                }catch (Exception e){}
            WalmartPage.setVerificacionProducto(lecturaExcel.get(i).get("Productos"));

            validarTextoEnPantalla(WalmartPage.getVerificacionProducto(), lecturaExcel.get(i).get("Productos").split(" ")[i]);



            //WalmartPage.setVerificacionProducto(lecturaExcel.get(i).get("Productos").split(" ")[i]);
            //List<WebElement> listaDeVerificacionDeProductos = SeleniumWebDriver.driver.findElements(WalmartPage.getVerificacionProducto());
            //listaDeVerificacionDeProductos.get(i).isDisplayed();


//            clicEnElElemento(WalmartPage.getHomePage());


        }
        /**/

    }

}
// CODIGO PARA ELIMINAR VENTANAS DE PUBLICIDAD EN LA PRIMER VENTANA(OFERTAS Y DEMAS)
//    public static void cambiarmeDeVentana() {
//        defaulWindows = SeleniumWebDriver.driver.getWindowHandle();
//        boolean validacionPantalla = false;
//        while (validacionPantalla == false) {
//            Set<String> lista = SeleniumWebDriver.driver.getWindowHandles();
//            if(lista.size() > 1) {
//                Iterator<String> I1 = lista.iterator();
//                while (I1.hasNext()) {
//                    String child_window = I1.next();
//
//                    if (!defaulWindows.equals(child_window)) {
//                        SeleniumWebDriver.driver.switchTo().window(child_window);
//                    }
//                }
//                validacionPantalla = true;
//            }
//        }
//
//    }