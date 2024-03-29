package connect4.view.multiplayer;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JButton;

import connect4.controller.GamePlay;
import connect4.enums.GamePlayers;
import connect4.enums.GameProperties;
import connect4.view.gameplay.TablePanel;
import connect4.view.menu.MenuContentPanel;

/**
 * Represents the host game panel with which player hosts game for multi player.
 * 
 * @author Stanislav Petrov
 * 
 */
public class HostGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Stores configuration information from the host game panel.
	 */
	private GamePlay gamePlay;
	private JLabel gameNameLbl = null;
	private JTextField gameNameTxt = null;
	private JLabel jLabel = null;
	private JComboBox playerComboBox = null;

	/**
	 * General purpose constructor.
	 * 
	 * @param gamePlay
	 *            Game play reference to be set.
	 */
	public HostGamePanel(GamePlay gamePlay) {
		super();
		this.gamePlay = gamePlay;
		initialize();
	}

	/**
	 * Intializes all components.
	 */
	private void initialize() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(20);
		jLabel = new JLabel();
		jLabel.setText("Choose player: ");
		jLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabel.setPreferredSize(new Dimension(150, 30));
		gameNameLbl = new JLabel();
		gameNameLbl.setText("Enter game name:  ");
		gameNameLbl.setPreferredSize(new Dimension(150, 30));
		gameNameLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		this.setLayout(flowLayout);
		this.setSize(350, 500);
		this.setPreferredSize(new Dimension(350, 500));
		this.add(gameNameLbl, null);
		this.add(getGameNameTxt(), null);
		this.add(jLabel, null);
		this.add(getPlayersComboBox(), null);
	}

	/**
	 * This method initializes gameNameTxt
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getGameNameTxt() {
		if (gameNameTxt == null) {
			gameNameTxt = new JTextField();
			gameNameTxt.setText("MultiPlayer1");
			gameNameTxt.setPreferredSize(new Dimension(150, 30));
		}
		return gameNameTxt;
	}

	/**
	 * This method initializes playersComboBox
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getPlayersComboBox() {
		if (playerComboBox == null) {
			playerComboBox = new JComboBox(GameProperties.PLAYERS);
			playerComboBox.setPreferredSize(new Dimension(150, 30));
		}
		return playerComboBox;
	}

	/**
	 * Gets selected index from the players combo box.
	 * 
	 * @return The selected index from the players' combo box.
	 */
	public int getPlayerComboBoxSelectedIndex() {
		return this.playerComboBox.getSelectedIndex();
	}

} // @jve:decl-index=0:visual-constraint="7,46"
