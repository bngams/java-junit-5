package fr.aelion.java2012.javasyntax;

import fr.aelion.java2012.javasyntax.exceptions.BadParamException;
import fr.aelion.java2012.javasyntax.utils.CustomCheck;

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

    /**
     * Add method with a custom check
     * @param a
     * @param b
     * @return
     * @throws BadParamException
     */
    int add(int a, int b, CustomCheck validator) throws BadParamException  {
        validator.check(a);
        validator.check(b);
        return a + b;
    }
}
