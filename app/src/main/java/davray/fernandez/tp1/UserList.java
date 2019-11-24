package davray.fernandez.tp1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserList {
    @SerializedName("results")
    @Expose
    private List<User> listusers;

    public List<User> getListUsers() {
        return listusers;
    }
}
