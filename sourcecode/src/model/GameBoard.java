package model;

import java.util.List;

public class GameBoard {
    private List<Cell> cells;

    // Constructor
    public GameBoard(List<Cell> cells) {
        this.cells = cells;
    }

    // Getter
    public List<Cell> getCells() {
        return cells;
    }

    // Setter
    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    // Get the score of a player
    public int getScore(Player player) {
        return player.getScore();
    }

    // Get the name of a player
    public String getPlayerName(Player player) {
        return player.getName();
    }

    // Display the game menu
    public void showMenu() {
        // TODO: Implement the menu display logic
        System.out.println("1. Start Game");
        System.out.println("2. View Scores");
        System.out.println("3. Exit");
    }
}
