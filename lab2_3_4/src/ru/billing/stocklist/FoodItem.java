package ru.billing.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem
{
    private Date _dateOfIncome;
    private short _expires;

    public FoodItem(String name, float price, FoodItem analog, Date date, short expires)
    {
        super(name, price, analog);
        setDateOfIncome(date);
        setExpires(expires);
        setCategory(Category.FOOD);
    }

    public FoodItem(String name, float price, short expires)
    {
        this(name, price, null, null, expires);
    }

    public FoodItem(String name)
    {
        this(name, 0.0f, null, null, (short) 0);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof FoodItem)
        {
            var anotherItem = (FoodItem)o;

            return super.equals(o)
                && getDateOfIncome().equals(anotherItem.getDateOfIncome())
                && getExpires() == anotherItem.getExpires();
        }

        return false;
    }

    @Override
    public Object clone()
    {
        return super.clone();
    }

    @Override
    public String toString()
    {
        return super.toString()
            + ", Date of income: " + getDateOfIncome()
            + ", Expires: " + getExpires();
    }

    public Date getDateOfIncome() {
        return _dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this._dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return _expires;
    }

    public void setExpires(short expires) {
        this._expires = expires;
    }
}
