package com.lanesdev.particlego.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.lanesdev.particlego.Controller;
import com.lanesdev.particlego.R;
import com.lanesdev.particlego.model.Collider;
import com.lanesdev.particlego.model.Particle;
import com.lanesdev.particlego.model.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


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
    private User user;
    private HashMap<Integer, Collider> colliders;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        user = getArguments().getParcelable("USER");
        colliders = (HashMap<Integer, Collider>) getArguments().getSerializable("COLLIDERS");
        data = user.getCollectedParticles();


        View rootView = inflater.inflate(R.layout.fragment_experiment, container, false);
        listv = (ListView)rootView.findViewById(R.id.info_lv);
        CreateListView();

        experimentButton = (Button)rootView.findViewById(R.id.experiment_btn);
        experimentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int userLevel = user.getLevel();
                int collidersBuilt = user.getCollidersBuilt();
                int energy = user.getEnergy();

                List<String> particleNames = user.collectedParticlesNames();
                // disable button if any of first three if's are false
                //if (userLevel == collidersBuilt)
                //{
                // NEW CODE, logic ala Marcosaurus
                if(user.getLevel() == 0){
                    Toast.makeText(getContext(), "You need to collect an electron now", Toast.LENGTH_SHORT).show();
                }
                else if(user.getLevel() == 1){
                    Toast.makeText(getContext(), "You need to collect a proton now", Toast.LENGTH_SHORT).show();
                }
                else if(user.getLevel() == 2){
                    Toast.makeText(getContext(), "You need to collect a neutron now", Toast.LENGTH_SHORT).show();
                }
                else if(user.getLevel() == 3){
                    Toast.makeText(getContext(), "You need to collect a positron now", Toast.LENGTH_SHORT).show();
                }
                else if(user.getLevel() == 4){
                    Toast.makeText(getContext(), "You need to collect a muon now", Toast.LENGTH_SHORT).show();
                }
                else if(user.getLevel() == 5){
                    Toast.makeText(getContext(), "You need to collect a kaon now", Toast.LENGTH_SHORT).show();
                }
                // MARCOLOGIC ENDS HERE
                else if(user.getLevel() < colliders.size() && user.getLevel() > 5){
                    int colliderEnergy = colliders.get(userLevel).getMaxEnergy();
                    if (energy >= colliderEnergy)
                    {
                        if (Collections.frequency(particleNames, "Electron") >= 2) //fix particle for collider
                        {
                            user.setEnergy(user.getEnergy() - colliderEnergy);
                            //remove 2 particles from user list
                            user.removeParticleByName("Electron", 2);
                            refresh();
                            double randNum = r.nextDouble();
                            if (randNum <= 0.5)
                            {
                                user.setLevel(user.getLevel() + 1);
                                user.setCollidersBuilt(user.getCollidersBuilt() + 1);
                                user.collectParticle(new Particle(colliders.get(collidersBuilt).getParticleDiscovered()));
                                refresh();
                                ((Controller)getActivity()).updateStatus(user.getLevel());
                                Toast.makeText(getContext(), "Collided successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                //give some other particle
                                Toast.makeText(getContext(), "Collided unsuccessfully", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            System.out.println("No particles");
                        }
                    } else {
                        System.out.println("No energy");
                    }
                }
                //else {
                //    System.out.println("No collider");
                //}
            }
        });

        return rootView;
    }

    private void CreateListView() {
        //Create an adapter for the listView and add the ArrayList to the adapter.
        listvAdapter = new ExperimentItemAdapter(getActivity().getApplicationContext(), R.layout.experiment_item, data);
        listv.setAdapter(listvAdapter);
    }

    public void refresh() {
            listvAdapter.notifyDataSetChanged();
    }
}