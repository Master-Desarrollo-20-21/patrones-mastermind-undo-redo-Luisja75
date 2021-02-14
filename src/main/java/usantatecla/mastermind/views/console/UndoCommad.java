package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;

class UndoCommand extends Command {

  UndoCommand(PlayController playController) {
    super(MessageView.UNDO_COMMAND.getMessage(), playController);
  }

  protected void execute() {
	  this.playController.undo();
	  this.showResult();
  }

  protected boolean isActive() {
	  return this.playController.isUndoable();
  }

}
