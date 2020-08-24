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
