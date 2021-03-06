package com.example.swingy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HeroController {
	
	private HeroView view;
	private final String saveFile = "save.dat";
	
	@SuppressWarnings("unchecked")
	HeroController(HeroView view) {
		System.out.printf("\033[31mHello\033[0m World\n");
		this.view = view;

		// Load hero list from file.
		ArrayList<HeroModel> heroes = null;
		try {
			FileInputStream fis = new FileInputStream(this.saveFile);
			try {
				ObjectInputStream ois = new ObjectInputStream(fis);
				heroes = (ArrayList<HeroModel>) ois.readObject();
				ois.close();
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Created " + this.saveFile);
			heroes = new ArrayList<HeroModel>();
		}
		
		HeroModel theHero = this.view.selectHero(heroes);
		
		int mapSize = (theHero.level-1)*5+10-(theHero.level%2);;
		int px=3, py=3;
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		for (int y=0; y<mapSize; y++) {
			for (int x=0; x<mapSize; x++) {
				if (x==px && y==py)
					continue;
				if (Math.random() < 0.2) {
					enemies.add(new Enemy(x, y));
				}
			}
		}
		
		while (px >= 0 && px < mapSize && py >= 0 && py < mapSize) {
			char[][] map = new char[mapSize][mapSize];
			map[py][px] = 'P';
			for (Enemy enemy : enemies) {
				map[enemy.y][enemy.x] = 'E'; 
			}
			switch (this.view.showMap(map)) {
				case "Up": py--; break;
				case "Down": py++; break;
				case "Left": px--; break;
				case "Right": px++; break;
			}
		}
		
		// Save hero list to file.
		try {
			FileOutputStream fos = new FileOutputStream(this.saveFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(heroes);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
