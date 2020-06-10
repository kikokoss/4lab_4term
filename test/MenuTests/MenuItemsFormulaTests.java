package MenuTests;

import org.junit.jupiter.api.Test;
import space.realkarmakun.menu.MenuItem;
import space.realkarmakun.menu.MenuItemFormula;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MenuItemsFormulaTests {

    @Test
    public void getTitle_creatingItem_titleReturned() {
        //arrange
        MenuItem test = new MenuItemFormula();
        //act
        String result = test.getTitle();
        //assert
        assertEquals("Formula calculation", result);
    }
}