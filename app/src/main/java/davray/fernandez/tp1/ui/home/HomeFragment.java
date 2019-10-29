package davray.fernandez.tp1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import davray.fernandez.tp1.R;
import davray.fernandez.tp1.SaveNote;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public boolean isSavedNoteVisible = false;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textSavedNote = root.findViewById(R.id.textSavedNote);
        if(isSavedNoteVisible){
            textSavedNote.setVisibility(View.VISIBLE);
        }
        else {
            textSavedNote.setVisibility(View.INVISIBLE);
        }

        final TextView textHome = root.findViewById(R.id.textHome);
        final Button createNoteBtn = root.findViewById(R.id.creernotebtn);

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        createNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveNote fragment = new SaveNote();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                createNoteBtn.setVisibility(View.INVISIBLE);
                textHome.setVisibility(View.INVISIBLE);
                textSavedNote.setVisibility(View.INVISIBLE);
            }
        });
        /*public void onBackPressed() {
            NoteBtn.setVisibility(View.INVISIBLE);
            textHome.setVisibility(View.INVISIBLE);
        }*/
        return root;
    }
}