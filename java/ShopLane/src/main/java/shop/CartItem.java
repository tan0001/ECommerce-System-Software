package shop;

public class CartItem {
	private int id;
	private String product_name;
	private String description;
	private int price;
	private String image;
	private int quantity;
	private int total;

	public CartItem(int id, String name, String description, int price, String image, int quantity) {
		this.id = id;
		this.product_name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.total = (price * quantity);
	}

	public int getId() {
		return id;
	}

	public String getProductName() {
		return product_name;
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

	public int getQuantity() {
		return quantity;
	}

	public int getTotal() {
		return total;
	}
}