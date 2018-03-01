public class SubClassMul extends Parent1 implements Multiply, Parent2{
    public int multiplyTwo(int n1, int n2){
        if(n1 !=0){
            System.out.println("i am implementing interface's method");
        }
        return n1*n2;
    }

    public int multiplyThree(int n1, int n2, int n3){
        System.out.println("Srikant's implementation of multiply 3");
        return n1*n2*n3;
    }

    public int sub(int m, int n){
        return m * n;
    }

    public int divS(int n, int p){
        return Parent3.div(n, p);

    }


}
