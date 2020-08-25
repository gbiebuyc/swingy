package com.example.swingy;

import java.util.ArrayList;
import java.util.Scanner;

public class HeroViewConsole implements HeroView {
	public HeroModel selectHero(ArrayList<HeroModel> heroes) {
		System.out.println("Pick a hero:");
		for (int i=0; i<heroes.size(); i++) {
			HeroModel h = heroes.get(i);
			System.out.printf("%d - %s, %s, LVL %d, %d XP, %d Attack, %d Defense, %d HP\n",
					i, h.name, h.heroClass, h.level, h.xp, h.getAttackPoints(),
					h.getDefensePoints(), h.getHitPoints());
		}
		System.out.println("n - New");
		System.out.println("q - Quit");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int n = 0;
		while (true) {
			System.out.print("Your answer: ");
			String[] lineSplited = scan.nextLine().split("\\s+");
			if (lineSplited.length != 1)
				continue;
			String answer = lineSplited[0];
			if (answer.equalsIgnoreCase("q")) {
				System.out.println("Bye");
				System.exit(0);
			}
			if (answer.equalsIgnoreCase("n")) {
				HeroModel newHero = this.createNewHero();
				heroes.add(newHero);
				return newHero;
			}
			try {
				n = Integer.parseInt(answer);
				break;
			} catch (Exception e) {
				continue;
			}
		}
		return heroes.get(n);
	}
	
	public HeroModel createNewHero() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		HeroModel newHero = new HeroModel();
		System.out.println("You are creating a new hero.");
		for (int i=0; i<HeroModel.heroClasses.length; i++) {
			System.out.printf("%d - %s\n",  i, HeroModel.heroClasses[i]);
		}
		while (true) {
			System.out.print("Pick a class: ");
			String[] lineSplited = scan.nextLine().split("\\s+");
			if (lineSplited.length != 1)
				continue;
			try {
				int n = Integer.parseInt(lineSplited[0]);
				newHero.heroClass = HeroModel.heroClasses[n];
				break;
			} catch (Exception e) {
				continue;
			}
		}
		System.out.print("Hero Name: ");
		newHero.name = scan.nextLine();
		return newHero;
	}

	public String showMap(char[][] map) {
		for (int i=0; i<map.length+2; i++)
			System.out.print("#");
		System.out.print('\n');
		for (int i=0; i<map.length; i++) {
			System.out.print('#');
			for (int j=0; j<map.length; j++) {
				if (map[i][j] == 'P')
					System.out.print('P');
				else if (map[i][j] == 'E')
					System.out.print('E');
				else
					System.out.print(' ');
			}
			System.out.print("#\n");
		}
		for (int i=0; i<map.length+2; i++)
			System.out.print("#");
		System.out.print('\n');
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("Your move (WASD/ZQSD): ");
			String[] lineSplited = scan.nextLine().split("\\s+");
			if (lineSplited.length != 1)
				continue;
			switch(lineSplited[0].toUpperCase()) {
				case "W":
				case "Z":
					return "Up";
				case "A":
				case "Q":
					return "Left";
				case "S":
					return "Down";
				case "D":
					return "Right";
			}
		}
	}
}
