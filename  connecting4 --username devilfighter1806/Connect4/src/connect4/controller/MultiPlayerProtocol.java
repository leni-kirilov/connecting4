package connect4.controller;

import java.io.Serializable;

/**
 * Represents the protocol for communication between client and server.
 * 
 * @author Stanislav Petrov
 * 
 */
public class MultiPlayerProtocol implements Serializable {

	/**
	 * Stores the current player.
	 */
	private char player;
	/**
	 * Stores the row number of the board.
	 */
	private int row;
	/**
	 * Stores the column number of the board.
	 */
	private int col;
	/**
	 * Stores the position of player when he drops a men on the board.
	 */
	private int position;
	/**
	 * Stores row/column number from which player moves a man.
	 */
	private int rowColNum;
	
	private boolean isPlayerWin;

	public MultiPlayerProtocol(char player, int row, int col) {
		this.player = player;
		this.row = row;
		this.col = col;
	}

	public char getPlayer() {
		return player;
	}

	public void setPlayer(char player) {
		this.player = player;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getRowColNum() {
		return rowColNum;
	}

	public void setRowColNum(int rowColNum) {
		this.rowColNum = rowColNum;
	}

	public String toString(){
		return player + " " +  row + " " + col;
	}
	
	public void setPlayerWin(boolean win){
		this.isPlayerWin = win;
	}
	
	public boolean isPlayerWin(){
		return this.isPlayerWin;
	}
}