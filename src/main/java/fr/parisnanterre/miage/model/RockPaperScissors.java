package fr.parisnanterre.miage.model;

public class RockPaperScissors {

    RockPaperScissors(){
    }

    public Result play(Play p1, Play p2){

        Result result = null;
        switch (p1){
            case ROCK:
                switch (p2){
                    case PAPER:
                        result = Result.LOST;
                        break;
                    case ROCK:
                        result = Result.TIE;
                        break;
                    case SCISSORS:
                        result = Result.WIN;
                        break;
                }
                break;
            case PAPER:
                switch (p2){
                    case PAPER:
                        result = Result.TIE;
                        break;
                    case ROCK:
                        result = Result.WIN;
                        break;
                    case SCISSORS:
                        result = Result.LOST;
                        break;
                }
                break;
            case SCISSORS:
                switch (p2){
                    case PAPER:
                        result = Result.WIN;
                        break;
                    case ROCK:
                        result = Result.LOST;
                        break;
                    case SCISSORS:
                        result = Result.TIE;
                        break;
                }
                break;
        }
        return result;

    }
}
