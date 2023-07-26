package SkyProHomeworks.homework_12;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@Repository
public class StoreOrder
{
    private List<StoreObject> currentObject = new ArrayList<>();

    public void addToList(StoreObject obj)
    {
        currentObject.add(obj);
    }

    public List<StoreObject> getCurrentOrder()
    {
        return currentObject;
    }
}
