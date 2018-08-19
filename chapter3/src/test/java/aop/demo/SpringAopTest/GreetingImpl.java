package aop.demo.SpringAopTest;

public class GreetingImpl implements Greeting {

    public void sayHello(String name) {
        System.out.println("hello:" + name);
    }
}
