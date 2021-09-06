package ladderrefactoring.domain.ladder;

import ladderrefactoring.exception.CustomException;
import ladderrefactoring.strategy.DirectionStrategy;
import ladderrefactoring.strategy.RandomDirectionStrategy;

import java.util.Objects;

public class Direction {

    public static final String EXIST_TRUE_REPETITION = "연속된 사다리가 존재 합니다.";
    protected static DirectionStrategy directionStrategy = new RandomDirectionStrategy();

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        checkTrueRepetition(left, right);
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first() {
        return of(false, directionStrategy.create());
    }

    public Direction next() {
        if (this.right) {
            return of(true, false);
        }
        return of(false, directionStrategy.create());
    }

    public Direction last() {
        return of(this.right, false);
    }

    private void checkTrueRepetition(boolean beforeValue, boolean currentValue) {
        if (beforeValue && currentValue) {
            throw new CustomException(EXIST_TRUE_REPETITION);
        }
    }

    public boolean left() {
        return left;
    }

    public boolean right() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}