package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;

class RedoCommand extends Command {

  RedoCommand(PlayController playController) {
    super(MessageView.REDO_COMMAND.getMessage(), playController);
  }

  @Override
  protected void execute() {
	  this.playController.redo();
	  this.showResult();
  }

  @Override
  protected boolean isActive() {
	  return this.playController.isRedoable();
  }

}
