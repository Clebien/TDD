package fr.parisnanterre.miage.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    RockPaperScissors rps;

    @BeforeMethod
    public void setUp() {
        rps = new RockPaperScissors();
    }

    @AfterMethod
    public void tearDown() {
        rps = null;
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