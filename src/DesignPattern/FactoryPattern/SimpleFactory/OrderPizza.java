package DesignPattern.FactoryPattern.SimpleFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: bin
 * @create: 2020/2/10
 */

public class OrderPizza {
    PizzaFactory pizzaFactory;
    Pizza pizza;

    public String Order(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;

        while (true) {
            pizza = this.pizzaFactory.getPizza(getType());
            if (pizza != null) {
                pizza.bake();
                pizza.cut();
                pizza.box();
                System.out.println("enjoy you "+pizza.pizzaType);
            }else {
                System.out.println("What do you want to eat???");
            }
        }
    }

    public String getType() {
        String type = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input the type of pizza you want plz");
        try {
            type = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("surprise");
        }
        return type;
    }

}
