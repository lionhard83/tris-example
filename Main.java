import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Checkers c = new Checkers();
        System.out.println(c);

        System.out.println(c.getCurrentPlayer());
        c.convert("H5");
        c.move("A3", "B4"); // mossa del bianco
        c.move("H6", "G5"); // mossa del nero
        c.move("B2", "A3"); // mossa del bianco
        c.move("G5", "F4"); // mossa del nero
        c.move("G3", "E5"); // mossa del nero

        String start = "G3";
        ArrayList<String> to = new ArrayList<>();
        to.add("A1");
        to.add("C3");
        to.add("H4");
        c.move(start, to);

        System.out.println(c);
        System.out.println(c.hasCompleted());
        System.out.println(c.getWinner());
    }

}