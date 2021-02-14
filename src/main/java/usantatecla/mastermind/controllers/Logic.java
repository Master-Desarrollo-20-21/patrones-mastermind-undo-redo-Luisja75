package usantatecla.mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;

public class Logic {
	
	private Session session;
	private Map<StateValue, AcceptorController> controllers;
		
	public Logic() {
		this.session = new Session();
		
		this.controllers = new HashMap<StateValue, AcceptorController>();
		this.controllers.put(StateValue.INITIAL, new StartController(this.session));
		this.controllers.put(StateValue.IN_GAME, new PlayController(this.session));
		this.controllers.put(StateValue.FINAL, new ResumeController(this.session));
		this.controllers.put(StateValue.EXIT, null);
	}
	
	public AcceptorController getController() {
		return this.controllers.get(this.session.getValueState());
	}
	
}
