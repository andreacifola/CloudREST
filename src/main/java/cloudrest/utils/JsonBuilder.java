package cloudrest.utils;

import cloudrest.entities.FogNode;

public class JsonBuilder {

    //TODO sistemare json
    public String nodeToJson(FogNode fogNode){
        String payload = "{ \"id\" : " + fogNode.getId() + ", \"ram\" : " + fogNode.getRam() + ", \"cpu\" : " +
                fogNode.getCpu() + ", \"battery\" : " + fogNode.getBattery() + ", \"storage\" : " +
                fogNode.getStorage() + ", \"type\" : " + "\"" + fogNode.getType() + "\"" + ", \"port\" : " +
                "\"" + fogNode.getPort() + "\", \"currentRam\" : " + fogNode.getCurrentRam() + ", \"currentCpu\" : " +
                fogNode.getCurrentCpu() + ", \"currentBattery\" : " + fogNode.getCurrentBattery() +
                ", \"currentStorage\" : " + fogNode.getCurrentStorage() + ", \"latitude\" : " +
                fogNode.getLatitude() + ", \"longitude\" : " + fogNode.getLongitude() +
                ", \"powered\" : \"" /*+ fogNode.getPowered()*/ + "\"}";
        return payload;
    }
}
