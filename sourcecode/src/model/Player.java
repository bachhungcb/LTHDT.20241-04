package model;

public class Player {
    private int playerID;
    private String name;
    private int score;
    private boolean isUpperRow;
    private Cell handPosition;
    private boolean inTurn;
    private int numOfGemsInHand;
    private int numOfGemsLent;
    private int numOfGemsBorrowed;
    //Cần phải lưu ý rằng, từ code có thể chuyển ngược lại diagram nên trong khi code
    //Cứ thoải mái trong việc tạo Getter và Setter, đến cuối, IntelliJ có thể safe delete những hàm k sử dụng

    //Getter
    public int getPlayerID() {
        return playerID;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public Cell getHandPosition() {
        return handPosition;
    }
    public int getNumOfGemsInHand() {
        return numOfGemsInHand;
    }
    public int getNumOfGemsLent() {
        return numOfGemsLent;
    }
    public int getNumOfGemsBorrowed() {
        return numOfGemsBorrowed;
    }
    public boolean isUpperRow() {
        return isUpperRow;
    }
    public boolean isInTurn() {
        return inTurn;
    }

    //Setter
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setUpperRow(boolean upperRow) {
        isUpperRow = upperRow;
    }
    public void setHandPosition(Cell handPosition) {
        this.handPosition = handPosition;
    }
    public void setInTurn(boolean inTurn) {
        this.inTurn = inTurn;
    }
    public void setNumOfGemsInHand(int numOfGemsInHand) {
        this.numOfGemsInHand = numOfGemsInHand;
    }
    public void setNumOfGemsLent(int numOfGemsLent) {
        this.numOfGemsLent = numOfGemsLent;
    }
    public void setNumOfGemsBorrowed(int numOfGemsBorrowed) {
        this.numOfGemsBorrowed = numOfGemsBorrowed;
    }

    public Player(int playerID, String name, int score, boolean isUpperRow, boolean inTurn, int numOfGemsInHand, int numOfGemsLent, int numOfGemsBorrowed) {
        this.playerID = playerID;
        this.name = name;
        this.score = score;
        this.isUpperRow = isUpperRow;
        this.inTurn = inTurn;
        this.numOfGemsInHand = numOfGemsInHand;
        this.numOfGemsLent = numOfGemsLent;
        this.numOfGemsBorrowed = numOfGemsBorrowed;
    }

    @Override
    public String toString(){
        return "Player{" +
                "playerID=" + playerID +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", isUpperRow=" + isUpperRow +
                ", inTurn=" + inTurn +
                ", numOfGemsInHand=" + numOfGemsInHand +
                ", numOfGemsLent=" + numOfGemsLent +
                ", numOfGemsBorrowed=" + numOfGemsBorrowed +
                '}';
    }
}
