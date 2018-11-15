package cloudrest.solver;

import cloudrest.entities.MediumTask;
import cloudrest.handler.InterruptionHandler;

import java.io.IOException;
import java.math.BigInteger;

public class MediumTaskSolver {

    /**
     * this method computes a medium task, how long it would take to crack a password with bruce force.
     * @param mediumTask : task
     * @param state : keeps track of the progress
     * @param currentTime : time
     * @return : time
     * @throws IOException
     * @throws InterruptedException
     */
    public long count(MediumTask mediumTask, Integer state, Long currentTime) throws IOException, InterruptedException {
        int i;

        //recupero il tempo che eventualmente può essere legato ad una esecuzione precedente
        Long time = mediumTask.getCurrentTime();
        Long start = System.currentTimeMillis();

        for (i = state+1; i < 1000000; i++) {
            //controllo interruzione
            boolean flag = InterruptionHandler.getInstance().getFlagByTask(mediumTask.getID());

            if(flag){
                //interruption
                System.out.println("job da interrompere");
                return 0;
            }
            if (mediumTask.getNumber() == i) {
                break;
            }
        }

        //lo aggiorno con il tempo della esecuzione attuale
        time = time + System.currentTimeMillis() - start + 5;
        return time;
    }
}