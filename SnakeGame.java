import java.util.ArrayList;
import java.util.Random;

enum Direction {
    UP, DOWN, LEFT, RIGHT
}

public class SnakeGame {
    private int width;
    private int heigth;
    private boolean inProgress = true;
    private Direction forbiddenDirection = Direction.RIGHT;
    ArrayList<Coordinate> snake = new ArrayList<>();
    Coordinate food;

    SnakeGame(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        Coordinate c1 = new Coordinate(3, 3);
        Coordinate c2 = new Coordinate(4, 3);
        Coordinate c3 = new Coordinate(5, 3);
        Coordinate c4 = new Coordinate(6, 3);
        this.snake.add(c1);
        this.snake.add(c2);
        this.snake.add(c3);
        this.snake.add(c4);
        this.food = generateRandomCoordinate();
    }

    public Coordinate getNewCoordinate(Coordinate head, Direction d) {
        int x;
        int y;
        switch (d) {
            case LEFT:
                x = head.getX() - 1;
                y = head.getY();
                this.forbiddenDirection = Direction.RIGHT;
                return new Coordinate(x, y);
            case RIGHT:
                x = head.getX() + 1;
                y = head.getY();
                this.forbiddenDirection = Direction.LEFT;
                return new Coordinate(x, y);
            case DOWN:
                x = head.getX();
                y = head.getY() + 1;
                this.forbiddenDirection = Direction.UP;
                return new Coordinate(x, y);
            case UP:
                x = head.getX();
                y = head.getY() - 1;
                this.forbiddenDirection = Direction.DOWN;
                return new Coordinate(x, y);
        }
        return null;
    }

    public Coordinate generateRandomCoordinate() {
        Random rand = new Random(); // instance of random class
        int randomX = rand.nextInt(heigth - 1);
        int randomY = rand.nextInt(width - 1);
        for (Coordinate c : this.snake) {
            if (c.getX() == randomX && c.getY() == randomY) {
                // nama cunchiurutu nenti
                return generateRandomCoordinate();
            }
        }
        return new Coordinate(randomX, randomY);

    }

    public void move(Direction d) {
        if (!this.inProgress || d == forbiddenDirection) {
            return;
        }
        // ADD in HEAD
        Coordinate c = getNewCoordinate(this.snake.get(0), d);
        // qui verifico se la coordinata è dentro il serpente
        // o fuori dai bordi
        this.inProgress = coordinateIsValid(c);

        if (this.inProgress) {
            this.snake.add(0, c);
            if (c.getX() == food.getX() && c.getY() == food.getY()) {
                // quando mangio
                this.food = generateRandomCoordinate();
            } else {
                // quando non mangiox
                this.snake.remove(this.snake.size() - 1);
            }
        }
    }

    public boolean coordinateIsValid(Coordinate newCoordinateToCheck) {
        if (newCoordinateToCheck.getX() < 0 ||
                newCoordinateToCheck.getY() < 0 ||
                newCoordinateToCheck.getX() > heigth ||
                newCoordinateToCheck.getY() > width) {
            return false;
        }
        for (Coordinate c : this.snake) {
            if (c.getX() == newCoordinateToCheck.getX() && c.getY() == newCoordinateToCheck.getY()) {
                return false;
            }
        }
        return true;
    }

    public boolean containInThisCoordanate(int x, int y) {
        for (Coordinate c : this.snake) {
            if (c.getX() == x && c.getY() == y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String response = "";
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                if (food.getX() == i && food.getY() == j) {
                    response += "|*";
                } else if (containInThisCoordanate(j, i)) {
                    if (this.snake.get(0).getX() == j && this.snake.get(0).getY() == i) {
                        response += "|#";
                    } else {
                        response += "|O";
                    }
                } else {
                    response += "| ";
                }
            }
            response += "|\n";
        }
        response += this.inProgress ? "\nIn Corso" : "\nTerminata";
        return response;
    }
}
