package codigo;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class codigo {

    private WebDriver navegador;
    private String arg1;
    private String tmp;
    private String tmp2;



    //chamar a classe gera nome
    NameGenerator nameGenerator = new NameGenerator();
    String name = nameGenerator.generateName();
    String emailTemp = name + "@datamob.net.br";

    String aux = name;


    @Dado("configurei ambiente para acessar URL Chrome")
    public void configurei_ambiente_para_acessar_URL_Chrome() {
        // Write code here that turns the phrase above into concrete actions

        System.setProperty("webdriver.chrome.driver", "/Users/leandrobrum/autoMaven/chromedriver");

    }


    @Quando("^abri tela Shoestock$")
    public void abreSimulador() {

        navegador = new ChromeDriver();
        navegador.get("https://www.shoestock.com.br/");
        navegador.manage().window().maximize();

    }


    @Quando("^realizei busca por(.*)$")
    public void buscamercadoria(String arg1) throws InterruptedException {
        Thread.sleep(300);

        By searchId = By.xpath("//*[@id=\"header-content\"]/header/div/div/section[2]/section/form/div/button");
        WebDriverWait wait = new WebDriverWait(navegador, 20);



        wait.until(visibilityOfElementLocated(searchId));
        navegador.findElement(By.id("search-input")).sendKeys(arg1);
        navegador.findElement(By.id("search-input")).click();

        WebElement nomeId =  wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"header-content\"]/header/div/div/section[2]/section/form/div/button")));
        //botao pesquisar
        nomeId.click();




    }


    @Quando("^adicionei sapato a cesta$")
    public void adicionaitem1() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(navegador, 20);
        wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a/img")));

        //pegar o texto do sapato
        tmp =  navegador.findElement(By.xpath("//*[@id=\"item-list\"]/div[1]/div[1]/div[2]/a[1]/span")).getText();
        System.out.println(tmp);


        wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a/img")));
        //clicar no icone do sapato
        navegador.findElement(By.xpath("//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a/img")).click();


        wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"buy-box\"]/section[2]/div/ul/li[4]/a")));
        //selecionar o tamanho
        navegador.findElement(By.xpath("//*[@id=\"buy-box\"]/section[2]/div/ul/li[4]/a")).click();

        wait.until(visibilityOfElementLocated(By.cssSelector("#buy-button-now > span")));
        //clicar em comprar
        navegador.findElement(By.cssSelector("#buy-button-now > span")).click();


    }

    @Quando("^adicionei tennis a cesta$")
    public void adicionaitem2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(navegador, 20);
        wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a/img")));

        //pegar o texto do sapato
        tmp2 =  navegador.findElement(By.xpath("//*[@id=\"item-list\"]/div[1]/div[1]/div[2]/a[1]/span")).getText();
        System.out.println(tmp2);

        //clicar no icone do sapato
        Thread.sleep(300);
        navegador.findElement(By.xpath("//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a/img")).click();

        //selecionar o tamanho
        Thread.sleep(300);
        navegador.findElement(By.xpath("//*[@id=\"buy-box\"]/section[2]/div/ul/li[4]/a")).click();

        //clicar em comprar
        Thread.sleep(300);
        navegador.findElement(By.cssSelector("#buy-button-now > span")).click();


    }

    @Entao("^valido itens$")
    public void validoitens() throws InterruptedException {



        By clickSapato = By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div/div/h3");
        WebDriverWait wait1 = new WebDriverWait(navegador, 20);

        wait1.until(visibilityOfElementLocated(clickSapato));

        String validacao1 = navegador.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div/div/h3")).getText();

        Assert.assertTrue(validacao1.contains(tmp));

        String validacao2 = navegador.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div/h3")).getText();

        Assert.assertTrue(validacao2.contains(tmp2));

        Screenshot.tirar(navegador, "src/test/java/screenshot/Validação" + Generator.dataHoraArquivo() + ".png");

        navegador.close();
    }

    @Quando("^escolher mais produtos$")
    public void maisprodutos() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(navegador, 20);
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div/a[2]")));

        //selecionar mais produtos
        navegador.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div/a[2]")).click();

    }

}
