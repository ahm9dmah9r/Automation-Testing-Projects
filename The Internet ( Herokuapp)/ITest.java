package Listeners;

import org.testng.ITestListener;

public class ITest implements ITestListener{

    public void onTestStart(ITestListener result){
        System.out.println(result.getClass());


    }
    public void onTestSuccess(ITestListener result){

        System.out.println("good");

    }
    public void onTestSkipped(ITestListener result){


        System.out.println("ok");
    }


}
