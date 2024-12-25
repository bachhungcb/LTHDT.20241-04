package screen.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.GameBoard;
import model.Player;
import screen.application.ShareData;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Exit Game");
        alert.setContentText("Are you sure you want to exit?");
        Optional<ButtonType> res = alert.showAndWait();
        if(res.get() == ButtonType.OK) {
            // quit game
            Stage stage = (Stage) btnBackFromEndScreen.getScene().getWindow();
            stage.close();
        } else {
            // close dialog
            alert.close();
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
