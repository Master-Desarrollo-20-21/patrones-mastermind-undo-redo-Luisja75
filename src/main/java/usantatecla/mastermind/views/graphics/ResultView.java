package usantatecla.mastermind.views.graphics;

import javax.swing.JLabel;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;

@SuppressWarnings("serial")
class ResultView extends JLabel {
	
	private PlayController playController;

	ResultView(PlayController playController) {
		this.playController = playController;
		this.setText(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.playController.getBlacks(this.playController.getAttempts()-1))
				.replaceFirst("#whites", "" + this.playController.getWhites(this.playController.getAttempts()-1)));
	}
	
}
