
public class Avenger implements Comparable<Avenger>{
	

	private String heroName;
	private String heroAlias;
	private String performer;
	
	private int nameFreq;
	private int aliasFreq;
	private int performerFreq;
	
	public Avenger(String alias, String heroName,  String performer) {
		this.heroName = heroName;
		this.heroAlias = alias;
		this.performer = performer;
		nameFreq = 0;
		aliasFreq = 0;
		performerFreq = 0;
	}
	
	@Override
	// compare frequency of avenger mentions from most frequent to least, then by performer last name ascending in the case of tie
	public int compareTo(Avenger a) {
		int result = 0;
		int freq1 = this.getAliasFreq() + this.getNameFreq() + this.getPerformerFreq();
		int freq2 = a.getAliasFreq() + a.getNameFreq() + a.getPerformerFreq();
		
		if (freq1 > freq2) {
			result = -1;
		}else if (freq1 < freq2) {
			result = 1;
		}else {
			result = this.getPerformer().compareTo(a.getPerformer());
		}
		return result;
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
	
	public void setNameFreq() {
		this.nameFreq++;
	}
	
	public int getAliasFreq() {
		return aliasFreq; 
	}
	
	public void setAliasFreq() {
		this.aliasFreq++;
	}
	
	public int getPerformerFreq() {
		return performerFreq;
	}
	
	public void setPerformerFreq() {
		this.performerFreq++;
	}

	public String toString() { return heroAlias + " aka " + heroName + " performed by " + 
								performer + " mentioned " + " (n: " + nameFreq + " + a: " + 
								aliasFreq + " + p: " + performerFreq + ") " + "time(s)\n"; 
	
	}
	
	public boolean equals(Avenger a) {
		boolean flag = false;
		
		if(this.getHeroAlias().equals(a.getHeroAlias())) {
			flag = true;
		}
		
		return flag;
	}
	

}

