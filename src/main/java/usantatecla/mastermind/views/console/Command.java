package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;

abstract class Command extends usantatecla.utils.Command {

  protected PlayController playController;

  protected Command(String title, PlayController playController) {
    super(title);
    this.playController = playController;
  }
  
  protected void showResult() {
	for (int i = 0; i < playController.getAttempts(); i++) {
		new ProposedCombinationView(playController).write(i);
		new ResultView(playController).writeln(i);
	}  
  }
  
}
