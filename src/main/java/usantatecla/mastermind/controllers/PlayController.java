package usantatecla.mastermind.controllers;

import java.util.List;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;


public class PlayController extends Controller implements AcceptorController {

	private ProposalController proposalController;
	private RedoController redoController;
	private UndoController undoController;
	
	public PlayController(Session session) {
		super(session);
		proposalController = new ProposalController(session);
		redoController = new RedoController(session);
		undoController = new UndoController(session);
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

	public Error addProposedCombination(List<Color> colors) {
		return this.proposalController.addProposedCombination(colors);
	}
		
	public void undo() {
		undoController.undo();	
	}

	public boolean isUndoable() {
		return undoController.isUndoable();
	}

	public void redo() {
		redoController.redo();		
	}

	public boolean isRedoable() {
		return redoController.isRedoable();		
	}
	
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}	
}
