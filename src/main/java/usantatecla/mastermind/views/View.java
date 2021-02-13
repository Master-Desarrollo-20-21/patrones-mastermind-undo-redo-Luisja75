package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.mastermind.controllers.ControllersVisitor;

public abstract class View implements ControllersVisitor {
	
	public void interact(AcceptorController controller) {
		controller.accept(this);
	}

}
