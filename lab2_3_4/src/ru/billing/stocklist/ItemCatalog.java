package ru.billing.stocklist;

import ru.billing.stocklist.GenericItem;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog
{
    private HashMap<Integer, GenericItem> catalog = new HashMap<>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<>();

    public void addItem(GenericItem item)
    {
        catalog.put(item.getId(), item);
        ALCatalog.add(item);
    }

    public void printItems()
    {
        for(var i : ALCatalog)
        {
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id)
    {
        return catalog.getOrDefault(id, null);
    }

    public GenericItem findItemByIDAL(int id)
    {
        for(GenericItem i : ALCatalog)
        {
            if(i.getId() == id)
            {
                return (GenericItem)i.clone();
            }
        }

        return null;
    }
}
