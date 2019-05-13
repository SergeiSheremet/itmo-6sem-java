package ru.billing.stocklist;

public class GenericItem implements Cloneable
{
    private static int currentID = 0;

    private int _Id;
    private String _name;
    private float _price;
    private GenericItem _analog;
    private Category _category = Category.GENERAL;

    public GenericItem()
    {
        setId(currentID++);
    }

    public GenericItem(String name, float price, Category category)
    {
        this(name, price);
        setCategory(category);
    }

    public GenericItem(String name, float price, GenericItem analog)
    {
        this(name, price);
        setAnalog(analog);
    }

    private GenericItem(String name, float price)
    {
        this();
        setName(name);
        setPrice(price);
    }

    public void printAll()
    {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof GenericItem)
        {
            var anotherItem = (GenericItem)o;

            return getName().equals(anotherItem.getName())
                && getPrice() == anotherItem.getPrice()
                && getCategory().equals(anotherItem.getCategory());
        }

        return false;
    }

    @Override
    public Object clone()
    {
        try
        {
            GenericItem newItem = (GenericItem)super.clone();
            newItem.setId(currentID++);
            newItem.setAnalog((getAnalog() == null ? this : getAnalog()));

            return newItem;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString()
    {
        return "Id: " + getId()
            + ", Name: " + getName()
            + ", Price: " + getPrice()
            + ", ru.billing.stocklist.Category: " + getCategory();
    }

    public int getId() {
        return _Id;
    }

    public void setId(int Id) {
        _Id = Id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public float getPrice() {
        return _price;
    }

    public void setPrice(float price) {
        _price = price;
    }

    public GenericItem getAnalog() {
        return _analog;
    }

    public void setAnalog(GenericItem analog) {
        _analog = analog;
    }

    public Category getCategory() {
        return _category;
    }

    public void setCategory(Category category) {
        _category = category;
    }
}
