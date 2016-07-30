package com.lanesdev.particlego.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.lanesdev.particlego.R;
import com.lanesdev.particlego.model.Particle;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Light on 11/03/16.
 */

public class ExperimentFragment extends Fragment {

    /** Called when the activity is first created. */
    private ListView listv;
    private Button experimentButton;
    private ExperimentItemAdapter listvAdapter;
    private List<Particle> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        data = getArguments().getParcelableArrayList("USER_ITEMS");

        View rootView = inflater.inflate(R.layout.fragment_experiment, container, false);
        listv = (ListView)rootView.findViewById(R.id.info_lv);
        CreateListView();

        experimentButton = (Button)rootView.findViewById(R.id.experiment_btn);
        experimentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        return rootView;
    }

    private void CreateListView() {
        //Create an adapter for the listView and add the ArrayList to the adapter.
        listvAdapter = new ExperimentItemAdapter(getActivity().getApplicationContext(), R.layout.experiment_item, data);
        listv.setAdapter(listvAdapter);
    }

    public void refresh(Particle particle) {
        if(particle != null) {
            listvAdapter.notifyDataSetChanged();
        }
    }
}