package screen.application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShareData {
    private StringProperty winnerName = new SimpleStringProperty();
    private StringProperty winnerScore = new SimpleStringProperty();

    public void setWinnerName(String winnerName) {
        this.winnerName.set(winnerName);
    }

    public void setWinnerScore(String winnerScore) {
        this.winnerScore.set(winnerScore);
    }

    public String getWinnerName() {
        return winnerName.get();
    }

    public StringProperty winnerNameProperty() {
        return winnerName;
    }

    public String getWinnerScore() {
        return winnerScore.get();
    }

    public StringProperty winnerScoreProperty() {
        return winnerScore;
    }

}
