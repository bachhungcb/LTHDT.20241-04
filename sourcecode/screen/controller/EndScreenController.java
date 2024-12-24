package screen.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.GameBoard;
import model.Player;
import screen.application.ShareData;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class EndScreenController implements Initializable {
    private final GameBoard board;
    private final Player player1, player2;
    private final ShareData data;
    public EndScreenController(GameBoard board, Player player1, Player player2, ShareData data) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.data = data;
    }

    @FXML
    private Label winnerName;

    @FXML
    private Label winnerScore;

    @FXML
    private Button btnBackFromEndScreen;

    @FXML
    void btnBackFromEndScreenClicked(ActionEvent event) {
        try {
            // TODO while playing: just a pop-up

            final String INTRO_SCREEN_FILE_PATH = "/screen/view/IntroScreen.fxml";

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(INTRO_SCREEN_FILE_PATH));
            fxmlLoader.setController(new IntroScreenController(board, player1, player2, data));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Intro Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing EndScreenController...");
        System.out.println("winnerName: " + winnerName);  // Should print the label instance
        System.out.println("winnerScore: " + winnerScore);  // Should print the label instance

        // Ensure that the ShareData properties are properly bound
        if (winnerName != null && winnerScore != null) {
            // Binding the label texts to the ShareData properties
            winnerName.textProperty().bind(data.winnerNameProperty());
            winnerScore.textProperty().bind(data.winnerScoreProperty());

            // Debug print to confirm property values
            System.out.println("Winner Name: " + data.winnerNameProperty().get());
            System.out.println("Winner Score: " + data.winnerScoreProperty().get());
        } else {
            System.out.println("FXML injection failed, labels are null.");
        }
    }


}
