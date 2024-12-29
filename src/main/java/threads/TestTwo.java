package threads;

public class TestTwo {
    public static void main(String[] args) {
        for(int i=1;i<=100;i++){
            PrintNumber printNumber=new PrintNumber(i);
            Thread t = new Thread(printNumber);
            t.start();
        }
    }
}
