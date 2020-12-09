package fr.aelion.java2012.javasyntax.utils;

@FunctionalInterface
public interface IsEven {
    public boolean check(int a);

    default boolean defaultCheck(int a) {
        return a%2 == 0;
    }
}
