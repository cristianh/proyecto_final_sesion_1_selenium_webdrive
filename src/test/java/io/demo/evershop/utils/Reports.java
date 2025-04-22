package io.demo.evershop.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Capabilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reports {

    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    public String nombreFile = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

    public void initReport(){
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/" + nombreFile + "_index_report.html");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle("QA Report Page");

    }

    public void configReport(Capabilities dataCapabilities,String descriptionTest,String nameTest){

        System.out.println("Browser Name: " + dataCapabilities.getBrowserName() );
        System.out.println("Browser Version: " + dataCapabilities.getBrowserVersion() );
        System.out.println("Plataform Name: " + dataCapabilities.getPlatformName());
        extentTest = extentReports.createTest(descriptionTest,nameTest);
        extentTest.assignAuthor("Pruebas QA");
        //extentTest.assignDevice(dataCapabilities.getPlatformName().toString().toLowerCase());
        extentTest.info("Browser Name: " + dataCapabilities.getBrowserName());
        extentTest.info("Browser Version: " + dataCapabilities.getBrowserVersion());
        extentTest.info("Platform Name: " + dataCapabilities.getPlatformName());
    }

    public void runConfig(){
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    public void clearReport(){
        extentReports.flush();
    }

}
