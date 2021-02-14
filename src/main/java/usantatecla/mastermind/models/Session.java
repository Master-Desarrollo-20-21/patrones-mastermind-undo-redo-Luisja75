package usantatecla.mastermind.models;

import java.util.List;

import usantatecla.mastermind.types.Color;

public class Session {

	private Game game;
	private State state;
	private GameRegistry registry;
	
	public Session() {
		this.game = new Game();
		this.state = new State();
		this.registry = new GameRegistry(game);
	}
	
	public StateValue getValueState() {
	    return this.state.getValueState();
	}
	
	public void next() {
	    this.state.next();
	}

	public void reset() {
		this.state.reset();
		this.game.clear();
		this.registry.reset();
	}

	public void addProposedCombination(List<Color> colors) {
		this.game.addProposedCombination(colors);
		this.registry.register();
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}
	
	public boolean isWinner() {
		return this.game.isWinner();
	}

	public int getAttempts() {
		return this.game.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.game.getColors(position);
	}

	public int getBlacks(int position) {
		return this.game.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.game.getWhites(position);
	}

	public int getWidth() {
		return game.getWidth();
	}
	
	public void undo() {
	    this.registry.undo();
	}

	public boolean isUndoable() {
	    return this.registry.isUndoable();
	}

	public void redo() {
	    this.registry.redo();
	}

	public boolean isRedoable() {
	    return this.registry.isRedoable();
	}
}
