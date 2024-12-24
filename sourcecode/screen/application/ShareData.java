package screen.application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShareData {
    private final StringProperty winnerName = new SimpleStringProperty();
    private final StringProperty winnerScore = new SimpleStringProperty();

    public StringProperty winnerNameProperty() {
        return winnerName;
    }

    public StringProperty winnerScoreProperty() {
        return winnerScore;
    }

    // Setters and Getters for the properties
    public void setWinnerName(String name) {
        winnerName.set(name);
    }

    public void setWinnerScore(String score) {
        winnerScore.set(score);
    }

}
