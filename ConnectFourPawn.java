
public class ConnectFourPawn extends Coordinate {
    String color = "red";
    public String ANSI_RESET = "\u001B[0m";
    public String ANSI_RED = "\u001B[31m";
    public String ANSI_YELLOW = "\u001B[33m";

    ConnectFourPawn(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.color == "red") {
            return ANSI_RED + "O" + ANSI_RESET;
        } else {
            return ANSI_YELLOW + "O" + ANSI_RESET;
        }
    }
}
