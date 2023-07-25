package SkyProHomeworks.homework_12;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@Service
public class StoreService
{
    private List<StoreObject> currOrder = new ArrayList<>();

    public int addObjectToOrder(int count)
    {

        for(int i = 0; i < count; i++)
        {
            currOrder.add(new StoreObject());
        }
        return count;
    }

    public List<StoreObject> getCurrOrder()
    {
        return currOrder;
    }

}
