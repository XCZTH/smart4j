package aop.demo.SpringAopTest;


import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.MethodInterceptor;


public class GreetingAroundAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        Object result = invocation.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("Before1");
    }

    private void after() {
        System.out.println("After1");

    }
}
