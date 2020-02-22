package DesignPattern.FactoryPattern.SimpleFactory;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/10
 */

public class PizzaFactory {
    public Pizza getPizza(String pizzaType){
        Pizza pizza = null;
        if(pizzaType.equals("Greek")){
            pizza = new GreekPizza();
        }else if(pizzaType.equals("Cheese")){
            pizza = new CheesePizza();
        }else if(pizzaType.equals("Pepper")){
            pizza = new PepperPizza();
        }
        return pizza;
    }
}
