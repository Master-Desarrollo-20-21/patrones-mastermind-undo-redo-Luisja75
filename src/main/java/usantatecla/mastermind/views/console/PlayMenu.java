package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Menu;

public class PlayMenu extends Menu {

  PlayMenu(PlayController playController) {
	super(MessageView.CHOSSE_OPTION.getMessage());
    this.addCommand(new PlayCommand(playController));
    this.addCommand(new UndoCommand(playController));
    this.addCommand(new RedoCommand(playController));
  }

}
