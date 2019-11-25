package davray.fernandez.tp1.ui.dashboard;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import davray.fernandez.tp1.AdapterUserList;
import davray.fernandez.tp1.R;
import davray.fernandez.tp1.RequestInterface;
import davray.fernandez.tp1.RetrofitClientInstance;
import davray.fernandez.tp1.User;
import davray.fernandez.tp1.UserList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private RecyclerView recyclerView;
    private ArrayList<User> data;
    private AdapterUserList AdapterUserList;
    private ProgressDialog pdLoading;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        if(view != null) {
            recyclerView = view.findViewById(R.id.userList);
            initRecyclerViewLayout();
        }
    }

    private void initRecyclerViewLayout() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        pdLoading = new ProgressDialog(getContext());
        pdLoading.setMessage("\tLoading...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<UserList> call = request.getJSON();
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {

                UserList jsonResponse = response.body();
                data = new ArrayList<>(jsonResponse.getListUsers());
                AdapterUserList = new AdapterUserList(data);
                recyclerView.setAdapter(AdapterUserList);
                pdLoading.cancel();
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}