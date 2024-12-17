package screen.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.GameBoard;
import model.Player;
import screen.controller.PlayScreenController;


import java.io.IOException;


public class PlayScreen extends Application {
    private static GameBoard board;
    private static Player player1;
    private static Player player2;

    @Override
    public void start(Stage primaryStage) {
        // Correct relative path to the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/screen/view/PlayScreen.fxml"));
        PlayScreenController playScreenController = new PlayScreenController(board, player1, player2);
        fxmlLoader.setController(playScreenController);

        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image icon = new Image("/screen/images/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.setTitle("O An Quan");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        board = new GameBoard();
        player1 = new Player(1, "Bach", 0, false);
        player2 = new Player(2, "Huy", 0, true);

        launch(args);
    }
}

