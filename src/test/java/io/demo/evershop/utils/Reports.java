package io.demo.evershop.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Capabilities;

public class Reports {

    protected ExtentSparkReporter extentSparkReporter;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    public void initReport(){
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/index_report.html");
    }

    public void configReport(Capabilities dataCapabilities){
        System.out.println("Browser Name: " + dataCapabilities.getBrowserName() );
        System.out.println("Browser Version: " + dataCapabilities.getBrowserVersion() );
        System.out.println("Plataform Name: " + dataCapabilities.getPlatformName());
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle("QA Report Page");
    }

    public void runReports(){
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    public void clearReport(){
        extentReports.flush();
    }

}
