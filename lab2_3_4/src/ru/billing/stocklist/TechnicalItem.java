package ru.billing.stocklist;

public class TechnicalItem extends GenericItem
{
    private short _warrantyTime;

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof TechnicalItem)
        {
            var anotherItem = (TechnicalItem)o;

            return super.equals(o)
                && getWarrantyTime() == anotherItem.getWarrantyTime();
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
            + ", Warranty time: " + getWarrantyTime();
    }

    public short getWarrantyTime()
    {
        return _warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime)
    {
        _warrantyTime = warrantyTime;
    }
}
