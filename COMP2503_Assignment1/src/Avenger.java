public class Avenger implements Comparable<Avenger>{
	

	private String heroName;
	private String heroAlias;
	private String performer;
	
	private int nameFreq;
	private int aliasFreq;
	private int performerFreq;
	
	public Avenger() {
		nameFreq++; // change to int=0?
		aliasFreq++; // change to int=0?
		performerFreq++; //change to into=0?
		heroAlias = "";
		heroName = "";
		performer = "";
		
	}
	
	@Override
	public int compareTo(Avenger o) {
		return 0;
	}

	public String getHeroAlias() {
		return heroAlias;
	}

	public void setHeroAlias(String heroAlias) {
		this.heroAlias = heroAlias;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getPerformer() {
		return performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	public int getNameFreq() {
		return nameFreq;
	}

	public void setNameFreq(int nameFreq) {
		this.nameFreq = nameFreq;
	}

	public int getAliasFreq() {
		return aliasFreq;
	}

	public void setAliasFreq(int aliasFreq) {
		this.aliasFreq = aliasFreq;
	}

	public int getPerformerFreq() {
		return performerFreq;
	}

	public void setPerformerFreq(int performerFreq) {
		this.performerFreq = performerFreq;
	}
	
	
}

