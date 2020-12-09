package fr.aelion.java2012.javasyntax;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
}
