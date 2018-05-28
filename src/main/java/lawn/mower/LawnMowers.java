package lawn.mower;

import lawn.mower.model.*;

import java.util.List;
import java.util.Objects;

/**
 * Created by antoinevergos on 28/05/2018.
 */
public class LawnMowers {
    private final Lawn lawn;

    public LawnMowers(Lawn lawn) {
        Objects.requireNonNull(lawn);
        this.lawn = lawn;
    }

    public Mower processMower(Mower mower, List<Action> actions){
        Mower m = mower;
        for(Action a : actions){
            m = this.move(m, a);
        }
        return m;
    }

    private Mower move(Mower mower, Action action) {
        switch(action){
            case FORWARD:
                return forward(mower);
            case TURN_LEFT:
                return new Mower(mower.getPosition(), Direction.turnLeft(mower.getDirection()));
            case TURN_RIGHT:
                return new Mower(mower.getPosition(), Direction.turnRight(mower.getDirection()));
            default:
            throw new IllegalStateException("Unknown action "+ action);
        }
    }

    private Mower forward(Mower mower) {
       Mower m= new Mower( new Position(
                mower.getPosition().getX()+mower.getDirection().getDx(),
                mower.getPosition().getY()+ mower.getDirection().getDy()),
                mower.getDirection());
        if( isInside(m)){
            return m;
        }else {
            return mower;
        }
    }

    private boolean isInside(Mower m) {
        return m.getPosition().getX() >= 0 && m.getPosition().getX() <=lawn.getTopRightCorner().getX() &&
        m.getPosition().getY()>=0 && m.getPosition().getY() <= lawn.getTopRightCorner().getY();
    }


}
