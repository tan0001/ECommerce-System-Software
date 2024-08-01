package shop;

public class Item {
	private int id;
	private String name;
	private String description;
	private String image;
	private int category;

	public Item(int id, String name, String description, String image, int category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public int getCategory() {
		return category;
	}
}
