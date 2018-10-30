package hr.josip.questions;

import java.util.*;

public class Questions {

	int guess;

	int j = 0;
	String questions[] = new String[19];
	String question;
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public Questions() {

		questions[1] = "Što je Terej uèinio sestri svoje žene?$A. Odrubio glavu$B. Protjerao iz dvorca$C. Odrezao jezik$D. Pomogao u nevolji$3";
		questions[2] = "Koliko djeèaka i djevojaka su žrtvovani minotauru?$A. Deset$B. Dvanaest$C. Sedam$D. Èetrnaest$4";
		questions[3] = "Zbog èega je Dedal protjeran iz svoje domovine?$A. Ubojstva neæaka$B. Kraðe$C. Izdaje kralja$D. Zbog svojih izuma$1";
		questions[4] = "Po èemu su Mirmidonci dobili ime?$A. Mravima$B. Drveæu$C. Brdu$D. Vladaru$1";
		questions[5] = "Tko je Orfeju darovao liru?$A. Hera$B. Zeus$C. Ares$D. Apolon$4";
		questions[6] = "Tko je bio Tezejev otac?$A. Egej$B. Pitej$C. Perifeg$D. Obelix $1";
		questions[7] = "Kako se zvala žena zbog koje je izbio Amazonski rat?$A. Lapita$B. Hipolita$C. Ksena$D. Mikadona$2";
		questions[8] = "Kako je Tezej umro?$A. Baèen je sa stijene$B. Otrovan je$C. Umro je od starosti$D. Proboden je nožem$1";
		questions[9] = "Što znaèi ime edip?$A. Veliki voða$B. Hrabri borac$C. Oteklih nogu$D. Velikog srca$3";
		question = questions[rng(1, 10)];

	}

	public int rng(int min, int max) {

		

		guess = (int) ((max - min) * Math.random() + min);

		if (list.contains(guess)) {
			rng(1, 10);
		}

		else {
			addToList(guess);
		}

		return guess;

	}

	public void addToList(int g) {

		list.add(g);

	}

}
