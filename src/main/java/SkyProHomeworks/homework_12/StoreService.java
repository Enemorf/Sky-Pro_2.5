package SkyProHomeworks.homework_12;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService
{
    private final StoreOrder storeOrder;

    public StoreService (StoreOrder storeOrder)
    {
        this.storeOrder = storeOrder;
    }

    public int addObjectToOrder(int objID)
    {
        storeOrder.addToList(new StoreObject(objID));
        return objID;
    }

    public List<StoreObject> getOrderList()
    {
        return storeOrder.getCurrentOrder();
    }


}
