package davray.fernandez.tp1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("/api/?results=5")
    Call<UserList> getJSON();
}