package aop.demo.ProxyTest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 不需要代理的实现类实现某个接口
 * 运行期间动态生成字节码工具，就是动态生成代理类
 */
public class CGLibProxy implements MethodInterceptor {
    public <T> T getProxy(Class<T> cls){
        System.out.println(cls);
        return (T) Enhancer.create(cls,this);
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result=methodProxy.invokeSuper(obj,args);
        after();
        return result;
    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }

    private  static CGLibProxy instance=new CGLibProxy();

    //private构造方法 就是为了限制外界不能new它
    private  CGLibProxy(){

    }

   public static CGLibProxy getInstance(){
       return instance;
   }



    public static void main(String[] args){
        Hello helloProxy=CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("Jack");
    }
}
