public class TestManager {
    public static void main(String[] args) {
        Manager m = new Manager("John", 23, 2000);

        //our test code starts here

        //set the experience for John
        m.setExp(11);
        //compute actual bonus you are expecting
        double actualBonus = m.getSalary() * .15;

        int experience = m.getExp();
        double bonus = m.getBonus(experience);

        System.out.println(bonus);
        int a = 10;
        int b = 10;

//        if(a == b){
//            System.out.println("equal");
//        }else{
//            System.out.println("not equal");
//        }


        int equal = Double.compare(actualBonus, bonus);

        if( equal == 0){
            System.out.println("PASS");
        }else {
            //fail
            System.out.println("FAIL");
        }


    }
}
