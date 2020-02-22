package DesignPattern.FactoryPattern.SimpleFactory;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/10
 */

public class PepperPizza extends Pizza{
    @Override
    public void box() {
        System.out.println("boxing");
    }

    @Override
    public void bake() {
        System.out.println("baking");
    }

    @Override
    public void cut() {
        System.out.println("cutting");
    }
}
