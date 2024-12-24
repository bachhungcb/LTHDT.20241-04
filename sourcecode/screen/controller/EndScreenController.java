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


public  class EndScreenController implements Initializable {
    private final GameBoard board;
    private final Player player1, player2;
    private PlayScreenController playScreenController;
    private ShareData data;
    public EndScreenController(GameBoard board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Button getBtnBackFromEndScreen() {
        return btnBackFromEndScreen;
    }

    public GameBoard getBoard() {
        return board;
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
            fxmlLoader.setController(new IntroScreenController(board, player1, player2));
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
        data.winnerNameProperty().addListener((observable, oldValue, newValue) -> {
            winnerName.setText(newValue);
        });
        data.winnerScoreProperty().addListener(((observable, oldValue, newValue) -> {
            winnerScore.setText(newValue);
        }));
    }
}
