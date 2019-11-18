package davray.fernandez.tp1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("name")
    @Expose
    private Object name;

    @SerializedName("login")
    @Expose
    private Object login;

    @SerializedName("dob")
    @Expose
    private Object dob;

    @SerializedName("picture")
    @Expose
    private Object picture;

    public User(String email, Object name, Object login, Object dob, Object picture) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.dob = dob;
        this.picture = picture;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
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

    public void setLogin(Object login) {
        this.login = login;
    }

    public Object getDob() {
        return dob;
    }

    public void setDob(Object dob) {
        this.dob = dob;
    }

    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
    }
}

