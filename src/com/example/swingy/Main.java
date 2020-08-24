package com.example.swingy;

public class Main {

	public static void main(String[] args) {
		String mode;
		try {
			mode = args[0];
		} catch (Exception e) {
			System.out.println("View mode not specified. Using console.");
			mode = "console";
		}
		HeroView heroView = null;
		switch (mode) {
			case "console":
				heroView = new HeroViewConsole();
				break;
			case "gui":
				heroView = new HeroViewGUI();
				break;
			default:
				System.err.println("Bad argument.");
				System.exit(0);
		}
		@SuppressWarnings("unused")
		HeroController heroController = new HeroController(heroView);
	}

}
