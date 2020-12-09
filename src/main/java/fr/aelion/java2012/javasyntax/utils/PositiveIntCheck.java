package fr.aelion.java2012.javasyntax.utils;

import fr.aelion.java2012.javasyntax.exceptions.BadParamException;

public class PositiveIntCheck implements CustomCheck {
    @Override
    public void check(int a) throws BadParamException {
        if(a <= 0) throw new BadParamException("msg");
    }
}
