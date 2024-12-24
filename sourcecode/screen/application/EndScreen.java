package screen.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.GameBoard;
import model.Player;
import screen.controller.EndScreenController;

public class EndScreen extends Application {
    private static GameBoard board;
    private static Player player1, player2;
    private static ShareData shareData; // Add ShareData instance

    @Override
    public void start(Stage primaryStage) {
        final String END_SCREEN_FXML_FILE_PATH = "/screen/view/EndScreen.fxml";

        // Ensure player1 and player2 have their scores updated based on game logic
        shareData = new ShareData();
        shareData.setWinnerName(player1.getName());
        shareData.setWinnerScore("100"); // Update with actual score logic

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(END_SCREEN_FXML_FILE_PATH));

        // Pass ShareData to the controller
        EndScreenController endScreenController = new EndScreenController(board, player1, player2, shareData);
        fxmlLoader.setController(endScreenController);

        try {
            Parent root = fxmlLoader.load();
            primaryStage.setScene(new Scene(root));
        } catch (Exception e) {
            System.err.println("Failed to load FXML file: " + END_SCREEN_FXML_FILE_PATH);
            e.printStackTrace();
            return;
        }

        primaryStage.setTitle("O An Quan - End game");
        primaryStage.getIcons().add(new Image("/screen/images/icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        board = new GameBoard();
        player1 = new Player(1, "Bach", 0, false);
        player2 = new Player(2, "Huy", 0, true);

        launch(args);
    }
}
