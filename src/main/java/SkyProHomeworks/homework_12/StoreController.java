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
    public String add (@RequestParam("count") int count)
    {
            return "В корзину добавлено " + storeService.addObjectToOrder(count) + " предметов!";
    }

    @GetMapping(path = "/get")
    public List<StoreObject> get()
    {
        return storeService.getCurrOrder();
    }
}
