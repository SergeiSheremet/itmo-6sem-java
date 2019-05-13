import java.util.LinkedHashMap;
import java.util.Map;

public class LimitedSizeHashMap<Key, Value> extends LinkedHashMap<Key, Value>
{
    private final int SIZE;

    public LimitedSizeHashMap(int maxSize)
    {
        SIZE = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Key, Value> eldest)
    {
        return size() > SIZE;
    }
}
