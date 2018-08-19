package aop.demo;

import aop.demo.helper.BeanHelper;
import aop.demo.helper.ClassHelper;
import aop.demo.helper.ControllerHelper;
import aop.demo.helper.IocHelper;
import aop.demo.util.ClassUtil;

public final class HelperLoader {
    public static void init(){
        Class<?>[] classList={
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls:classList){
            ClassUtil.loadClass(cls.getName());
        }
    }
}
