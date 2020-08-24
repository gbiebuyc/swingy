package com.example.swingy;

import java.util.ArrayList;
import java.util.Scanner;

public class HeroViewConsole implements HeroView {
	public HeroModel selectHero(ArrayList<HeroModel> heroes) {
		System.out.println("Pick a hero:");
		System.out.println("0 - New");
		for (int i=0; i<heroes.size(); i++) {
			HeroModel h = heroes.get(i);
			System.out.printf("%d - %s, %s, LVL %d, %d XP, %d Attack, %d Defense, %d HP\n",
					i+1, h.name, h.heroClass, h.level, h.xp, h.getAttackPoints(),
					h.getDefensePoints(), h.getHitPoints());
		}
		System.out.println("q - Quit");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("Your answer: ");
			String[] lineSplited = scan.nextLine().split("\\s+");
			if (lineSplited.length != 1) {
				System.out.println("Bad input");
				continue;
			}
			if (lineSplited[0].equalsIgnoreCase("q")) {
				System.out.println("Bye");
				System.exit(0);
			}
			try {
				int n = Integer.parseInt(lineSplited[0]);
				break;
			} catch (Exception e) {
				System.out.println("Bad input");
				continue;
			}
		}
		return null;
	}

}
