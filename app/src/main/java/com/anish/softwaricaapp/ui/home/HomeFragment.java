package com.anish.softwaricaapp.ui.home;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.anish.softwaricaapp.MainActivity;
import com.anish.softwaricaapp.R;
import com.anish.softwaricaapp.StudentAdapter;
import com.anish.softwaricaapp.Students;
import com.anish.softwaricaapp.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        recyclerView=root.findViewById(R.id.recyclerview);

        List<List>lists=new ArrayList<>();

        if(MainActivity.list.isEmpty()){
            MainActivity.list.add(new Students("Salman Khan","Mumbai","male",50));
            MainActivity.list.add(new Students("Salman Khan","Mumbai","male",50));
            StudentAdapter studentAdapter=new StudentAdapter(getContext(),MainActivity.list);
            recyclerView.setAdapter(studentAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        }
        else {

            StudentAdapter listActivity=new StudentAdapter(getContext(), MainActivity.list);
            recyclerView.setAdapter(listActivity);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        return root;
    }
}