import java.util.Comparator;

public class Performer implements Comparator<Avenger> {

	@Override
	/**
	 * Overriden compare method that sorts the avengers by descending frequency, ascending order of name length if frequency is tied,
	 * then ascending alphabetical order of alias if another tie.
	 */
	public int compare(Avenger a1, Avenger a2) {
		
		int result = 0;
		
		if (a1.getPerformerFreq() > a2.getPerformerFreq()) {
			result = -1;
		}else if (a1.getPerformerFreq() < a1.getPerformerFreq()) {
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
