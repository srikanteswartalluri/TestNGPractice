import org.testng.annotations.*;

public class TestNew {
    @BeforeClass
    public void classSetup(){
        System.out.println("in class setup");
    }

    @AfterMethod
    public void cleanupMethod(){
        System.out.println("cleanup method");
    }

    @BeforeMethod
    public void setupMethod(){
        System.out.println("setup method");
    }

    @Test(priority = 0)
    public void test1(){
        System.out.println("test1");
    }
    @BeforeTest(alwaysRun = true)
    public void beforeTest(){
        System.out.println("====TestNew: before test===");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        System.out.println("====TestNew: after test===");
    }

    @Test(priority = 1)
    public void test2(){
        System.out.println("test2");
    }


    @Test(priority = 2)
    public void test3(){
        System.out.println("test2");
    }

    @AfterClass
    public void classCleanup(){
        System.out.println("class clean up");
    }
}


