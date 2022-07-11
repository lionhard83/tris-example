public class Pawn {
    private Color color;
    int x;
    int y;

    Pawn(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return "color:" + this.color + " " + this.x + " " + this.y;
    }
}
