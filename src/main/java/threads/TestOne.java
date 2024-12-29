package threads;

public class TestOne {
    public static void main(String[] args) {
        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        Thread t = new Thread(helloWorldPrinter);

        System.out.println("Hi from "+Thread.currentThread().getName());
        t.start();
    }
}
