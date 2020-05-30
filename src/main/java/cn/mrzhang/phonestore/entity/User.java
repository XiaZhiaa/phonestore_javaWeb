package cn.mrzhang.phonestore.entity;

public class User {
    private Integer uid;
    private String username;
    private String password;
    private String telephone;
    private String email;
    private String address;

    private String code; //激活码
    private boolean actived; //是否激活

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                ", actived=" + actived +
                '}';
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isActived() {
        return actived;
    }

    public User(Integer uid, String username, String password, String telephone, String email, String address, String code, boolean actived) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.code = code;
        this.actived = actived;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }
}
