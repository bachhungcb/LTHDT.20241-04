package game;

import java.util.List;

import gem.Gem;
import model.Cell;
import model.GameBoard;
import model.Player;

public class Game {
    private Player player1;
    private Player player2;
    private GameBoard board;
 // Constructor để khởi tạo game
    public Game(Player player1, Player player2, GameBoard board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }
    public void startGame() {
        player1.setInTurn(Math.random() < 0.5);
        System.out.println("Game has started!");
        System.out.println((player1.isInTurn() ? player1.getName() : player2.getName()) + " plays first.");
        playGame();

    }

 // Method to simulate playing the game
    private void playGame() {
    	//TODO
        // Assume there's a game loop here to continue until the game is over
        while (!checkGameOver()) {
            System.out.println((player1.isInTurn() ? player1.getName() : player2.getName()) + "'s turn.");
            
            // Player's turn logic
            //makeMove();

            switchTurn();  // Switch turn after each move
        }

        endGame();  // End the game when it's over
    }


    private void endGame(){
        //TODO: Kết thúc game
    	if(checkGameOver()) {
    		player1.setInTurn(false);
    		player2.setInTurn(false);
    		Player winner = determineWinner();
    		System.out.println("endGame");
    		
    	}
    }

    private void switchTurn() {
        if (player1.isInTurn()) {
            player1.setInTurn(false);
            player2.setInTurn(true);
        } else {
            player2.setInTurn(false);
            player1.setInTurn(true);
        }
    }


    private boolean checkGameOver(){
        //TODO:  kiểm tra lại cách List<Cell> cells ở gameboard có trả về HalfCircle không.
        if(Cell.isGameOver(boảd.getCells)){
            Player winner = determineWinner();
            System.out.println("Game over! Winner: " + winner.toString());
            return true;
        }
        return false;
    }

    //Check who is the winner by comparing score
    private Player determineWinner(){
        if(player1.getScore() > player2.getScore()){
            System.out.println("Player 1 is the winner");
            return player1;
        }else if(player1.getScore() < player2.getScore()){
            System.out.println("Player 2 is the winner");
            return  player2;
        }
        System.out.println("There is no winner");
        return null;
    }

    private boolean validateMove(){
        //TODO: validate Move
        return false;
    }

    //this is function to calculate the score of a cell
    //not to calculate the final score
    private int calculateScore(Cell cell){
        int score = 0;
        List<Gem> gems = cell.getGems();

        if (gems != null) {
            for (Gem gem : gems) {
                score += gem.getValue();
            }
        }

        return score;
    }
}
