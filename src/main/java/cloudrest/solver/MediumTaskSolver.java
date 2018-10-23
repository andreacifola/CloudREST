package cloudrest.solver;

import cloudrest.entities.MediumTask;

import java.io.IOException;
import java.math.BigInteger;

public class MediumTaskSolver {

    public long count(MediumTask mediumTask, Integer state, Long currentTime) throws IOException, InterruptedException {
        int i;

        //recupero il tempo che eventualmente può essere legato ad una esecuzione precedente
        Long time = mediumTask.getCurrentTime();

        Long start = System.currentTimeMillis();

        for (i = state+1; i < 1000000; i++) {
            if (mediumTask.getNumber() == i) {
                break;
            }
        }

        //lo aggiorno con il tempo della esecuzione attuale
        time = time + System.currentTimeMillis() - start + 5;
        return time;
    }
}