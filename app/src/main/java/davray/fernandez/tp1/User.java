package davray.fernandez.tp1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    //@SerializedName("name")
    //private String name;
    @SerializedName("email")
    @Expose
    private String email;

    public User(String email) {
        //this.name = name;
        this.email = email;
    }

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

