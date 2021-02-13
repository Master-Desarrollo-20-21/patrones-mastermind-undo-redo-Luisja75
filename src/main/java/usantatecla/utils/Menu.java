package usantatecla.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

  private static final String OPTION = "Option? [1-#size]: ";
  private List<Command> commandList;

  public Menu() {
    this.commandList = new ArrayList<Command>();
  }

  public void execute() {
    ArrayList<Command> commands = this.getActiveCommands();
    
    int option;
    Console console = new Console();
    boolean error;
    do {
      error = false;      
      this.writeTitles(console, commands);
      option = console.readInt(Menu.OPTION.replace("#size", "" + commands.size())) - 1;
      if (!new ClosedInterval(0, commands.size() - 1).includes(option)) {
        error = true;
      }
    } while (error);
    commands.get(option).execute();
  }

  private ArrayList<Command> getActiveCommands() {
	  ArrayList<Command> activeCommands = new ArrayList<Command>();
	  for (int i = 0; i < this.commandList.size(); i++) {
		  if (this.commandList.get(i).isActive()) {
			  activeCommands.add(this.commandList.get(i));
		  }
	  }
	  return activeCommands;
  }
  
  private void writeTitles(Console console, ArrayList<Command> commands) {
	  console.writeln();
      for (int i = 0; i < commands.size(); i++) {
          console.writeln((i + 1) + ") " + commands.get(i).getTitle());
      }
  }
  
  protected void addCommand(Command command) {
    this.commandList.add(command);
  }
}
