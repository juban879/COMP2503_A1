public class Avenger implements Comparable<Avenger>{
	

	private String heroName;
	private String heroAlias;
	private String performer;
	
	private int nameFreq;
	private int aliasFreq;
	private int performerFreq;
	
	public Avenger() {
		heroName = "";
		heroAlias = "";
		performer = "";
		nameFreq = 0;
		aliasFreq = 0;
		performerFreq = 0;
	}
	
	@Override
	public int compareTo(Avenger o) {
		return 0;
	}

	public String getHeroName() { 
		return heroName; 
	}
	
	public void setHeroName(String heroName) { 
		this.heroName = heroName; 
	}

	public String getHeroAlias() { 
		return heroAlias; 	
	}
	
	public void setHeroAlias(String heroAlias) { 
		this.heroAlias = heroAlias; 
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

	public String toString() { return heroAlias + "aka" + heroName + "performed by" + 
								performer + "mentioned" + "(n:" + nameFreq + " + a: " + 
								aliasFreq + " + p: " + performerFreq + ")" + "time(s)"; }
	
	
	
}

