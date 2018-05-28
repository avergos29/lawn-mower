package model;

/**
 * Created by antoinevergos on 28/05/2018.
 */
public enum Action {
    FORWARD,
    TURN_LEFT,
    TURN_RIGHT;


    public static Action fromChar(int s) {
        if( s == Character.valueOf('F')) return FORWARD;
        if( s == Character.valueOf('L')) return TURN_LEFT;
        if( s == Character.valueOf('R')) return TURN_RIGHT;
        throw new IllegalStateException("Unknown action " + s);
    }

}
