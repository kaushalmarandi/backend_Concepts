package threads;

public class Test {
    public static void main(String[] args) {
        int a =5;
        int b =10;
        System.out.println("Hello "+Thread.currentThread().getName());
        doSmething();
        System.out.println("After doSomething()"+Thread.currentThread().getName());
    }

    private static void doSmething() {
        int c =30;
        int d=40;
        System.out.println("Hello from doSomething()"+Thread.currentThread().getName());
    }
}
