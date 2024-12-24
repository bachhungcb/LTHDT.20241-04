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

import java.io.IOException;

public class EndScreen extends Application {
    private static GameBoard board;
    private static Player player1, player2;

    public void start(Stage primaryStage) {
        final String HELP_SCREEN_FXML_FILE_PATH = "/screen/view/EndScreen.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HELP_SCREEN_FXML_FILE_PATH));
        EndScreenController endScreenController = new EndScreenController(board, player1, player2);
        fxmlLoader.setController(endScreenController);
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Image icon = new Image("/screen/images/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);

        primaryStage.setTitle("O An Quan - End game");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        board = new GameBoard();
        Player Player1 = new Player(1, "Bach", 0, false);
        Player Player2 = new Player(2, "Huy", 0, true);

        launch(args);
    }
}
