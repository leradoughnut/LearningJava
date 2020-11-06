package gameJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private int pickedNumber;
    private int leftBound = GlobalConstants.PRIMARY_MIN_BARRIER;
    private int rightBound = GlobalConstants.PRIMARY_MAX_BARRIER;
    private final List<Integer> attempts = new ArrayList<>();

    public int pickNumber() {
        Random random = new Random();
        return leftBound + random.nextInt(rightBound - leftBound - 1) + 1;
    }

    public boolean isNumberInBounds(int number) {
        return leftBound < number && number < rightBound;
    }

    public boolean isNumberGuessed(int number) {
        addAttempt(number);
        if (isGreaterThan(number)) {
            setLeftBound(number);
        } else if (isLessThan(number)) {
            setRightBound(number);
        } else {
            return true;
        }
        return false;
    }

    public void setPickedNumber(int number){
        pickedNumber = number;
    }

    public boolean isGreaterThan(int number) {
        return pickedNumber > number;
    }

    public boolean isLessThan(int number) {
        return pickedNumber < number;
    }

    public void addAttempt(int number) {
        attempts.add(number);
    }

    public List<Integer> getAttempts() {
        return attempts;
    }

    public int getLeftBound() {
        return leftBound;
    }

    public int getRightBound() {
        return rightBound;
    }

    public void setRightBound(int rightBound) {
        this.rightBound = rightBound;
    }

    public void setLeftBound(int leftBound) {
        this.leftBound = leftBound;
    }

}
