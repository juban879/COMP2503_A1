import java.util.Comparator;

public class Performer implements Comparator<Avenger> {

	@Override
	/*
	 * This method orders avenger from most frequently mentioned performers from most to least, then 
	 * ascending order or hero's name length if ties, then ascending alphabetical order of alias if
	 * another tie.
	 */
	public int compare(Avenger a1, Avenger a2) {
		
		int result = 0;
		int performer1 = a1.getPerformerFreq();
		int performer2 = a2.getPerformerFreq();
		
		if (performer1 > performer2) {
			result = -1;
		}else if (performer1 < performer2) {
			result = 1;
		}else {
			result = a1.getHeroName().length() - a2.getHeroName().length();
			if (result == 0) {
				result = a1.getHeroAlias().compareTo(a2.getHeroAlias());
			}
		}
		return result;
	}

}
