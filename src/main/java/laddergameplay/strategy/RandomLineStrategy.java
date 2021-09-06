package laddergameplay.strategy;

import java.util.Random;

public class RandomLineStrategy implements LineStrategy {

    private static final Random random = new Random();

    private boolean currentPoint = false;

    @Override
    public boolean create() {
        if(checkCurrentPoint()){
            currentPoint = false;
            return false;
        }
        currentPoint = currentPoint();
        return currentPoint;
    }

    protected boolean currentPoint() {
        return random.nextBoolean();
    }

    protected boolean checkCurrentPoint(){
        return currentPoint;
    }
}