package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.WithConsoleView;

class ProposalView extends WithConsoleView {

	public void interact(PlayController playController) {
		new PlayMenu(playController).execute();
	}
}
