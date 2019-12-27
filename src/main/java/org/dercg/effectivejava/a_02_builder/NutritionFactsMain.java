package org.dercg.effectivejava.a_02_builder;

public class NutritionFactsMain {
    public static void main(String[] args) {
        // 流式api
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(10,2)
                .calories(32)
                .fat(33)
                .carbohydrate(54)
                .sodium(334)
                .build();
        System.out.println(nutritionFacts.toString());
    }
}
