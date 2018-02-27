import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


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


    @BeforeGroups(groups = "stress")
    public void groupSetupStress(){
        System.out.println("group setup");
    }

    @AfterGroups(groups = "smoke")
    public void groupCleanup(){
        System.out.println("group cleanup");
    }
    @BeforeTest(alwaysRun = true)
    public void beforeTest(){
        System.out.println("====before test===");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        System.out.println("====after test===");
    }

    @BeforeGroups(groups = "smoke")
    public void groupSetup(){
        System.out.println("group setup");
    }

    @Test(groups = {"smoke"}, invocationCount = 3)
    public void testReport2(){
        System.out.println("report test1");
        Assert.fail("Test failed intentionally");

    }

//    @Test(timeOut = 5000, groups = {"smoke"})
//    public void testTimeout() throws InterruptedException {
//        Thread.sleep(4000);
//    }

    @Test(groups = {"smoke"}, expectedExceptions = ArithmeticException.class)
    public void testException(){
        System.out.println("test Exception");
        int a = 4;
        int b = 0;
        int result = a/b;
        System.out.println(result);
    }

    @DataProvider(name="loginDetails")
    public Object[][] dprovider(){
        Object[][] aList = {{"test1@gmail.com", "password"}, {"test2@gmail.com", "password"}};
        return aList;
    }

    @DataProvider(name="excelData")
    public Object[][] excelProvider(){
        Object[][] excelData =  getExcelData("/Users/stalluri/Downloads/testExcel.xls","Sheet1");
        return excelData;
    }

    /**
     * @param fileName file Name
     * @param sheetName sheet Name
     * @return
     */
    public String[][] getExcelData(String fileName, String sheetName) {
        String[][] arrayExcelData = null;
        try {
            FileInputStream fs = new FileInputStream(fileName);
            Workbook wb = Workbook.getWorkbook(fs);
            Sheet sh = wb.getSheet(sheetName);

            int totalNoOfCols = sh.getColumns();
            int totalNoOfRows = sh.getRows();

            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];

            for (int i= 1 ; i < totalNoOfRows; i++) {

                for (int j=0; j < totalNoOfCols; j++) {
                    arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return arrayExcelData;
    }

    @Test(groups = "test", dataProvider = "excelData")
    public void TestDP(String userName, String password){
        System.out.println("username: " + userName + " Password: " + password);
    }
    @Test(groups = {"smoke"})
    public void testReport112(){
        System.out.println("report test2");
        int a = 0;
        Assert.assertEquals(a, 1, "values didnt match");
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
