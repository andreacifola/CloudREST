package cloudrest.solver;

import cloudrest.entities.LightTask;
import java.io.IOException;

public class LightTaskSolver {

    public String CaesarCode(LightTask lightTask, Integer loopCount) throws IOException {
        String toEncrypt = lightTask.getToEncrypt();
        String encrypted;

        if(loopCount == -1)
            encrypted = "";
        else
            encrypted = lightTask.getEncrypted();

        int i;
        for (i = loopCount+1; i < toEncrypt.length(); i++) {
            char letter = toEncrypt.charAt(i);
            if (Character.isLetter(letter)) {
                letter += 3;
            }
            encrypted += letter;
        }
        return encrypted;
    }
}