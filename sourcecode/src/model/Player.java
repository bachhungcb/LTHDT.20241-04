package model;
import gem.Gem;
import gem.SmallGem;
import game.Game;
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
    
    // nhặ đá nếu cell thoả mãn điều kiện có thể nhặt & khác trống
    public boolean pickUpGemFrom(Cell cell){
        if((cell instanceof Pickable) && (!(cell.isEmpty()))){
            this.numOfGemsInHand += cell.getNUmberOfGems();
            cell.emptyCell();
            return true;
        }
        return false;
    }
    public void dropGemInto(Cell cell) {
        // Kiểm tra xem tay người chơi có còn sỏi không
        if (this.numOfGemsInHand > 0) {
            // Tạo một viên sỏi mới với vị trí là ô mục tiêu
            Gem gemToDrop = new SmallGem(cell);
            // Thêm viên sỏi mới vào danh sách sỏi trong ô mong muốn
            cell.addGem(gemToDrop);
            // Giảm số lượng sỏi trong tay người chơi đi 1
            this.numOfGemsInHand--;
        } else {
            // Nếu tay người chơi không còn sỏi, thông báo
            System.out.println("No gems in hand to drop!");
        }
    }
    // tính điểm dựa vào ô đã ăn
    public void earnGemFrom(Cell cell){    
    	if (cell instanceof HalfCircle) {
    		this.score += 5;
    		}
    	else {
    		this.score += cell.getNUmberOfGems();
    	}
    }
    public void spreadGem(Cell initPos, int handDirection, GameBoard board){
        /*
        Giả sử người chơi đã CHỌN đá quý từ ô initPosition
        Các hành động: di chuyển đến ô tiếp theo từ initPosition, thả đá quý vào ô đó, tiếp tục di chuyển tới các ô gần đó
        Hướng di chuyển:
            0: theo chiều kim đồng hồ
            1: ngược chiều kim đồng hồ
        */

        this.handPosition = initPos;
        if(handDirection == 0){ // theo chiều kim đồng hồ
            // Rải đá quý lần đầu tiên
            for(int i = 1; i <= numOfGemsInHand; i++){ 
                handPosition = board.getNextCellClockwise(handPosition);
                dropGemInto(handPosition);
            }

            // Kiểm tra tiếp tục lượt
            Cell nextHandPosition = board.getNextCellClockwise(handPosition);
            if(!nextHandPosition.isEmpty()){
                if(!(nextHandPosition instanceof HalfCircle)){ // có thể rải thêm đá quý
                    pickUpGemFrom(nextHandPosition);
                    spreadGem(nextHandPosition, handDirection, board);
                }
            } else { // Có thể thu thập điểm từ ô này
                // Nếu ô tiếp theo trống, kiểm tra ô sau nữa để ăn sỏi
                while(nextHandPosition.isEmpty() &&
                      !(board.getNextCellClockwise(nextHandPosition).isEmpty())){
                    // Kiểm tra nếu ô sau có sỏi của đối phương thì ăn sỏi
                    Cell nextNextPosition = board.getNextCellClockwise(nextHandPosition);
                    if(nextNextPosition != null && nextNextPosition.isUpperRow()) {
                        earnGemFrom(nextNextPosition);
                        
                    }
                }
            }
        } else if(handDirection == 1){ // Ngược chiều kim đồng hồ
            // Rải đá quý lần đầu tiên
            for(int i = 1; i <= numOfGemsInHand; i++){ 
                handPosition = board.getNextCellCounterClockwise(handPosition);
                dropGemInto(handPosition);
            }

            // Kiểm tra tiếp tục lượt
            Cell nextHandPosition = board.getNextCellCounterClockwise(handPosition);
            if(!nextHandPosition.isEmpty()){
                if(!(nextHandPosition instanceof HalfCircle)){ // có thể rải thêm đá quý
                    pickUpGemFrom(nextHandPosition);
                    spreadGem(nextHandPosition, handDirection, board);
                }
            } else { // Có thể thu thập điểm từ ô này
                // Nếu ô tiếp theo trống, kiểm tra ô sau nữa để ăn sỏi
                while(nextHandPosition.isEmpty() &&
                      !(board.getNextCellCounterClockwise(nextHandPosition).isEmpty())){
                    // Kiểm tra nếu ô sau có sỏi của đối phương thì ăn sỏi
                    Cell nextNextPosition = board.getNextCellCounterClockwise(nextHandPosition);
                    if(nextNextPosition != null && nextNextPosition.isUpperRow()) {
                        earnGemFrom(nextNextPosition);
                    }
                }
            }
        }
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
