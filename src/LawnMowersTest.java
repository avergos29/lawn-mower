import model.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by antoinevergos on 28/05/2018.
 */
public class LawnMowersTest {

    private LawnMowers lm = new LawnMowers(
            new Lawn(new Position(5,5)));

    @Test(expected =
            NullPointerException.class)
   public void testLawnCannotBeNull(){
        new LawnMowers(null);
    }

    @Test
    public void turnLeft(){
        Mower m = new Mower(new Position(0,0), Direction.EAST);
        m= lm.processMower(m, Arrays.asList(Action.TURN_LEFT));
        assertEquals(new Mower(new Position(0,0), Direction.NORTH),m);
        m=lm.processMower(m, Arrays.asList(Action.TURN_LEFT));
        assertEquals(new Mower(new Position(0,0), Direction.WEST),m);
        m=lm.processMower(m, Arrays.asList(Action.TURN_LEFT));
        assertEquals(new Mower(new Position(0,0), Direction.SOUTH),m);
        m=lm.processMower(m, Arrays.asList(Action.TURN_LEFT));
        assertEquals(new Mower(new Position(0,0), Direction.EAST),m);
    }

    @Test
    public void turnRight(){
        Mower m = new Mower(new Position(0,0), Direction.EAST);
        m= lm.processMower(m, Arrays.asList(Action.TURN_RIGHT));
        assertEquals(new Mower(new Position(0,0), Direction.SOUTH),m);
        m=lm.processMower(m, Arrays.asList(Action.TURN_RIGHT));
        assertEquals(new Mower(new Position(0,0), Direction.WEST),m);
        m=lm.processMower(m, Arrays.asList(Action.TURN_RIGHT));
        assertEquals(new Mower(new Position(0,0), Direction.NORTH),m);
        m=lm.processMower(m, Arrays.asList(Action.TURN_RIGHT));
        assertEquals(new Mower(new Position(0,0), Direction.EAST),m);
    }

    @Test
    public void moveForward(){
        Mower m = new Mower(new Position(0,0), Direction.EAST);
        m = lm.processMower(m, Arrays.asList(Action.FORWARD));
        m = lm.processMower(m, Arrays.asList(Action.FORWARD));
        m = lm.processMower(m, Arrays.asList(Action.FORWARD));
        assertEquals(new Mower(new Position(3,0), Direction.EAST), m);
    }

    @Test
    public void testCannotMove(){
        Mower m = new Mower(new Position(0,0), Direction.SOUTH);
        assertEquals(m, lm.processMower(m, Arrays.asList(Action.FORWARD)));

        m = new Mower(new Position(3,5), Direction.NORTH);
        assertEquals(m, lm.processMower(m, Arrays.asList(Action.FORWARD)));

        m = new Mower(new Position(5,5), Direction.EAST);
        assertEquals(m, lm.processMower(m, Arrays.asList(Action.FORWARD)));

        m = new Mower(new Position(0,2), Direction.WEST);
        assertEquals(m, lm.processMower(m, Arrays.asList(Action.FORWARD)));
    }
}