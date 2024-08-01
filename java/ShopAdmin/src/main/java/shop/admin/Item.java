package shop.admin;

public class Item {
    private int id;
    private String name;
    private String description;
    private int category_id;
    private String image_url;

    public Item(int id, String name, String description, int category_id, String url) {
        this.id = id;
    	this.name = name;
        this.description = description;
        this.category_id = category_id;
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
    
    public int getCategory() {
    	return category_id;
    }
    
    public String getImage() {
    	return image_url;
    }
}

