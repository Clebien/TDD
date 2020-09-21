package fr.parisnanterre.miage.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Player {

    private String nom;
    private int Score;
    private List<Play> result;
    private static final int mouvements = 10;

    public Player(String nom, List<Play> result) {
        this.nom = nom;
        this.result = result;
    }
    private static Play generateFor(int nb) {
        switch(nb) {
            case 0: return Play.ROCK;
            case 1: return Play.PAPER;
            default: return Play.SCISSORS;
        }
    }
    private static Play generatePlay() {
        int x = (int) (Math.random() * 3);
        return generateFor(x);
    }
    public static List<Play> generatePlays(int taille) {
        List<Play> rtr = new ArrayList<>(taille);
        for(int i = 0; i<taille; i++) {
            rtr.add(generatePlay());
        }
        return rtr;
    }
    public Player(String nom) {
        this.nom = nom;
        this.result = generatePlays(getMouvements());
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return Score;
    }

    public static int getMouvements() {
        return mouvements;
    }

    public Play getNextMove(){
        Iterator iter = result.iterator();
        while (iter.hasNext()){
            return (Play) iter.next();
        }
        return null;
    }

    public void setScore(int score) {
        Score = score;
    }


}
