package shop.admin;

public class User {
    private int id;
    private String email;
    private String first;
    private String last;
    private String addr;
    private String image;

    public User(int id, String email, String first, String last, String addr, String url) {
        this.id = id;
    	this.email = email;
        this.first = first;
        this.last = last;
        this.addr = addr;
        this.image = url;
    }

    public int getId() {
        return id;
    }
    
    public String getEmail() {
    	return email;
    }

    public String getFirst() {
        return first;
    }
    
    public String getLast() {
        return last;
    }

    public String getAddress() {
        return addr;
    }
       
    public String getImage() {
    	return image;
    }
}

