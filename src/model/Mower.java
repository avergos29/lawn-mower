package model;

import java.util.Objects;

/**
 * Created by antoinevergos on 28/05/2018.
 */
public class Mower {

    private final Position position;
    private final Direction direction;

    @Override
    public String toString() {
        return "Mower{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(position, mower.position) &&
                direction == mower.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public Mower(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }
}
