package lawn.mower.model;

/**
 * Created by antoinevergos on 28/05/2018.
 */
public enum Direction {

    NORTH(0,1),
    EAST(1,0),
    SOUTH(0,-1),
    WEST(-1,0);

    Direction(int dx, int dy){
        this.dx =dx;
        this.dy=dy;
    }


    private final int dx;
    private final int dy;


    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public static Direction turnLeft(Direction direction) {
        switch (direction){
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
        }
        return direction;
    }

    public static Direction turnRight(Direction direction) {
        switch (direction){
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
        }
        return direction;
    }

    public static Direction fromString(String s) {
        if(s.equals("S")) return SOUTH;
        if(s.equals("N")) return NORTH;
        if(s.equals("E")) return EAST;
        if(s.equals("W")) return WEST;
        throw new IllegalStateException("Unkown direction " + s);
    }

    public static String getOutputValue(Direction d) {
        switch (d){
            case NORTH:
                return "N";
            case EAST:
                return "E";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
        }
        throw new IllegalStateException("Unkown direction " + d);
    }
}
