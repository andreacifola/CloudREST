package cloudrest.solver;

import cloudrest.entities.HeavyTask;
import cloudrest.handler.InterruptionHandler;

import java.io.IOException;
import java.math.BigInteger;

public class HeavyTaskSolver {

    /**
     * This method solves an heavy task, it computes the factorial of a given number n
     * @param heavyTask : task
     * @param n : number
     * @param partial : keeps track of the result for each iteration of the for loop
     * @param last : keeps track of the index i
     * @return : factorial
     */
    public BigInteger factorial(HeavyTask heavyTask, int n, BigInteger partial, int last){
        int i;
        BigInteger fact = partial;  //setto il risultato come il parziale eventuale di una esecuzione precedente
        System.out.println("fact ricevuto : " + fact);
        for(i = last+1; i<=n; i++) {

            //controllo interruzione
            boolean flag = InterruptionHandler.getInstance().getFlagByTask(heavyTask.getID());
            if (flag) {
                //interruption
                System.out.println("job da interrompere");
                return null;
            }

            fact = fact.multiply(BigInteger.valueOf(i));
        }

        System.out.println("Heavy task esetfattoriale di n = " + n + ": " + fact);
        return fact;
    }
}
