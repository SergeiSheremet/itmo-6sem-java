package ru.billing.client;

import ru.billing.stocklist.ItemCatalog;

public interface ICatalogLoader
{
    void load(ItemCatalog catalog);
}
