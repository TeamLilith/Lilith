package main;

public class Main {

	public static void main(String[] args) {
		
		CompositeCommand p = new CompositeCommand();
		p.list.add(new MoveForwardCommand());
		p.execute();
		
	}
}

