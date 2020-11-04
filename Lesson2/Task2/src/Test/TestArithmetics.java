package Test;

import Calculation.Arithmetics;
import org.junit.Assert;
import org.junit.Test;

public class TestArithmetics {
    @Test
    public void TestAdd(){
        Arithmetics arithmetics = new Arithmetics();
        double res = arithmetics.add(3, 4);
        if (res != 7) Assert.fail();
    }
}
