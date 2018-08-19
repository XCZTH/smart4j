package aop.demo.helper;

import aop.demo.annotation.Inject;
import aop.demo.util.CollectionUtil;
import aop.demo.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;


/**
 * 依赖注入 将某个类需要依赖的成员注入到这个类中
 */
public final class IocHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap
                    .entrySet()) {
                //从BeanMap中获取Bean类和Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取Bean类中定义的所有成员变量(简称 Bean Field)
                Field[] beanFields = beanClass.getDeclaredFields();
                if (beanFields != null && beanFields.length > 0) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            //在Bean Map中获取Bean Field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                //通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }

}
