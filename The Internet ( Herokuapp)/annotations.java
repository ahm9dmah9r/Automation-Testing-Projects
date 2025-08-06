package TestNg1;


import org.testng.annotations.*;

public class annotations {
    @BeforeSuite
    public static void beforesuite()
    {
        System.out.println("beforesuite");
    }
    @BeforeTest
    public static void beforetest()
    {
        System.out.println("beforetest");

    }
    @BeforeClass
    public static void beforeclass()
    {
        System.out.println("beforeclass");
    }
    @BeforeMethod
    public static void beforemethod()
    {
        System.out.println("before method");

    }

    @Test
    public static void testcase1()
    {
        System.out.println("TC 1");



    }
    @Test
    public static void testcase2()
    {
        System.out.println("TC 2");

    }
    @AfterSuite
    public static void aftersuite()
    {
        System.out.println("aftersuite");
    }
    @AfterTest
    public static void aftertest()
    {
        System.out.println("aftertest");

    }
    @AfterClass
    public static void Afterlass()
    {
        System.out.println("afterclass");
    }
    @AfterMethod
    public static void aftermethod()
    {
        System.out.println("after method");

    }

}
