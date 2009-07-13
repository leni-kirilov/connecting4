package connect4.controller;

import java.util.Scanner;

import javax.security.auth.callback.TextOutputCallback;

/**
 * Controls game play.
 * 
 * @author Stanislav Petrov
 * 
 */
public class GamePlay {
	/**
	 * Stores game mode - single|multi player.
	 */
	private GameMode gameMode;
	/**
	 * Stores which is current player.
	 */
	private char currentPlayer;
	/**
	 * Stores connect4 solving algorithms.
	 */
	private Connect4Solver connect4;
	/**
	 * Reads from standard input.
	 */
	private Scanner stdin;

	public GamePlay(GameMode gameMode, int boardSize) {
		stdin = new Scanner(System.in);
		this.gameMode = gameMode;
		connect4 = new Connect4Solver(gameMode, boardSize);
	}

	/**
	 * Switches current player's turn in multiplayer mode.
	 * 
	 * @param currentPlayer
	 *            Current player which will be switched.
	 * @return Current player's turn.
	 */
	private char switchPlayer() {
		if (currentPlayer == Connect4Solver.BLACK) {
			currentPlayer = Connect4Solver.WHITE;
		} else {
			currentPlayer = Connect4Solver.BLACK;
		}
		return currentPlayer;
	}

	/**
	 * Configures new game.
	 * 
	 * @param boardSize
	 *            Board size to be set.
	 * @param gameMode
	 *            Game mode to be set.
	 */
	public void configureGame(int boardSize, GameMode gameMode) {
		// TODO To be implemented.
	}

	/**
	 * Game mode setter.
	 * 
	 * @param gameMode
	 *            Game mode to be set.
	 */
	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	/**
	 * User chooses which player to be and current player becomes oponent.
	 */
	public void choosePlayer() {
		System.out.println("Choose player (x-black, o - white):");
		this.currentPlayer = stdin.nextLine().charAt(0);
		connect4.setPlayer(currentPlayer);
	}

	/**
	 * Sets current player who will be the first one.
	 * 
	 * @param player
	 */
	public void setPlayer(char player) {
		this.currentPlayer = player;
	}

	/**
	 * Determines the game mode and loops the relevant game play.
	 */
	public void loopGame() {
		if (gameMode == GameMode.SINGLE_PLAYER) {
			playSinglePlayer();
		} else {
			playMultiPlayer();
		}
	}

	/**
	 * Controls the game play in single player mode.
	 */
	public void playSinglePlayer() {
		int position, num;
		boolean validMove = true;
		connect4.printBoard();
		if (currentPlayer == Connect4Solver.BLACK) {
			connect4.nextBotMove();
			connect4.printBoard();
		}
		while (true) {
			System.out.println("Current player is: " + currentPlayer);
			System.out.println("Position(1-Top, 2-Bottom, 3-Left, 4-Right:");
			position = stdin.nextInt();
			num = stdin.nextInt();
			if (position == -1 && num == -1)
				break;
			switch (position) {
			case 1:
				if (connect4.moveMan(currentPlayer, Direction.VERTICAL_UP, num) == false) {
					System.out.println("Invalid move!");
				}
				break;
			case 2:
				validMove = connect4.moveMan(currentPlayer, Direction.VERTICAL_DOWN,
						num);
				break;
			case 3:
				validMove = connect4
						.moveMan(currentPlayer, Direction.HORIZONTAL_LEFT, num);
				break;
			case 4:
				validMove = connect4.moveMan(currentPlayer, Direction.HORIZONTAL_RIGHT,
						num);
				break;
			}
			connect4.printBoard();
			System.out.println("Bot move..........");
			connect4.nextBotMove();
			connect4.printBoard();
			currentPlayer = switchPlayer();
			if (connect4.isPlayerWin(currentPlayer)) {
				System.out.println("WIN!!!");
				connect4.printWinPaths();
				break;
			}
			currentPlayer = switchPlayer();
			if (!validMove)
				System.out.println("Invalid move!");
			else if (connect4.isPlayerWin(currentPlayer)) {
				System.out.println("WIN!!!");
				connect4.printWinPaths();
				break;
			}
		}
	}

	/**
	 * Controls the game play in multiplayer mode.
	 */
	public void playMultiPlayer() {
		// TODO To be implemented.
	}

	/**
	 * Starts game loop.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// configure new game.
		GamePlay game = new GamePlay(GameMode.SINGLE_PLAYER, 7);
		// choose which player to be.
		game.choosePlayer();
		// game loop.
		game.loopGame();
	}

}