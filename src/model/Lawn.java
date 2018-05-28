package model;

import java.util.Objects;

/**
 * Created by antoinevergos on 28/05/2018.
 */
public class Lawn {

    private Position bottomLeftCorner;
    private Position topRightCorner;

    @Override
    public String toString() {
        return "Lawn{" +
                "bottomLeftCorner=" + bottomLeftCorner +
                ", topRightCorner=" + topRightCorner +
                '}';
    }

    public Lawn(Position topRightCorner) {
        this.bottomLeftCorner = new Position(0,0);
        this.topRightCorner = topRightCorner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lawn lawn = (Lawn) o;
        return Objects.equals(bottomLeftCorner, lawn.bottomLeftCorner) &&
                Objects.equals(topRightCorner, lawn.topRightCorner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottomLeftCorner, topRightCorner);
    }

    public Position getBottomLeftCorner() {

        return bottomLeftCorner;
    }

    public Position getTopRightCorner() {
        return topRightCorner;
    }
}
