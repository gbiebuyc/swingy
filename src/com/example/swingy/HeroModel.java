package com.example.swingy;

@SuppressWarnings("serial")
public class HeroModel implements java.io.Serializable {
	public String name;
	public int type = 0;
	public static String[] types = {
			"Human",
			"Dwarf",
			"Night Elf",
			"Gnome",
			"Draenei",
			"Worgen",
			"Pandaren"};
	public int level = 0;
	public int xp = 0;
	public int weaponStat = 0;
	public int armorStat = 0;
	public int helmStat = 0;
	
	public void addXP(int xp) {
		int prevLvl = Math.max(this.level-1, 0);
		int nextLvlRequiredXP = this.level*1000 + (prevLvl*prevLvl) * 450;
		this.xp += xp;
		if (this.xp >= nextLvlRequiredXP)
			this.level++;
	}

}
