package Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MySuiteListener implements ISuiteListener {


    public void onStart(ISuite suite) {
        System.out.println(" Suite Started: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println(" Suite Finished: " + suite.getName());
    }

}
