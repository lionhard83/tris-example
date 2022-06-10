public class Game {

    private String[][] board = new String[3][3];
    private String currentPlayer = "X";
    private boolean hasCompleted = false;
    private String winner = null;

    public Game() {
    }

    public Game(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void togglePlayer() {
        this.currentPlayer = this.currentPlayer == "X" ? "O" : "X";
    }

    public void setPosition(int x, int y) {
        if (x >= 0 && y >= 0 && x <= 2 && y <= 2 && this.board[x][y] == null && !this.hasCompleted) {
            this.board[x][y] = this.currentPlayer;
            if (hasWinnerCurrentPlayer()) {
                this.winner = this.currentPlayer;
                this.hasCompleted = true;
            } else {
                this.togglePlayer();
            }

        }
    }

    public boolean hasWinnerCurrentPlayer() {
        return this.checkWinnerRow() || this.checkWinnerColumn() || this.checkDiagonal();
    }

    public boolean checkWinnerRow() {
        for (int i = 0; i <= 2; i++) {
            if (this.board[i][0] != null && this.board[i][0] == this.board[i][1]
                    && this.board[i][1] == this.board[i][2]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkWinnerColumn() {
        for (int i = 0; i <= 2; i++) {
            if (this.board[0][i] != null && this.board[0][i] == this.board[1][i]
                    && this.board[1][i] == this.board[2][i]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal() {
        return (this.board[0][0] != null && this.board[0][0] == this.board[1][1]
                && this.board[1][1] == this.board[2][2]) ||
                (this.board[2][0] != null && this.board[2][0] == this.board[1][1]
                        && this.board[1][1] == this.board[0][2]);
    }

    public String toString() {
        String response = "";
        for (String[] row : this.board) {
            response += '|';
            for (String item : row) {
                response += item != null ? item : " ";
                response += '|';
            }
            response += '\n';
        }
        if (this.winner != null) {
            response += "The winner is: " + this.winner;
        }
        return response;
    }

}
