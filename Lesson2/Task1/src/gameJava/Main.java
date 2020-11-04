package gameJava;

public class Main {

    public static void main(String[] args) {
        int leftBound = 0;
        int rightBound = 100;
        Model model = new Model(leftBound, rightBound);
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processUser();
    }
}