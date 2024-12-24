package screen.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import model.GameBoard;
import model.Player;
import screen.application.ShareData;


import java.io.IOException;
import java.util.Optional;


public class IntroScreenController {
    private final GameBoard board;
    private final Player player1;
    private final Player player2;
    private final ShareData data;
    public IntroScreenController (GameBoard board, Player player1, Player player2, ShareData data) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.data = data;
    }


    @FXML
    private Button btnStartGame;

    @FXML
    private Button btnAccessHelp;

    @FXML
    private Button btnExitGame;

    @FXML
    void btnAccessHelpClicked(ActionEvent event) {
        try {
            final String HELP_SCREEN_FILE_PATH = "/screen/view/HelpScreen.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HELP_SCREEN_FILE_PATH));
            fxmlLoader.setController(new HelpScreenController(board, player1, player2, data));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // set new scene for current stage
            stage.setScene(new Scene(root));
            stage.setTitle("Help Screen");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @FXML
    void btnExitGameClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Exit Game");
        alert.setContentText("Are you sure you want to exit?");
        Optional<ButtonType> res = alert.showAndWait();
        if(res.get() == ButtonType.OK) {
            // quit game
            Stage stage = (Stage) btnExitGame.getScene().getWindow();
            stage.close();
        } else {
            // close dialog
            alert.close();
        }

    }

    @FXML
    public void btnStartGameClicked(ActionEvent event) {
        try {

            final String PLAY_SCREEN_FILE_PATH = "/screen/view/PlayScreen.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PLAY_SCREEN_FILE_PATH));
            fxmlLoader.setController(new PlayScreenController(board, player1, player2, data));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // set new scene for current stage
            stage.setScene(new Scene(root));
            stage.setTitle("Play Screen");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the error gracefully
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to load the game screen.", ButtonType.OK);
            alert.showAndWait();
        }
    }

}

