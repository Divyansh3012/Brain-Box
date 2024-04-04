package com.example.register.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.register.R;

import java.util.ArrayList;
public class BoookMarkFragment extends Fragment {

    EditText editText;
    Button addButton;
    ListView listView;
    ArrayList<String> todoList;
    ArrayAdapter<String> adapter;

    public BoookMarkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boook_mark, container, false);

        editText = view.findViewById(R.id.edit_text_todo);
        addButton = view.findViewById(R.id.button_add_todo);
        listView = view.findViewById(R.id.list_view_todo);

        todoList = new ArrayList<>();
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, todoList);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editText.getText().toString().trim();
                if (!newItem.isEmpty()) {
                    todoList.add(newItem);
                    adapter.notifyDataSetChanged();
                    editText.getText().clear();
                }
            }
        });

        return view;
    }
}