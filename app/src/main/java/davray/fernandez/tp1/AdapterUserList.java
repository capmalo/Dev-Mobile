package davray.fernandez.tp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterUserList extends RecyclerView.Adapter<AdapterUserList.ViewHolder>{

    private ArrayList<User> userlist;

    public AdapterUserList(ArrayList<User> userlist) {
        this.userlist = userlist;
    }

    @Override
    public AdapterUserList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_userlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterUserList.ViewHolder holder, int position) {
        holder.username_list.setText(userlist.get(position).getEmail());
        holder.email_list.setText(userlist.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView username_list;
        private TextView email_list;

        public ViewHolder(View itemView) {
            super(itemView);

            username_list = (TextView)itemView.findViewById(R.id.username_list);
            email_list = (TextView)itemView.findViewById(R.id.email_list);

        }
    }
}
