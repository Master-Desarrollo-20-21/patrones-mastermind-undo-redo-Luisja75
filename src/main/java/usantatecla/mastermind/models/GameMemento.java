package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

class GameMemento {

  private List<ProposedCombination> proposedCombinations;

  public GameMemento(List<ProposedCombination> proposedCombinations) {
	  this.proposedCombinations = new ArrayList<ProposedCombination>();
	  for (ProposedCombination proposedCombination : proposedCombinations) {
		  this.proposedCombinations.add(proposedCombination.copy());  
	  }
  }
  
  public List<ProposedCombination> getProposedCombinations() {
	  return this.proposedCombinations;
  }
  
  public int getAttemps() {
	  return this.proposedCombinations.size();
  }

  public List<Result> getResults(SecretCombination secretCombination) {
	  List<Result> results = new ArrayList<Result>(); 	  
	  for (ProposedCombination proposedCombination : this.proposedCombinations) {
		  results.add(secretCombination.getResult(proposedCombination));
	  }	  
	  return results;
  }
}
