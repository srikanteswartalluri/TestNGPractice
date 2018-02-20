import org.testng.annotations.*;

public class TestReports {


    @BeforeSuite(alwaysRun = true)
    public void suiteSetup(){
        System.out.println("suite setup");
    }

    @AfterSuite(alwaysRun = true)
    public void suiteCleanup(){
        System.out.println("suite cleanup ");
    }
    @BeforeClass(alwaysRun = true)
    public void classSetup(){
        System.out.println("in class report setup");
    }

    @AfterMethod(alwaysRun = true)
    public void cleanupMethod(){
        System.out.println("report cleanup method");
    }

    @BeforeMethod(alwaysRun = true)
    public void setupMethod(){
        System.out.println("report setup method");
    }

    @Test(groups = {"smoke"})
    public void testReport2(){
        System.out.println("report test1");
    }
    @Test(timeOut = 2000, groups = {"smoke"})
    public void testTimeout() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Test(groups = {"smoke"}, expectedExceptions = ArithmeticException.class)
    public void testException(){
        System.out.println("test Exception");
        int a = 4;
        int b = 0;
        int result = a/b;
        System.out.println(result);
    }


    @Test(groups = {"smoke"})
    public void testReport112(){
        System.out.println("report test2");
    }


    @Test(groups = {"broken"})
    public void testReport3(){
        System.out.println("report test3");
    }

    @Test(groups = {"broken"})
    public void testReport4(){
        System.out.println("report test4");
        //test covers stress testing
    }

    @AfterClass(alwaysRun = true)
    public void classCleanup(){
        System.out.println("report class clean up");
    }
}
