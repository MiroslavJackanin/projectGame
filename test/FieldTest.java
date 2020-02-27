import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Field;
import sample.Tile;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    private Field testField;

    @BeforeEach
    void setUp() {
        testField = new Field();
    }

    @AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void isWinner(){
        assertTrue(testField.isWon());
        //testField.getTiles()[1][1].toggle();
        //assertFalse(testField.isWon());

        for (int j=0; j<4; j++){
            for (int i=0; i<4; i++){
                testField.getTiles()[i][j].toggle();
            }
        }
        assertTrue(testField.isWon());
    }

    @Test
    void testToggle1(){
        testField.toggleTiles(0);
        assertFalse(testField.getTiles()[0][0].isValue());
        assertTrue(testField.getTiles()[1][0].isValue());
        assertTrue(testField.getTiles()[1][0].isValue());
        assertTrue(testField.getTiles()[1][1].isValue());
    }

    @Test
    void testToggle2(){
        testField.toggleTiles(2);
        assertFalse(testField.getTiles()[2][0].isValue());
        assertTrue(testField.getTiles()[1][0].isValue());
        assertTrue(testField.getTiles()[3][0].isValue());
        assertTrue(testField.getTiles()[1][1].isValue());
        assertTrue(testField.getTiles()[2][1].isValue());
        assertTrue(testField.getTiles()[3][1].isValue());
    }

    @Test
    void testToggle3(){
        testField.toggleTiles(6);
        assertFalse(testField.getTiles()[2][1].isValue());
        assertTrue(testField.getTiles()[1][1].isValue());
        assertTrue(testField.getTiles()[3][1].isValue());
        assertTrue(testField.getTiles()[2][0].isValue());
        assertTrue(testField.getTiles()[2][2].isValue());
        assertTrue(testField.getTiles()[3][2].isValue());
    }
}