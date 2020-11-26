package codigo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {
    private static WebDriver navegador;
    private static String arquivo;

    public Screenshot() {
    }

    public static void tirar( WebDriver navegador, String arquivo) {
        Screenshot.navegador = navegador;
        Screenshot.arquivo = arquivo;
        File screenshot = (File)((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(arquivo));
        } catch (Exception var4) {
            System.out.println("Houve problemas" + var4.getMessage());
        }

    }
}
