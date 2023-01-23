package depth.java.constants;

public enum BookGenre {
	ART("Art"),
	BIOGRAPHY("Biography"),
	CHILDREN("Children"),
	FICTION("Fiction"),
	HISTORY("History"),
	MYSTERY("Mystery"),
	PHILOSOPHY("Philosophy"),
	RELIGION("Religion"),
	ROMANCE("Romance"),
	SELF_HELP("Self help"),
	TECHNICAL("Technical"),
	CLASSICS("Classics"),
	DOCUMENTARIES("Documentaries");

	private BookGenre(String name) {
		this.name = name;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}
}
