package cn.mrzhang.phonestore.entity;

public class Phone {
    private Integer pid;
    private String pName;
    private String pDescription;
    private double price;
    private Integer stock;  //库存

    private String photoPath;

    private String photoName;

    private Category category;

    public Phone() {
    }

    public Phone(Integer pid, String pName, String pDescription, double price, Integer stock, String photoPath, String photoName, Category category) {
        this.pid = pid;
        this.pName = pName;
        this.pDescription = pDescription;
        this.price = price;
        this.stock = stock;
        this.photoPath = photoPath;
        this.photoName = photoName;
        this.category = category;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
