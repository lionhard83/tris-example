import java.util.ArrayList;

enum Color {
    WHITE, BLACK
};

public class Checkers {

    public String ANSI_RED = "\u001B[31m";
    public String ANSI_YELLOW = "\u001B[33m";
    public String ANSI_RESET = "\u001B[0m";
    ArrayList<Pawn> pawns = new ArrayList<>();
    Color currentPlayer = Color.WHITE;

    Checkers() {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i <= 6; i = i + 2) {
                pawns.add(new Pawn(Color.WHITE, j, i + (j == 1 ? 1 : 0)));
                pawns.add(new Pawn(Color.BLACK, j + 5, i + (j != 1 ? 1 : 0)));
            }
        }
    }

    public Pawn getPawn(int x, int y) {
        for (Pawn p : pawns) {
            if (p.x == x && p.y == y) {
                return p;
            }
        }
        return null;
    }

    public String existPawn(int x, int y) {
        for (Pawn p : pawns) {
            if (p.x == x && p.y == y) {
                return (p.getColor() == Color.WHITE ? ANSI_YELLOW : ANSI_RED)
                        + " O " + ANSI_RESET;
            }
        }
        return "   ";
    }

    public int[] convert(String position) {
        char index = position.charAt(1);
        int x = Character.getNumericValue(index) - 1;
        int y = position.charAt(0) - 65;
        int[] arr = { x, y }; // [x,y]
        return arr;
    }

    public int[] getPositionInTheMiddle(int x1, int y1, int x2, int y2) {
        int x = x1 + (this.currentPlayer == Color.WHITE ? 1 : -1);
        int y = Math.max(y1, y2) - 1; // 2 - 0 - 1
        int[] arr = { x, y };
        return arr;
    }

    public boolean rigthMove(int x1, int y1, int x2, int y2, int offset) {
        int increment = this.currentPlayer == Color.WHITE ? offset : -offset;
        return (x1 + increment == x2) && (y1 + offset == y2 || y1 - offset == y2);
    }

    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public boolean move(String from, String to) {
        int[] coord1 = convert(from);
        int[] coord2 = convert(to);
        int x1 = coord1[0];
        int y1 = coord1[1];
        int x2 = coord2[0];
        int y2 = coord2[1];

        if (isValidCoordinate(x1, y1) &&
                isValidCoordinate(x2, y2) &&
                getPawn(x1, y1).getColor() == currentPlayer &&
                getPawn(x2, y2) == null) {
            if (rigthMove(x1, y1, x2, y2, 1)) {
                Pawn p = getPawn(x1, y1);
                p.setCoords(x2, y2);
                this.currentPlayer = this.currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE;
                return true;
            } else if (rigthMove(x1, y1, x2, y2, 2)) {
                int[] coordMiddlePosition = getPositionInTheMiddle(x1, y1, x2, y2);
                Pawn pInTheMiddle = getPawn(coordMiddlePosition[0], coordMiddlePosition[1]);
                if (pInTheMiddle.getColor() != null && pInTheMiddle.getColor() != this.currentPlayer) {
                    Pawn p = getPawn(x1, y1);
                    p.setCoords(x2, y2);
                    pawns.remove(pInTheMiddle);
                    this.currentPlayer = this.currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean move(String from, ArrayList<String> to) {
        return true;
    }

    public Color getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String toString() {
        String response = " | A | B | C | D | E | F | G | H \n";
        for (int i = 7; i >= 0; i--) {
            response += (i + 1);
            for (int j = 0; j < 8; j++) {
                response += ("|" + existPawn(i, j));
            }
            response += "\n";
        }
        response += " | A | B | C | D | E | F | G | H \n";
        return response;
    }

    public boolean hasCompleted() {
        int blacks = 0;
        int whites = 0;
        for (Pawn p : pawns) {
            if (p.getColor() == Color.WHITE) {
                whites++;
            } else {
                blacks++;
            }
            if (blacks > 0 && whites > 0) {
                return false;
            }
        }
        return true;
    }

    public Color getWinner() {
        int blacks = 0;
        int whites = 0;
        for (Pawn p : pawns) {
            if (p.getColor() == Color.WHITE) {
                whites++;
            } else {
                blacks++;
            }
        }
        if (blacks == 0) {
            return Color.WHITE;
        } else if (whites == 0) {
            return Color.BLACK;
        } else {
            return null;
        }
    }
}
