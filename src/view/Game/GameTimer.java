package view.Game;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class GameTimer {

    private boolean init;

    private Timer timer;
    private TimerTask task;

    private int seconden;
    private int minuten;

    public GameTimer(){
        seconden = 0;
        minuten = 0;
        init = false;
        timer = new Timer();
    }

    public void Start(){
        if(init)
            timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void Stop(){
        timer.cancel();
        timer.purge();
    }

    private TimerTask CreateTask(BiConsumer<Integer, Integer> elkeSecondeEnMinuten){//, elkeMinuut
        // Nieuwe timer aangemaakt
        init = true;

        // Teruggeven actie
        return new TimerTask() {
            @Override
            public void run() {
                seconden++;
                if(seconden >= 60) {
                    minuten++;
                    seconden=0;
                }
                if (minuten >= 60 ) {
                    minuten = 0;
                }
//                else  {
//                    minuten = 0;
//                    seconden = 0;
//                }

                elkeSecondeEnMinuten.accept(minuten, seconden);
            }
        };
    }

    public void InstellenTimer(BiConsumer<Integer, Integer> elkeSecondeEnMinuten){
        // Als er al een taak is
        if(init)
            Stop();

        // Nieuwe taak aanmaken
        task = CreateTask(elkeSecondeEnMinuten);
    }
}
