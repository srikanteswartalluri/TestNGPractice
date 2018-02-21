import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "default")
public class TestManagerTestNG {
    Manager m;
    //setup
    @BeforeClass()
    public void setUp(){
        System.out.println("In setup Method");
        m  = new Manager("John", 23, 2000);
    }
    //tests
    @Test(groups = {"Smoke","Functional"})
    public void testGetBonus(){
        System.out.println("In test1");

        //set the experience for John
        m.setExp(11);
        //compute  bonus you are expecting
        double expectedBonus = m.getSalary() * .16;

        //validation
        int experience = m.getExp();
        double bonus = m.getBonus(experience);

        int equal = Double.compare(expectedBonus, bonus);

        Assert.assertEquals(equal,0, "Validation failed for getBonus method");

    }

    //test
    @Test(groups = {"Functional"})
    public void testGetBonus1(){
        System.out.println("In test2");

    }

    @Test(groups = {"smoke", "Functional"}, description = "test case get bonus")
    public void testGetBonus2(){
        System.out.println("In test3");
        //Assert.fail();

    }


    @Test(dependsOnMethods = "testGetBonus2")
    public void testDependent()  {
        System.out.println("in test dependent");

    }

    @Test(expectedExceptions = {ArithmeticException.class})
    public void testException(){
        System.out.println("exception Test");
        System.out.println(4/0);
    }





    //cleanup
    @AfterClass
    public void tearDown(){
        System.out.println("In tearDown");
    }
//
//    @BeforeSuite
//    public void suiteSetup(){
//        System.out.println("suiteSetup");
//    }
    @AfterGroups
    public void groupCleanup(){
        System.out.println("group cleanup");
    }
    @BeforeGroups
    public void groupSetup(){
        System.out.println("group setup");
    }
    @AfterMethod
    public void methodCleanup(){
        System.out.println("method cleanup");
    }
    @BeforeMethod
    public void methodSetup(){
        System.out.println("method setup");
    }

//    @AfterSuite
//    public void suiteCleanup(){
//        System.out.println("In afterSuite");
 //   }
}
