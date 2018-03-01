import java.util.ArrayList;
import java.util.List;

public class InterfaceJava {

    public static void main(String[] args) {
        Multiply m = new MultiplyImpl();
        int p = m.multiplyThree(2, 3, 4);

        System.out.println("result from MultiplyImpl: " + p);

        Multiply n = new MutiplyImplSrikant();
        int r = n.multiplyThree(2,3,4);

        System.out.println("result from MultiplyImplSrikant: " + r);

    }
}
