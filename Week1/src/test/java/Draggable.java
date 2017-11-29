import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.http.util.Asserts;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Draggable {
    private String url="http://demoqa.com/draggable/";
    private WebDriver webDriver;
    private static ExtentReports report;

    @BeforeClass
    public static void init() {
        report = new ExtentReports();
        String fileName = "ReportDraggable" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
    }

    @Test
    public void Test1() throws InterruptedException {
        ExtentTest test = report.createTest("First");
        test.log(Status.INFO, "First Test is Starting ");

        webDriver.navigate().to(url);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        Actions a = new Actions(webDriver);
        DraggablePOM drag = PageFactory.initElements(webDriver, DraggablePOM.class);
        a.clickAndHold(drag.el).moveToElement(drag.el2,300,200).release(drag.el).perform();
        test.log(Status.INFO, "Moved");
        int offset = drag.el.getLocation().getX();

        Assert.assertEquals(441, offset);
        test.log(Status.INFO, "Complete");
    }

    @Test
    public void Test2() throws InterruptedException{

        ExtentTest test1 = report.createTest("Second");
        test1.log(Status.INFO, "Second Test is Starting ");
        webDriver.navigate().to(url);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        Actions a = new Actions(webDriver);
        DraggablePOM drag = PageFactory.initElements(webDriver, DraggablePOM.class);
        drag.clickBtn1();
        a.clickAndHold(drag.dragS1).moveByOffset(0, 20).release(drag.dragS1).perform();
        test1.log(Status.INFO, "Moved");
        int offset=drag.dragS1.getLocation().getY();

        Thread.sleep(5000);

        Assert.assertEquals(424, offset);
        test1.log(Status.INFO, "Complete");
    }

    @Test
    public void Test3() throws InterruptedException{
        ExtentTest test2 = report.createTest("Third");
        test2.log(Status.INFO, "Third Test is Starting ");
        webDriver.navigate().to(url);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        Actions a = new Actions(webDriver);
        DraggablePOM drag = PageFactory.initElements(webDriver, DraggablePOM.class);
        drag.clickBtn1();
        a.clickAndHold(drag.dragS2).moveByOffset(80, 0).release(drag.dragS2).perform();
        test2.log(Status.INFO, "Moved");
        int offset=drag.dragS2.getLocation().getX();

        Assert.assertEquals(453, offset);
        test2.log(Status.INFO, "Compelte");
    }

    @Test
    public void Test4() throws InterruptedException{
        ExtentTest test3 = report.createTest("Fourth");
        test3.log(Status.INFO, "Fourth Test is Starting ");
        webDriver.navigate().to(url);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        Actions a = new Actions(webDriver);
        DraggablePOM drag = PageFactory.initElements(webDriver, DraggablePOM.class);
        drag.clickBtn1();
        a.clickAndHold(drag.dragS3).moveToElement(drag.dragDom,300,200).release(drag.dragS3).perform();
        int offset=drag.dragS3.getLocation().getX();


        Assert.assertEquals(528, offset);
        test3.log(Status.INFO, "Compelte");
    }

    @Test
    public void Test5() throws InterruptedException{
        ExtentTest test4 = report.createTest("Fifth");
        test4.log(Status.INFO, "Fifth Test is Starting");
        webDriver.navigate().to(url);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        Actions a = new Actions(webDriver);
        DraggablePOM drag = PageFactory.initElements(webDriver, DraggablePOM.class);
        drag.clickBtn2();
        a.clickAndHold(drag.dragT1).moveByOffset(200,300).release(drag.dragT1).perform();

        int mouseX = ((int) MouseInfo.getPointerInfo().getLocation().getX());
        int mouseY = ((int) MouseInfo.getPointerInfo().getLocation().getY());

        int height= drag.dragT1.getSize().getHeight();
        int width = drag.dragT1.getSize().getWidth();

        Assert.assertTrue(height/2 <= mouseX && mouseX >= mouseX-height/2);
        Assert.assertTrue(width/2 <= mouseY && mouseY >= mouseY-width/2);
    }

    @Test
    public void Test6(){
        ExtentTest test5 = report.createTest("Sixth");
        test5.log(Status.INFO, "Sixth Test is Starting");
        webDriver.navigate().to(url);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        Actions a = new Actions(webDriver);
        DraggablePOM drag = PageFactory.initElements(webDriver, DraggablePOM.class);
        drag.clickBtn2();

        a.clickAndHold(drag.dragT2).moveByOffset(200,300).release().perform();

        int mouseX = ((int) MouseInfo.getPointerInfo().getLocation().getX());
        int mouseY = ((int) MouseInfo.getPointerInfo().getLocation().getY());

        int height= drag.dragT1.getSize().getHeight();
        int width = drag.dragT1.getSize().getWidth();

        Assert.assertTrue(height <= mouseX && mouseX >= mouseX-height);
        Assert.assertTrue(width <= mouseY && mouseY >= mouseY-width);
    }

    @Test
    public void Test7(){
        ExtentTest test6= report.createTest("Seventh");
        test6.log(Status.INFO, "Seventh Test is Starting");
        webDriver.navigate().to(url);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        Actions a = new Actions(webDriver);
        DraggablePOM drag = PageFactory.initElements(webDriver, DraggablePOM.class);
        drag.clickBtn2();

        a.clickAndHold(drag.dragT3).moveByOffset(200, 300).release().perform();

        int mouseX = (((int) MouseInfo.getPointerInfo().getLocation().getX()));
        int mouseY = ((int) MouseInfo.getPointerInfo().getLocation().getY());

        int height = drag.dragT3.getSize().getHeight();
        int width = drag.dragT3.getSize().getWidth();

        Assert.assertTrue(height <= mouseX && mouseX <= mouseX-height);
        Assert.assertTrue(width <= mouseY && mouseY <= mouseY-width);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @AfterClass
    public static void cleanUp() {
        report.flush();
    }

}
