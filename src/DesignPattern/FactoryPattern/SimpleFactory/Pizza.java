package DesignPattern.FactoryPattern.SimpleFactory;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/10
 */

public abstract class Pizza {
    String pizzaType;
    public abstract void bake();
    public abstract void cut();
    public abstract void box();

}
