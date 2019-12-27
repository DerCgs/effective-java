package org.dercg.effectivejava.a_02_builder.pizza;

public class PizzaMain {
    // 如果类的构造器或者静态工厂中具有多个参数，设计这种类的时候，Builder模式将是一种不错的选择
    // 且Builder模式更易于阅读和编写，构建器也比JavaBeans更加安全
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();

        Calzone calzone = new Calzone.Builder().sauceInside()
                .addTopping(Pizza.Topping.HAM)
                .build();

        System.out.println(pizza);
        System.out.println(calzone);
    }
}
