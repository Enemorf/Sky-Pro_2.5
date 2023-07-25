package SkyProHomeworks.homework_12;

import java.util.Random;

public class StoreObject
{
    private int objectID;

    public StoreObject() {
        Random rand = new Random();
        this.objectID = rand.nextInt(10000);
    }

    public int getObjectID() {
        return objectID;
    }

}
