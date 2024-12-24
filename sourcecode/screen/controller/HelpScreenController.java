package screen.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.GameBoard;
import model.Player;
import screen.application.ShareData;

import java.io.IOException;

public class HelpScreenController {
    private final GameBoard board;
    private final Player player1, player2;
    private final ShareData data;
    public HelpScreenController(GameBoard board, Player player1, Player player2, ShareData data) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.data = data;
    }

    @FXML
    private Button btnBackFromHelpScreen;

    @FXML
    void btnBackFromHelpScreenClicked(ActionEvent event) {
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
}
