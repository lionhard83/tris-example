import java.util.ArrayList;

public class Table {
    private int heigth;
    private int width;
    public ArrayList<Coordinate> coords = new ArrayList<>();

    Table(int heigth, int width) {
        this.heigth = heigth;
        this.width = width;
    }

    public Coordinate containInThisCoordanate(int x, int y) {
        for (Coordinate c : this.coords) {
            if (c.getX() == x && c.getY() == y) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String response = "";
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                Coordinate c = containInThisCoordanate(j, i);
                if (c != null) {
                    response += "|" + c.toString();
                } else {
                    response += "| ";
                }
            }
            response += "|\n";
        }
        return response;
    }
}
