package notebooktests.viewtests;

import notebook.view.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ViewTests {
    @Test
    public void concatenateStrings(){
        View view = new View();
        String message1 = "hello";
        String message2 = "world";
        Assertions.assertEquals(view.concatenateStrings(message1, message2), "hello world");
    }
}
