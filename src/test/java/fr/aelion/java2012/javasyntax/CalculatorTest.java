package fr.aelion.java2012.javasyntax;

import fr.aelion.java2012.javasyntax.exceptions.BadParamException;
import fr.aelion.java2012.javasyntax.utils.CustomCheck;
import fr.aelion.java2012.javasyntax.utils.PositiveIntCheck;
import lombok.extern.java.Log;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Log
public class CalculatorTest {

    static Calculator calc;

    @BeforeAll
    static void initOnce() {
        log.info("init once");
        calc = new Calculator();
    }

    // Lifeclycle hooks: BeforeAll, BeforeEach, AfterAll, AfterEach
    @BeforeEach
    void init() {
        log.info("init");
    }

    @Test
    void addShouldReturnTotal() {
        int a, b;
        a = 2;
        b = 3;
        int r = 0;
        try {
            r = calc.add(2, 3);
            // assumptions
            assumeTrue(a > 0);
            log.info("r = " + 5);
            // assertions
            assertEquals(r, 5);
        } catch (BadParamException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("test add method throws exception")
    @Test
    void addShouldTriggerBadParamExceptionOnZeroValues() {
        // assertThrows(class, lambda expression)
        // lambda expression = fonction anonyme (fonction sans nom, definie a la volée)
        assertThrows(BadParamException.class, () -> {
            calc.add(0, 1);
        });
    }

    @Test
    @Disabled("not implemented")
    void someOtherTest() {
    }

    @Test
    void shouldTriggerBadParamExceptionWithCustomCheck() {
        assertThrows(BadParamException.class, () -> {
            // cree une classe qui implemente l'interface
            CustomCheck validator = new PositiveIntCheck();
            calc.add(1,3, validator);

            calc.add(1,3, new PositiveIntCheck());

            // classe anonyme
            calc.add(1, 3, new CustomCheck(){
                @Override
                public void check(int a) throws BadParamException {
                    if(a <= 2) throw new BadParamException("param cannot be <= 2");
                }
            });

            // lambda
            calc.add(1, 3, (number) -> {
                if(number <= 2) throw new BadParamException("param cannot be <= 2");
            });
        });

        // assertThrows(class, lambda expression)
        // lambda expression = fonction anonyme (fonction sans nom, definie a la volée)
        assertThrows(BadParamException.class, () -> {
            calc.add(1, 3, (number) -> {
                if(number <= 2) throw new BadParamException("param cannot be <= 2");
            });
        });
    }
}
