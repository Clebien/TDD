package fr.parisnanterre.miage.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    RockPaperScissors rps;
    Player p1;
    Player p2;
    Player p3;
    Player p4;
    List<Play> l1;
    List<Play> l2;

    @BeforeMethod
    public void setUp() {

        rps = new RockPaperScissors();
        l1 = new ArrayList<Play>();
        l2 = new ArrayList<Play>();
        l1.add(Play.PAPER);
        l1.add(Play.ROCK);
        l1.add(Play.PAPER);

        l2.add(Play.ROCK);
        l2.add(Play.ROCK);
        l2.add(Play.SCISSORS);

        p1 = new Player("joueur1",l1);
        p2 = new Player("Joueur2",l2);
        p3 = new Player("joueur1");
        p4 = new Player("Joueur2");


    }

    @AfterMethod
    public void tearDown() {

        rps = null;
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
    }

    @Parameters({"papier","pierre"})
    @Test
    public void testWinPlay(String p1, String p2) {
        assertEquals(rps.play(Play.valueOf(p1),Play.valueOf(p2)), Result.WIN);
    }
    @Parameters({"papier","ciseaux"})
    @Test
    public void testTiePlay(String p1, String p2){
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), Result.TIE);
    }
    @Parameters({"papier","papier"})
    @Test
    public void testLostPlay(String p1, String p2){
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), Result.LOST);
    }

    @DataProvider(name="winData")
    public Object[][] createWinData(){
        return new Object[][]{
                {Play.PAPER,Play.ROCK},
                {Play.ROCK,Play.SCISSORS},
                {Play.SCISSORS,Play.PAPER},
        };

    }
    @DataProvider(name="TieData")
    public Object[][] createTieData(){
        return new Object[][]{
                {Play.PAPER,Play.PAPER},
                {Play.ROCK,Play.ROCK},
                {Play.SCISSORS,Play.SCISSORS},
        };

    }
    @DataProvider(name="LostData")
    public Object[][] createLostData(){
         return new Object[][]{
                {Play.PAPER,Play.SCISSORS},
                {Play.ROCK,Play.PAPER},
                {Play.SCISSORS,Play.ROCK},
        };

    }

    @Test(dataProvider = "TieData")
    public void testWinPlay(Play p1, Play p2){
        assertEquals(rps.play(p1,p2),Result.WIN);
    }
    @Test(dataProvider = "LostData")
    public void testTiePlay(Play p1, Play p2){
        assertEquals(rps.play(p1,p2),Result.TIE);
    }
    @Test(dataProvider = "WinData")
    public void testLostPlay(Play p1, Play p2){
        assertEquals(rps.play(p1,p2),Result.LOST);
    }




}