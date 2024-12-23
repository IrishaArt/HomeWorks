package lambda.Calculator;

import lambda.Calculator.Calculator;

public class Main {
    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();
        try {
            int a = calc.plus.apply(1, 2);
            int b = calc.minus.apply(1, 1);
            int c = calc.devide.apply(a, b);// делим на 0
            calc.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("Деление невозможно. Проверь числа.");
        }

    }
}
