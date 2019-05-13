import java.util.*;

public class FractionSet implements Iterable<Fraction> {
    private Collection<Fraction> _fractions;
    private FractionSetCache _cache;

    public FractionSet(Collection<Fraction> fractions) {
        _fractions = new ArrayList<>();
        _fractions.addAll(fractions);
        _cache = new FractionSetCache();
    }

    public void add(Fraction item) {
        _fractions.add(item);
        _cache.reset();
    }

    public Fraction min() {
        if (_cache.min == null) {
            _cache.min = extremum(new Fraction(Long.MAX_VALUE, 1), -1);
        }

        return _cache.min;
    }

    public Fraction max() {
        if (_cache.max == null) {
            _cache.max = extremum(new Fraction(Long.MIN_VALUE, 1), 1);
        }

        return _cache.max;
    }

    private Fraction extremum(Fraction startValue, int comparingResult) {
        Fraction value = (Fraction) startValue.clone();

        for (var f : _fractions) {
            if (f.compareTo(value) == comparingResult) {
                value = (Fraction) f.clone();
            }
        }

        return value;
    }

    public int numberOfLessThan(Fraction edge) {
        if (!_cache.lessThan.containsKey(edge)) {
            _cache.lessThan.put(edge, comparingToEdge(edge, -1));
        }

        return _cache.lessThan.get(edge);
    }

    public int numberOfGreaterThan(Fraction edge) {
        if (_cache.greaterThan.containsKey(edge)) {
            _cache.greaterThan.put(edge, comparingToEdge(edge, 1));
        }

        return _cache.greaterThan.get(edge);
    }

    private int comparingToEdge(Fraction edge, int comparingResult) {
        int count = 0;

        for (var f : _fractions) {
            if (f.compareTo(edge) == comparingResult) {
                count++;
            }
        }

        return count;
    }

    @Override
    public Iterator<Fraction> iterator() {
        return _fractions.iterator();
    }

    private class FractionSetCache {
        private final int HASH_MAP_SIZE = 3;
        Fraction min = null;
        Fraction max = null;
        LimitedSizeHashMap<Fraction, Integer> lessThan = new LimitedSizeHashMap<>(HASH_MAP_SIZE);
        LimitedSizeHashMap<Fraction, Integer> greaterThan = new LimitedSizeHashMap<>(HASH_MAP_SIZE);

        void reset() {
            min = null;
            max = null;
            lessThan.clear();
            greaterThan.clear();
        }
    }
}
