package main;

import java.util.ArrayList;
import java.util.List;

public class CompositeCommand implements CommandInterface {

	public List<CommandInterface> list;

	public CompositeCommand() {
		list = new ArrayList<>();
		//list.add(new MoveForwardCommand)
		
	}

	public void execute() {
		for(CommandInterface ci : list) {
			ci.execute();
		}
	}
}
