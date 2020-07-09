package vn.edu.ntu.nguyendinhhoanglan.ontap_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.List;

public class SecondFragment extends Fragment {
    ListView lvNT;
    ArrayAdapter<String> adapter;
    List<String> arr;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        lvNT = v.findViewById(R.id.lvNT);
        this.arr = ((MainActivity)getActivity()).arr;
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arr);
        lvNT.setAdapter(adapter);

        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}