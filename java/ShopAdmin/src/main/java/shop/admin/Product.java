package shop.admin;

public class Product {
    private int id;
    private String name;
    private String description;
    private int price;
    private int item_id;
    private String image_url;

    public Product(int id, String name, String description, int price, int item_id, String url) {
        this.id = id;
    	this.name = name;
        this.description = description;
        this.price = price;
        this.item_id = item_id;
        this.image_url = url;
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
    
    public int getItem() {
    	return item_id;
    }
    
    public String getImage() {
    	return image_url;
    }
}

