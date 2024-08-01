package shop;

public class Product {
	private int id;
	private String name;
	private String description;
	private int price;
	private String image;
	private int item;

	public Product(int id, String name, String description, int price, String image, int item) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.item = item;
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
	
	public int getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public int getItem() {
		return item;
	}
}
