package cn.njtech.target;

import cn.njtech.service.UsbSell;

public class Manufactor implements UsbSell {
    private float cost;
    @Override
    public float sell(int amount) {
        cost = 85.0f;
        System.out.println("代理商购买了" + amount + "个u盘，" + "总价为" + amount * cost);
        return amount * cost;
    }
}
