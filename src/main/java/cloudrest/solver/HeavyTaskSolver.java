package cloudrest.solver;

import cloudrest.entities.HeavyTask;

import java.io.IOException;
import java.math.BigInteger;

public class HeavyTaskSolver {
/*
    public BigInteger factorial(HeavyTask heavyTask, int n, BigInteger partial, int last) {
            int i;
            BigInteger fact = partial;  //setto il risultato come il parziale eventuale di una esecuzione precedente
            for (i = last + 1; i <= n; i++)
                fact = fact.multiply(BigInteger.valueOf(i));

            System.out.println("fattoriale di n = " + n + ": " + fact);
            return fact;
    }
*/
public BigInteger factorial(HeavyTask heavyTask, int n, BigInteger partial, int last){
    int i;
    BigInteger fact = partial;  //setto il risultato come il parziale eventuale di una esecuzione precedente
    System.out.println("fact ricevuto : " + fact);
    for(i = last+1; i<=n; i++)
        fact = fact.multiply(BigInteger.valueOf(i));

    System.out.println("fattoriale di n = " + n + ": " + fact);
    return fact;
}
}
