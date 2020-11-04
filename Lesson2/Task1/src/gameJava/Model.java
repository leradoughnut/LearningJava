package gameJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private final int pickedNumber;
    private int leftBound;
    private int rightBound;
    private Random random = new Random();
    private final List<Integer> attempts = new ArrayList<>();

    public Model(int leftBound, int rightBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        pickedNumber = pickNumber();
    }

    private int pickNumber() {
        return leftBound + random.nextInt(rightBound - leftBound + 1);
    }

    public boolean isNumberInBounds(int number) {
        return leftBound <= number && number <= rightBound;
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

    public int getPickedNumber() {
        return pickedNumber;
    }

    public void setRightBound(int rightBound) {
        this.rightBound = rightBound;
    }

    public void setLeftBound(int leftBound) {
        this.leftBound = leftBound;
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

}
