package cn.njtech.handler;

import cn.njtech.target.Manufactor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MHandler implements InvocationHandler {
    private Object target;

    //动态代理：目标对象是活动的，需要作为目标对象传进来！！！
    //传入是谁就给谁创建代理
    public MHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object res = null;
        res = method.invoke(target, args);

        //有可能返回调用的结果为空这时候需要判断一下
        if(res != null) {
            //float类型1.2后面必须加f，写成1.2f的形式，1.2默认是double类型
            //Float price = (Float)res * 1.2f;
            //写成Float的形式，包装类，方便传送，判错
            Float price = (Float)res;
            System.out.println("代理商将购买的u盘卖掉赚了三成的利润：" + price * 0.3f);
            price += price * 0.3f;
            res = price;

        }
        System.out.println("代理商为了吸引顾客，所以还给每位顾客返了1元红包!");

        return res;
    }
}
