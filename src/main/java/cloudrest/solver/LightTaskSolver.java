package cloudrest.solver;

import cloudrest.entities.LightTask;
import cloudrest.utils.UtilityMD5;


public class LightTaskSolver {

    public String hash(LightTask task){
        String encrypted = UtilityMD5.stringByHashingPassword(task.getToEncrypt());
        return encrypted;
    }
}