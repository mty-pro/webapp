package cn.njtech.shop;

import cn.njtech.handler.MHandler;
import cn.njtech.service.UsbSell;
import cn.njtech.target.Manufactor;

import java.lang.reflect.Proxy;


public class ShopMain {
    public static void main(String[] args) {
        UsbSell manufactor = new Manufactor();
        MHandler mHandler = new MHandler(manufactor);
        //创建代理对象，并将返回值转换为接口类型
        //使用jdk反射进行动态代理的前提是目标类和代理类实现了相同的接口
        //而使用cglib库实现动态代理的前提是继承，且框架中多使用cglib的方式
        UsbSell proxy = (UsbSell)Proxy.newProxyInstance(manufactor.getClass().getClassLoader(),
                manufactor.getClass().getInterfaces(),
                mHandler);
        float price = proxy.sell(1);
        System.out.println("代理商赚了" + price);

    }
}
