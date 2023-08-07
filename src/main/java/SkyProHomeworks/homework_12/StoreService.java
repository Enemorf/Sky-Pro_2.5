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

    public String addObjectToOrder(List<Integer> objID)
    {
        String res = "";

        for(int i = 0; i < objID.size(); i++)
        {
            storeOrder.addToList(new StoreObject(objID.get(i)));
            res = res + objID.get(i).toString() + (objID.size()!=i+1?", ":".");
        }
        return res;
    }

    public List<StoreObject> getOrderList()
    {
        return storeOrder.getCurrentOrder();
    }


}
