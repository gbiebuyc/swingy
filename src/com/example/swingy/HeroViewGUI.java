package com.example.swingy;

import java.util.ArrayList;

public class HeroViewGUI implements HeroView {
	public HeroModel selectHero(ArrayList<HeroModel> heroes) {
		for (HeroModel hero : heroes) {
			System.out.println(hero.name + ", " + hero.level + ", " + hero.xp);
		}
		return null;
	}
	

}
