package game;

import gem.Gem;
import model.Cell;
import model.GameBoard;
import model.Player;

import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private GameBoard board;

    private void startGame(){
        //TODO: khởi tạo game
        System.out.println("start game");
    }

    private void endGame(){
        //TODO: Kết thúc game
        System.out.println("endGame");
    }

    //Hàm đổi lượt giữa 2 người chơi
    private void switchTurn(){
        if(player1.isInTurn()){
            player1.setInTurn(false);
            player2.setInTurn(true);
        }else{
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
