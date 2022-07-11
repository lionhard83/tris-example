public class Main2 {
    public static void main(String[] args) {
        SnakeGame s = new SnakeGame(10, 10);
        System.out.println(s);
        s.move(Direction.LEFT);
        System.out.println(s);
        s.move(Direction.LEFT);
        System.out.println(s);
        s.move(Direction.LEFT);
        System.out.println(s);
        s.move(Direction.LEFT);
        System.out.println(s);
        s.move(Direction.LEFT);
        // s.move(Direction.UP);
        // System.out.println(s);
        // s.move(Direction.LEFT);
        // System.out.println(s);
        // s.move(Direction.DOWN);
        // System.out.println(s);
    }
}
