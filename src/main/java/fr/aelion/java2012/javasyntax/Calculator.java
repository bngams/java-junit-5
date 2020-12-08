package fr.aelion.java2012.javasyntax;

import fr.aelion.java2012.javasyntax.exceptions.BadParamException;

/**
 * Allow to do some calculations
 */
public class Calculator {

    /**
     * Return addition result of a and b
     * @param a
     * @param b
     * @return
     */
    int add(int a, int b) throws BadParamException  {
        if(a == 0 || b == 0) throw new BadParamException("Cannot use 0 values");
        return a + b;
    }
}
