package mars_rover;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    @Test
    public void creatingDirectionsGivenTheirEncoding(){
        assertEquals(Direction.create("N"), Direction.N);
        assertEquals(Direction.create("S"), Direction.valueOf("S"));
        assertEquals(Direction.create("E"), Direction.valueOf("E"));
        assertEquals(Direction.create("W"), Direction.valueOf("W"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryingToCreateAnUnknownDirection(){
        Direction.create("X");
    }


}