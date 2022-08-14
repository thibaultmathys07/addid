package model;

import view.Game.GamePresenter;
import view.Game.GameView;

import java.util.*;

/**
 * Thibault Mathys
 * 25/07/2022
 */
public class Addit {
    public int dobbelsteenEen;
    public int dobbelsteenTwee;
    public int aantalDobbelsteenGegooid = 0;
    final int MAXGETALLEN = 4;
    public int totaaldobbelsteen;
    public boolean spelGedaan = false;
    Integer[] blokkjes = {2,3,4,5,6,8,9,10,11,12};
    List<Integer> blokkjesList = new ArrayList<>(Arrays.asList(blokkjes));

    List<Integer> p1 = new ArrayList<>();
    List<Integer> p2 = new ArrayList<>();
    Rekenmachine rekenmachine;
    GamePresenter gamePresenter;

    public void eindeSpel() {
        if (p1.isEmpty() || p2.isEmpty()) {
            spelGedaan = true;
        }
    }

    public int Dobbelsteenos1() {
        dobbelsteenEen = new Random().nextInt(6) + 1;
        return dobbelsteenEen;
    }

    public int Dobbelsteenos2() {
        dobbelsteenTwee = new Random().nextInt(6) + 1;
        aantalDobbelsteenGegooid ++;
        return dobbelsteenTwee;
    }

    public void controleberkening() {
        totaaldobbelsteen = dobbelsteenEen + dobbelsteenTwee;
        System.out.println(rekenmachine.getResultaat());
        //if (rekenmachine.getResultaat() == totaaldobbelsteen) {
            //getp1().remove(rekenmachine.bewerking.get(0));
            //getp1().remove(rekenmachine.bewerking.get(1));
            //getp2().add(rekenmachine.bewerking.get(0));
            //getp2().add(rekenmachine.bewerking.get(1));
            //System.out.println(p1);
          //  System.out.println(p2);
        //}
        //else if (rekenmachine.getResultaat() < totaaldobbelsteen) {}
        //else {}
    }

    public String stennenKrijgen1() {
        Collections.shuffle(blokkjesList);
        for (int i = 0; i <= MAXGETALLEN; i ++) {
            p1.add(blokkjesList.get(i));
            blokkjesList.remove(p1);
        }
        Collections.sort(p1);
        Collections.reverse(p1);
        System.out.println(p1);
        return p1.toString();
    }

    public String stennenKrijgen2 () {
        for (int i = 5; i <= 9; i ++) {
            p2.add(blokkjesList.get(i));
            blokkjesList.remove(p2);
        }
        Collections.sort(p2);
        Collections.reverse(p2);
        System.out.println(p2);
        return p2.toString();
    }

//    public void bewerking() {
//        GameView gameView;
//
//        bewerking.add(0);
//        if (0 <= 1 ) {
//            p1.remove(gameView.SetClickStenenSpeler1(););
//        }
//        else if (10 <= 0) {
//            p2.remove(0);
//        }
//        else {
//
//        }
//    }

    public int getAantalDobbelsteenGegooid() {
        return aantalDobbelsteenGegooid;
    }

    public List<Integer> getp1() {
        return p1;
    }

    public List<Integer> getp2() {
        return p2;
    }

    boolean isSpelGedaan() {
        return spelGedaan;
    }
}