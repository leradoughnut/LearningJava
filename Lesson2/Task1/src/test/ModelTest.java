package test;

import gameJava.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ModelTest {
    static Model model;

    @BeforeAll
    public static void init(){
        model = new Model();
    }

    @Test
    public void pickNumber(){
        for (int attempt = 0; attempt < 10000; attempt++){
            model.setPickedNumber(model.pickNumber());
            Assertions.assertFalse(model.isGreaterThan(model.getRightBound()));
            Assertions.assertFalse(model.isLessThan(model.getLeftBound()));
        }
    }

    @Test
    public void isNumberInBounds(){
        Assertions.assertFalse(model.isNumberInBounds(model.getLeftBound() - 1));
        Assertions.assertFalse(model.isNumberInBounds(model.getRightBound() + 1));

    }

    @Test
    public void isNumberGuessed(){
        int pickedNumber = 50;
        model.setPickedNumber(pickedNumber);
        int attempts = model.getAttempts().size();
        Assertions.assertTrue(model.isNumberGuessed(pickedNumber));
        Assertions.assertFalse(model.isNumberGuessed(pickedNumber + 1));
        Assertions.assertEquals(pickedNumber + 1, model.getRightBound());
        Assertions.assertFalse(model.isNumberGuessed(pickedNumber - 1));
        Assertions.assertEquals(pickedNumber - 1, model.getLeftBound());
        Assertions.assertEquals(attempts + 3, model.getAttempts().size());
    }
}
