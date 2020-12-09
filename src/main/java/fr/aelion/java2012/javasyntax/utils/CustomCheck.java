package fr.aelion.java2012.javasyntax.utils;

import fr.aelion.java2012.javasyntax.exceptions.BadParamException;

@FunctionalInterface
public interface CustomCheck {
    void check(int a) throws BadParamException;
}
