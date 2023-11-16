package org.lucidant.java16;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.lucidant.java8.DefaultInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.ClassLoader.getSystemClassLoader;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(value = Lifecycle.PER_CLASS)
class DefaultProxyTest {

    /** Invoke Default Methods From Proxy Instances (JDK-8159746)    */
    @Test
    void testProxyDefaultMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object proxy = Proxy.newProxyInstance(getSystemClassLoader(),new Class<?>[]{DefaultInterface.class },
            (proxie, method, args)->{
                if(method.isDefault()){
                    return InvocationHandler.invokeDefault(proxie,method,args);
                }
                return proxie;
            }
        );
        Method method=proxy.getClass().getMethod("greeting");
        assertThat(method.invoke(proxy)).isEqualTo("Hello Everyone!");
    }

}
