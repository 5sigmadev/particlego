package com.lanesdev.particlego.model;

import com.lanesdev.particlego.R;

/**
 * Created by ppanero on 31/07/16.
 */
public class Level {

    private int image;
    private String text;

    public Level(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public static Level getLevelContent(int level) {
        switch (level){
            case 1:
                return new Level(R.drawable.level_up_one, "ELECTRON (1897): J.J. Thomson discovered electron in the year 1897 by observing so called “cathode rays” which illuminated vacuum tubes when high voltage was applied. He managed to determine the electron’s charge to mass ratio and for the discovery of this elementary particle, he was awarded a nobel prize for physics in the year 1906. To get a new level, you now have to collect a PROTON!");
            case 2:
                return new Level(R.drawable.level_up_two, "PROTON (1911): After Ernest Rutherford’s discovery of the atomic nucleus in 1911, it has become clear that in order to maintain the electrical neutrality of atoms a positively charged particle has to be present in their nuclei. This particle was later on observed as another product of transmutation of nitrogen into oxygen. To get a new level, you now have to collect a NEUTRON!");
            case 3:
                return new Level(R.drawable.level_up_three, "NEUTRON (1930): Neutrons were first observed by bombarding a Beryllium target by alpha particles. In the year 1930, James Chadwick has shown that this neutral radiation cannot be explained as a photon radiation because it would need to have much higher energy than was produced in the bombardment thus neutron was discovered. To get a new level, you now have to collect a POSITRON!");
            case 4:
                return new Level(R.drawable.level_up_four, "POSITRON (1932): Carl D. Anderson in the year 1932 observed the direction of flight of charged particles in his cloud chamber using magnetic field. As it turned out, some of the “electrons” turned to other direction which means that they have an opposite charge. A first antiparticle - positron - was discovered. To get a new level, you now have to collect a MUON!");
            case 5:
                return new Level(R.drawable.level_up_five, "MUON (1936): Carl D. Anderson in 1936 discovered muon by observing cosmic ray radiation under magnetic field. This new particle curves less sharply than electron but more sharply than proton, thus get a name mesotron. During the 70s particle was renamed to more modern name - muon. Muon is the second particle with the longest life-time right after neutron. To get a new level, you now have to collect a KAON!");
            case 6:
                return new Level(R.drawable.level_up_six, "KAON (1947): G. D. Rochester and C. C. Butler published two cloud chamber photographs of cosmic ray events in 1947. One showing decay of unknown neutral particle and second decay of charged particle - neutral and charged Kaons. Their life-times were unexpectedly long thus lead to new particles property - strangeness. To get a new level, you now have to collide a PROTON!");
            case 7:
                return new Level(R.drawable.level_up_seven, "ANTIPROTON (1954): In 1954 a new accelerator, bevatron, has been put into operation. In 1955 total 38 negatively charged particle with same mass as proton were measured. Nowadays various experiments at CERN can store up to hundreds of antiparticles for minutes. To get a new level, you now have to collide a NEUTRON!");
            case 8:
                return new Level(R.drawable.level_up_eight, "NEUTRINO (1956): The first idea about existence of neutrino was proposed by physicist Wolfgang Pauli when trying to explain why is the energy not conserved in beta decays. As once said neutrino goes through material “like a bullet through a bank of fog”, which makes it difficult to measure. Pauli waged a bottle champagne to anyone who will be able to detect this new mysterious particle. The ones who eventually won the bottle were F. Reines and C. Cowen detecting the neutrinos coming from reaction inside nuclear reactor. To get a new level, you now have to collide an ELECTRON with POSITRON!");
            case 9:
                return new Level(R.drawable.level_up_nine, "QUARK (1969): Quarks were introduced in 1964 by M. Gell-Mann and G. Zweig as a buildings blocks of matter to distinguish between different types of particles. At first it was only a theoretical concept but their existence were later on proved by SLAC experiment in 1969. Nowadays there are 6 known quarks which differ by their masses - up, down, charm, strange, beauty (called also bottom) and top. Each quark carries an electrical charge and colour charge as well. To get a new level, you now have to collide an ELECTRON with POSITRON! ");
            case 10:
                return new Level(R.drawable.level_up_ten, "J/PSI (1974): In 1974 two groups independently proclaimed to discover new particle with peak around  3.0969 GeV/c2. The first was the Brookhaven National Laboratory and the other was Stanford Linear Accelerator Center. BNL  gave particle the name “J” and SLAC termed it psi hence the J/psi. New discovered particle was a meson consisting of charm and anticharm quarks. This particle is often used as a probe to quark-gluon plasma. To get a new level, you now have to collide an ELECTRON with POSITRON! ");
            case 11:
                return new Level(R.drawable.level_up_eleven, "GLUON (1979): Together with quarks gluons are building block of matter. They are “gluing” quarks to each other to compose a particle such as proton or neutron hence the name gluon. Gluons are representing the strong interaction which applies to particle with colour charge. They were observed for the first time with PLUTO detector detector at the electron-positron collider DORIS (DESY) in 1979. To get a new level, you now have to collide two PROTONS! ");
            case 12:
                return new Level(R.drawable.level_up_twelve, "W (1983):W is among the most heaviest particles. Its mass is approximately 80x more than proton. There are two types of W particles one with positive charge and one with negative. W is the carrier of the weak interaction . This means that it is participating in the beta decays which are responsible for one type of radioactivity. W was discovered by Carlo Rubbia and Simon van der Meer with the Super Proton Synchrotron at CERN, in January 1983. To get a new level, you now have to collide two PROTONS!");
            case 13:
                return new Level(R.drawable.level_up_thirteen, "Z (1983):Z is the second particle which mediates the weak interaction. The exchange of Z is called neutral currents interaction because only the momentum is transferred. Compared to W, Z does not have a charge and is also heavier ( ~ 91 GeV). Its discovered was few months later after W by the same team using the Superproton Synchrotron as well. To get a new level, you now have to collide two PROTONS!");
            case 14:
                return new Level(R.drawable.level_up_fourteen, "HIGGS BOSON (2012): On the 4th July 2012, the ATLAS and CMS experiments at CERN's Large Hadron Collider both announced that they observed a new particle with the mass around 125 GeV. The existence of this particle is a prove for Higgs field which is responsible for particles having mass. ");
            case 15:
                return new Level(R.drawable.congrats, "Congratulations you have won");
            default:
                return new Level(R.drawable.level_up_one, "J.J. Thomson discovered electron in the year 1897 by observing so called “cathode rays” which illuminated vacuum tubes when high voltage was applied. He managed to determine the electron’s charge to mass ratio and for the discovery of this elementary particle, he was awarded a nobel prize for physics in the year 1906.");

        }
    }
}
