package fr.aelion.java2012.javasyntax;

import fr.aelion.java2012.javasyntax.utils.GenericCalculator;
import fr.aelion.java2012.javasyntax.utils.IsEven;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LambdaTest {

    @Test
    void test() {
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");
        words.add("!!");

        // forEach(Consumer)
        // Consumer => (T t) => { }
        System.out.println("Print with legacy syntax");
        words.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // With lambda
        System.out.println("Print with legacy lambda");
        words.forEach((word) -> System.out.println(word));

        // Autre raccourci
        // Method reference => ::
        words.forEach(System.out::println);

        assertTrue(true);
    }

    @Test
    void testLambdaPractice() {
        // tester si un nombre est pair
        // sans les accolades => 1 seule instruction et return
        Predicate<Integer> isEven = (n) -> n%2 == 0;
        boolean testA = isEven.test(10);
        if(testA) System.out.println("It's even");

        IsEven isEvenCustom = (n) -> n%2 == 0;
        isEvenCustom.check(10);
        isEvenCustom.defaultCheck(10);

        // créer une liste et la parcourir avec foreach
        List<String> words = List.of("word1", "word2", "word3");
        // classic syntaax
        words.forEach((w) -> System.out.println(w));
        // method reference
        words.forEach(System.out::println);

        // concat string with lambdas
        BinaryOperator<String> concat = (s1, s2) -> s1 + " " + s2;
        String s = concat.apply("Hello", "lambdas");
        System.out.println(s);

        GenericCalculator addition = (a, b) -> a + b;
        int r = addition.calculate(5, 2);
        System.out.println(r);
        assertTrue(true);
    }
}
