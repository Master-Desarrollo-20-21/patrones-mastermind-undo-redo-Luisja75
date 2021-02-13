package usantatecla.mastermind.views.console;

import java.util.List;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;

class PlayCommand extends Command {
  protected Console console;
	
  PlayCommand(PlayController playController) {
	  super(MessageView.PROPOSED_COMBINATION.getMessage(), playController);
	  console = new Console();
  }

  @Override
  protected void execute() {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView(playController).read();
			error = playController.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		this.console.writeln();
		new AttemptsView(playController).writeln();
		new SecretCombinationView(playController).writeln();
		for (int i = 0; i < playController.getAttempts(); i++) {
			new ProposedCombinationView(playController).write(i);
			new ResultView(playController).writeln(i);
		}
		if (playController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (playController.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
  }

  @Override
  protected boolean isActive() {
    return true;
  }
}
