package model;

import view.Game.GamePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Thibault Mathys
 * 12/08/2022
 */
public class Rekenmachine {
    private int resultaat;
    private List<Integer> bewerking = new ArrayList<>();

    public void getalToevoegen(int getal) {
        bewerking.add(getal);
    }

    public void plus() {
        resultaat = bewerking.get(bewerking.size()-1) + bewerking.get(bewerking.size()-2);
        bewerking.remove(bewerking.size() - 1);
        bewerking.remove(bewerking.size() - 1);
        bewerking.add(resultaat);
    }

    public void min() {
        resultaat = bewerking.get(bewerking.size()-2) - bewerking.get(bewerking.size()-1);
        bewerking.remove(bewerking.size() - 1);
        bewerking.remove(bewerking.size() - 1);
        bewerking.add(resultaat);
    }

    public void delen() {
        resultaat = bewerking.get(bewerking.size()-1) / bewerking.get(bewerking.size()-2);
        bewerking.remove(bewerking.size() - 1);
        bewerking.remove(bewerking.size() - 1);
        bewerking.add(resultaat);
    }

    public void maal() {
        resultaat = bewerking.get(bewerking.size()-1) * bewerking.get(bewerking.size()-2);
        bewerking.remove(bewerking.size() - 1);
        bewerking.remove(bewerking.size() - 1);
        bewerking.add(resultaat);
    }

    public int getResultaat() {
//        if(bewerking.size() == 0) {
//            return 0;
//        }
        int resultaat = bewerking.get(0);
        bewerking.clear();
        return resultaat;
    }
}
