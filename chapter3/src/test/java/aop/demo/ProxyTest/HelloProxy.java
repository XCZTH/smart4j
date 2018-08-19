package aop.demo.ProxyTest;

public class HelloProxy {
    private Hello hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }

    public void say(String name){
        before();
        hello.say(name);
        after();
    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }

    public static void main(String[] args){
        HelloProxy hello=new HelloProxy();
        hello.say("haoxr");
    }
}
