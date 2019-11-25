package davray.fernandez.tp1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.TreeMap;

public class User {
    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("name")
    @Expose
    private TreeMap name;

    @SerializedName("login")
    @Expose
    private TreeMap login;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("dob")
    @Expose
    private TreeMap dob;

    @SerializedName("picture")
    @Expose
    private TreeMap picture;

    public User(String email, TreeMap name, TreeMap login, TreeMap dob, TreeMap picture) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.dob = dob;
        this.picture = picture;
    }

    public Object getName() {
        return name;
    }

    public void setName(TreeMap name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getLogin() {
        return login;
    }

    public void setLogin(TreeMap login) {
        this.login = login;
    }

    public String getUsername() {
        return login.get("username").toString();
    }

    public String getThumbnail(){
        return picture.get("thumbnail").toString();
    }

    public Object getDob() {
        return dob;
    }

    public void setDob(TreeMap dob) {
        this.dob = dob;
    }

    public Object getPicture() {
        return picture;
    }

    public void setPicture(TreeMap picture) {
        this.picture = picture;
    }
}

