package model;
import java.util.ArrayList;
import java.util.List;

import gem.Gem;
import gem.SmallGem;
import model.GameBoard;

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
    private ArrayList<Cell> cellsOnSide = new ArrayList<Cell>();

    // Constructor
    public Player(int playerID, String name, int score, boolean isUpperRow) {
        this.playerID = playerID;
        this.name = name;
        this.score = score;
        this.isUpperRow = isUpperRow;
        this.inTurn = false;
        this.numOfGemsInHand = 0;
        this.numOfGemsLent = 0;
        this.numOfGemsBorrowed = 0;
    }

    // Getter và Setter (không đổi)
    public int getPlayerID() { return playerID; }
    public int getScore() { return score; }
    public boolean isUpperRow() { return isUpperRow; }
    public boolean isInTurn() { return inTurn; }
    public String getName() {
        return name;
    }
    public ArrayList<Cell> getCellsOnSide() {
        return cellsOnSide;
    }

    public void setScore(int score) { this.score = score; }
    public void setInTurn(boolean inTurn) { this.inTurn = inTurn; }
    public void setCellsOnSide(ArrayList<Cell> cellsOnSide) {
        this.cellsOnSide = cellsOnSide;
    }

    // Nhặt sỏi từ ô thỏa mãn điều kiện
    public boolean pickUpGemFrom(Cell cell) {
        if (cell instanceof Pickable && !cell.isEmpty()) {
            this.numOfGemsInHand += cell.getNUmberOfGems();
            cell.emptyCell();
            return true;
        }
        return false;
    }

    // Rải sỏi vào ô
    public void dropGemInto(Cell cell) {
        if (this.numOfGemsInHand > 0) {
            Gem gemToDrop = new SmallGem(cell);
            cell.addGem(gemToDrop);
            this.numOfGemsInHand--;
        }
    }

    // Ăn điểm từ ô đã chỉ định
    public void earnGemFrom(Cell cell) {
        if (cell instanceof HalfCircle) {
            this.score += 5;
        } else {
            this.score += cell.getNUmberOfGems();
        }
        cell.emptyCell();
    }

    // Rải và kiểm tra điều kiện luật chơi
    public void spreadGem(Cell initPos, int handDirection, GameBoard board) {
        this.handPosition = initPos;

        // Điều kiện rải lần đầu tiên
        while (this.numOfGemsInHand > 0) {
            if (handDirection == 0) { // Theo chiều kim đồng hồ
                handPosition = board.getNextCellClockwise(handPosition);
            } else { // Ngược chiều kim đồng hồ
                handPosition = board.getNextCellCounterClockwise(handPosition);
            }
            dropGemInto(handPosition);
        }

        // Kiểm tra ô tiếp theo
        Cell nextCell = (handDirection == 0) ? board.getNextCellClockwise(handPosition) : board.getNextCellCounterClockwise(handPosition);
        
        if (nextCell.isEmpty()) {
            // Nếu ô tiếp theo trống → kiểm tra ô sau để ăn sỏi 
            Cell nextNextCell = (handDirection == 0) ? board.getNextCellClockwise(nextCell) : board.getNextCellCounterClockwise(nextCell);
            // ô sau k trống thì ăn sỏi 
            if (!nextNextCell.isEmpty() && !(nextNextCell instanceof HalfCircle)) {
                earnGemFrom(nextNextCell);
            }
            else if(nextNextCell.isEmpty()) {
            	// mất lượt nếu 2 ô trống liên tiếp
            	this.inTurn=false;
            	return;
            }
        } else if (!(nextCell instanceof HalfCircle)) {
            // Nếu ô tiếp theo có sỏi → nhặt và rải tiếp ( i+1 có sỏi và k phải là ô quan)
            pickUpGemFrom(nextCell);
            spreadGem(nextCell, handDirection, board);
        }
        else if(nextCell instanceof HalfCircle) {
        	// mất lượt chơi nếu ô i+1 là ô quan
        	this.inTurn=false;
        	return;
        }
        
    }
   public void QuanNon(Cell cell) {
	   if (cell instanceof HalfCircle) {
		   // số dân ở ô quan <5 thì sẽ vào trh quan non và đổi lượt chơi 
           int k=cell.calculateScore();
           if(k<5) {
        	   this.inTurn=false;
           }
   }
   }

// Kiểm tra và mượn sỏi khi cần thiết
   public void borrowGemsIfNeeded(GameBoard board) {
	    boolean allEmpty = true; // Giả định tất cả ô trống ban đầu

	    // Xác định các vị trí cần kiểm tra
	    int[] positions1 = new int[]{1, 2, 3, 4, 5};
	    int[] positions2 = new int[]{6, 7, 8, 9, 10};

	    List<Cell> cells = List.of(board.getCells()); // Giả định GameBoard có danh sách các ô

	    // Kiểm tra các ô trong hàng trên hoặc dưới
	    if (this.isUpperRow()) {
	        allEmpty = areAllCellsEmpty(cells, positions1);
	    } else {
	        allEmpty = areAllCellsEmpty(cells, positions2);
	    }

	    // Nếu tất cả ô trống và điểm số >= 5, mượn 5 viên sỏi
	    if (allEmpty && this.score >= 5) {
	        System.out.println("Borrowing 5 gems to continue...");
	        this.score -= 5; // Trừ 5 điểm
	        this.numOfGemsBorrowed += 5;

	        // Thêm 5 viên sỏi nhỏ vào ô vuông đầu tiên phù hợp
	        addGemsToFirstSquare(cells, positions1, 5);
	    }
	}

	// Kiểm tra xem tất cả các ô được chỉ định có trống không
	private boolean areAllCellsEmpty(List<Cell> cells, int[] positions) {
	    for (int pos : positions) {
	        for (Cell cell : cells) {
	            if (cell.getPosition() == pos && !cell.isEmpty()) {
	                return false; // Có ít nhất một ô không trống
	            }
	        }
	    }
	    return true; // Tất cả ô đều trống
	}

	// Thêm số lượng sỏi nhỏ vào ô vuông đầu tiên phù hợp
	private void addGemsToFirstSquare(List<Cell> cells, int[] positions, int numOfGems) {
	    for (int pos : positions) {
	        for (Cell cell : cells) {
	            if (cell.getPosition() == pos && cell instanceof Square) {
	                for (int i = 0; i < numOfGems; i++) {
	                    cell.addGem(new SmallGem(cell));
	                }
	                return; // Thêm xong thì thoát
	            }
	        }
	    }
	}

    @Override
    public String toString() {
        return "Player{" +
                "playerID=" + playerID +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", isUpperRow=" + isUpperRow +
                ", numOfGemsInHand=" + numOfGemsInHand +
                '}';
    }
}
