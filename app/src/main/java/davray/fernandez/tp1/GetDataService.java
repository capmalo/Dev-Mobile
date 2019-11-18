package davray.fernandez.tp1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("api/?results=10&seed=ouvmob")
    Call<UserList> getAllusers();
}
