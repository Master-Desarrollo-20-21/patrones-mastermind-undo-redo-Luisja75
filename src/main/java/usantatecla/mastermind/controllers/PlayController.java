package usantatecla.mastermind.controllers;

import java.util.List;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

public class PlayController extends Controller implements AcceptorController {

	private ProposalController proposalController;
	private RedoController redoController;
	private UndoController undoController;
	
	public PlayController(Game game, State state) {
		super(game, state);
		proposalController = new ProposalController(game, state);
		redoController = new RedoController(game, state);
		undoController = new UndoController(game, state);
	}


	public boolean isWinner() {
		return this.proposalController.isWinner();
	}

	public boolean isLooser() {
		return this.proposalController.isLooser();
	}
	
	public int getAttempts() {
		return this.proposalController.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.proposalController.getColors(position);
	}

	public int getBlacks(int position) {
		return this.proposalController.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.proposalController.getWhites(position);
	}


	public void undo() {
		// TODO Auto-generated method stub
		
	}


	public boolean undoable() {
		// TODO Auto-generated method stub
		return false;
	}


	public void redo() {
		// TODO Auto-generated method stub
		
	}

	public boolean redoable() {
		// TODO Auto-generated method stub
		return true;
	}


	public Error addProposedCombination(List<Color> colors) {
		// TODO Auto-generated method stub
		return this.proposalController.addProposedCombination(colors);
	}
	
	
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}	
}
