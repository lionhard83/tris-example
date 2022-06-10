import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Date d = new Date();
        System.out.println(d.getTime());
        Game g1 = new Game();
        g1.setPosition(0, 0);
        System.out.println(g1);
        g1.setPosition(0, 1);
        System.out.println(g1);
        g1.setPosition(1, 0);
        System.out.println(g1);
        g1.setPosition(1, 1);
        System.out.println(g1);
        g1.setPosition(2, 0);
        System.out.println(g1);
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        Date d2 = new Date();
        System.out.println(d2.getTime());

    }

}