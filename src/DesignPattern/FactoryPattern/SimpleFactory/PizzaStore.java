package DesignPattern.FactoryPattern.SimpleFactory;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/10
 */

public class PizzaStore {
    public static void main(String[] args){
        OrderPizza orderPizza = new OrderPizza();
        orderPizza.Order(new PizzaFactory());
    }
}
