package org.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SuffleSongs {

	public static void main(String[] args) {

		String songs[] = {
				"Song1",
				"Song2",
				"Song3",
				"Song4",
				"Song5",
				"Song6",
				"Song7",
				"Song8",
				"Song9",
				"Song10",
				"Song11",
				"Song12",
				"Song13",
				"Song14",
				"Song15",
				"Song16",
				"Song17",
				"Song18",
				"Song19",
				"Song20"			
		};

		List<String> playList = new ArrayList<String>();
		playList.add("Song1");
		playList.add("Song2");
		playList.add("Song3");
		playList.add("Song4");
		playList.add("Song5");
		playList.add("Song6");
		playList.add("Song7");
		playList.add("Song8");
		playList.add("Song9");
		playList.add("Song10");
		playList.add("Song11");
		playList.add("Song12");
		playList.add("Song13");
		playList.add("Song14");
		playList.add("Song15");
		playList.add("Song16");
		playList.add("Song17");
		playList.add("Song18");
		playList.add("Song19");
		playList.add("Song20");
		playList.add("Song21");

		for (int i=0; i<songs.length; ++i) {
			Random rand = new Random();
			int temp = rand.nextInt(songs.length -i) + i;
			String t = songs[i];
			songs[i] = songs[temp];
			songs[temp] = t;

			for(int j = 0; j < songs.length; ++j) System.out.println(songs[j]);
			System.out.println("\n");
		}

	
		for (int i=0; i<playList.size(); ++i) {
			Random rand = new Random();
			int temp = rand.nextInt(playList.size() -i) + i;
			Collections.swap(playList, i, temp);

			for(int j = 0; j < playList.size(); ++j) System.out.println(playList.get(j));
			System.out.println("\n");
		}

	
	
	}

}

