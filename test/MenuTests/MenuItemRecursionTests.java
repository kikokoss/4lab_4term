package MenuTests;

import org.junit.jupiter.api.Test;
import space.realkarmakun.menu.MenuItem;
import space.realkarmakun.menu.MenuItemExit;
import space.realkarmakun.menu.MenuItemRecursion;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MenuItemRecursionTests {

    @Test
    public void getTitle_creatingItem_titleReturned() {
        //arrange
        MenuItem test = new MenuItemRecursion();
        //act
        String result = test.getTitle();
        //assert
        assertEquals("Accurate power of two", result);
    }
}
