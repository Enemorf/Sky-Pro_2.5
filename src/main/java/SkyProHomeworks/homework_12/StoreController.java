package SkyProHomeworks.homework_12;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/order")
@RestController
public class StoreController
{
    private final StoreService storeService;

    public StoreController (StoreService storeService)
    {
        this.storeService = storeService;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("objID") List<Integer> objectsID)
    {
            return "В корзину добавлен(ы) предмет(ы) с ID: " + storeService.addObjectToOrder(objectsID);
    }

    @GetMapping(path = "/get")
    public List<StoreObject> get()
    {
        return storeService.getOrderList();
    }
}
