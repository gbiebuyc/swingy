package com.example.swingy;

public class Hero {
	public String name;
	public int level;
	public int xp;
	public int weaponStat;
	public int armorStat; 
	public int helmStat; 
	
	public void addXP(int xp) {
		int prevLvl = Math.max(this.level-1, 0);
		int nextLvlRequiredXP = this.level*1000 + (prevLvl*prevLvl) * 450;
		this.xp += xp;
		if (this.xp >= nextLvlRequiredXP)
			this.level++;
	}

}
