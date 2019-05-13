package ru.billing.client;

import ru.WorkArray;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;
import ru.billing.stocklist.TechnicalItem;

import java.util.Date;

public class Main
{
    public static void main(String[] args)
    {
        GenericItem item1 = new GenericItem();
        item1.setName("item1");
        item1.setPrice(5.1f);

        GenericItem item2 = new GenericItem();
        item2.setName("item2");
        item2.setPrice(7.3f);

        GenericItem item3 = new GenericItem();
        item3.setName("item3");
        item3.setPrice(4.5f);

        FoodItem foodItem = new FoodItem("foodItem", 1.99f, null, new Date(), (short)5 );

        TechnicalItem technicalItem = new TechnicalItem();
        technicalItem.setName("technicalItem");
        technicalItem.setPrice(15.5f);
        technicalItem.setWarrantyTime((short)100);

        GenericItem[] items = { item1, item2, item3, foodItem, technicalItem };

        for (var item : items)
        {
            item.printAll();
        }

        FoodItem anotherFoodItem = new FoodItem("anotherFoodItem", 1.99f, null, new Date(), (short)5 );

        System.out.println(foodItem.equals(anotherFoodItem));

        FoodItem anotherFoodItemClone = (FoodItem)anotherFoodItem.clone();
        System.out.println(anotherFoodItem.equals(anotherFoodItemClone));

        //-------------------------------------

        Integer[] intArr = { 10, 20, 15 };
        Float[] floatArr = new Float[4];

        for (int i = 0; i < floatArr.length ; i++)
        {
            floatArr[i] = (float)Math.random();
        }

        var insWorkArrayInt = new WorkArray(intArr);
        var insWorkArrayFloat = new WorkArray(floatArr);

        System.out.println(insWorkArrayInt.sum());
        System.out.println(insWorkArrayFloat.sum());

        //-------------------------------------

        String line = "Конфеты ’Маска’;45;120";
        String[] item_fld = line.split(";");
        var foodItemFromLine = new FoodItem(item_fld[0], Integer.parseInt(item_fld[1]), Short.parseShort(item_fld[2]));
        foodItemFromLine.printAll();

        //-------------------------------------

        ItemCatalog catalog = new ItemCatalog();
        catalog.addItem(item1);
        catalog.addItem(item2);
        catalog.addItem(item3);
        catalog.addItem(foodItem);
        catalog.addItem(anotherFoodItem);
        catalog.addItem(anotherFoodItemClone);
        catalog.addItem(foodItemFromLine);
        catalog.addItem(technicalItem);

        long begin = new Date().getTime();

        for (int i = 0; i < 100000; i++)
        {
            catalog.findItemByID(7);
        }

        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));

        begin = new Date().getTime();

        for (int i = 0; i < 100000; i++)
        {
            catalog.findItemByIDAL(10);
        }

        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        //---------------------------------------

        ICatalogLoader loader = new CatalogStubLoader();
        loader.load(catalog);
        catalog.printItems();
    }
}
