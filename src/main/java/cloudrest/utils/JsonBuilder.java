package cloudrest.utils;

import cloudrest.entities.HeavyTask;
import cloudrest.entities.LightTask;
import cloudrest.entities.MediumTask;

public class JsonBuilder {

    public String LightTaskToJSON(LightTask task){
        String payload="{ \"id\" : \"" + task.getID() + "\" , \"type\" : \"" + task.getType() + "\", \"toEncrypt\": \"" +
                task.getToEncrypt() + "\", \"consumption\" : " + task.getConsumption() + ", \"latitude\" : \"" +
                task.getLatitude() + "\", \"longitude\" : \"" + task.getLongitude() + "\"}";
        //System.out.println(payload);
        return payload;
    }

    public String MediumTaskToJSON(MediumTask task){
        String payload="{ \"id\" : \"" + task.getID() + "\" , \"type\" : \"" + task.getType() + "\", " +
                "\"number\": \"" + task.getNumber() + "\", \"time\" : \"" + task.getTime() + "\", " +
                "\"consumption\" : \"" + task.getConsumption() + "\", \"state\" : \"" + task.getState() + "\", " +
                "\"currentTime\" : \"" + task.getCurrentTime() + "\", " +
                "\"latitude\" : \"" + task.getLatitude() + "\", \"longitude\" : \"" + task.getLongitude() + "\"}";
        //System.out.println(payload);
        return payload;
    }

    public String HeavyTaskToJSON(HeavyTask task){
        String payload="{ \"id\" : \"" + task.getID() + "\" , \"type\" : \"" + task.getType() + "\" ," +
                " \"n\" : \""+ task.getN()+"\", \"partial\" : \"" + task.getPartial() + "\", " +
                "\"last\" : \"" + task.getLast() + "\", \"consumption\" : " + task.getConsumption() + "\", " +
                "\"response\" : \"" + task.getResponse() + "\", \"latitude\" : \"" + task.getLatitude() + "\", " +
                "\"longitude\" : \"" + task.getLongitude() + "\"}";
        //System.out.println(payload);
        return payload;
    }
}

