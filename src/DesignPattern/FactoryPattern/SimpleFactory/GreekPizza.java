package DesignPattern.FactoryPattern.SimpleFactory;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/10
 */

public class GreekPizza extends Pizza {
    String pizzaType = "希腊披萨";

    @Override
    public void bake() {
        System.out.println(pizzaType+" is baking");
    }

    @Override
    public void cut() {
        System.out.println(pizzaType+" is cutting");
    }

    @Override
    public void box() {
        System.out.println(pizzaType+" is boxing");
    }
}
