package shop.admin;

public class Category {
    private int id;
    private String name;
    private String description;
    private String image_url;

    public Category(int id, String name, String description, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
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
    
    public String getImage() {
    	return image_url;
    }
}

