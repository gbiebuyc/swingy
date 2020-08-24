package com.example.swingy;

import java.util.ArrayList;

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
		return null;
	}

}
