package cloudrest.solver;

import cloudrest.entities.LightTask;
import cloudrest.utils.UtilityMD5;

import java.io.IOException;


public class LightTaskSolver {

    /*
    public String hash(LightTask task){
        String encrypted = UtilityMD5.stringByHashingPassword(task.getToEncrypt());
        return encrypted;
    }
    */

    //GetStateHandler getStateHandler = new GetStateHandler();

    public String CaesarCode(LightTask lightTask) throws IOException {
        String encrypted = "";
        String toEncrypt = lightTask.getToEncrypt();
        for (int i = 0; i < toEncrypt.length(); i++) {
            char letter = toEncrypt.charAt(i);
            if (Character.isLetter(letter)) {
                letter += 3;
            }
            encrypted += letter;

            /*
            getStateHandler.sendLightTaskState(i, encrypted, lightTask.getID());
            if (i % 100 == 0 && i != 0) {
                //getStateHandler.sendLightTaskState(i, encrypted, lightTask.getID());
            }
            */
        }
        return encrypted;
    }
}