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
    private Random r = new Random();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        data = getArguments().getParcelableArrayList("");

        View rootView = inflater.inflate(R.layout.fragment_experiment, container, false);
        listv = (ListView)rootView.findViewById(R.id.info_lv);
        CreateListView();

        experimentButton = (Button)rootView.findViewById(R.id.experiment_btn);
        experimentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int userLevel = user.getLevel();
                int collidersBuilt = user.getCollidersBuilt();
                int energy = user.getEnergy();

                List<Particle> particles = user.getCollectedParticles();
                List<String> particleNames = user.collectedParticlesNames();
                // disable button if any of first three if's are false
                if (userLevel == collidersBuilt)
                {
                    int colliderEnergy = colliders.get(userLevel).getMaxEnergy();
                    if (energy >= colliderEnergy)
                    {
                        if (Collections.frequency(particleNames, "Electron") >= 2) //fix particle for collider
                        {
                            user.setEnergy(user.getEnergy() - colliderEnergy);
                            //remove 2 particles from user list
                            double randNum = r.nextDouble();
                            if (randNum <= 0.5)
                            {
                                user.setLevel(user.getLevel() + 1);
                                // give level particle
                                // success pop up
                            }
                            else
                            {
                                //give some other particle
                            }
                        } else {
                            System.out.println("No particles");
                        }
                    } else {
                        System.out.println("No energy");
                    }
                }
                else {
                    System.out.println("No collider");
                }
            }
        });

        return rootView;
    }

    private void CreateListView() {
        //Create an adapter for the listView and add the ArrayList to the adapter.
        listvAdapter = new ExperimentItemAdapter(getActivity().getApplicationContext(), R.layout.experiment_item, data);
        listv.setAdapter(listvAdapter);
    }
}