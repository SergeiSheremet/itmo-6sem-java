import java.util.Objects;

public final class Fraction extends Number implements Comparable<Fraction>, Cloneable {
    private final long _numerator;
    private final long _denominator;

    public Fraction(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }

        _numerator = numerator / Long.signum(denominator);
        _denominator = denominator / Long.signum(denominator);
    }

    public Fraction negative() {
        return new Fraction(-_numerator, _denominator).reduce();
    }

    public Fraction add(Fraction o) {
        return new Fraction(this._numerator * o._denominator + this._denominator * o._numerator,
                this._denominator * o._denominator)
                .reduce();
    }

    public Fraction substract(Fraction o) {
        return this.add(o.negative());
    }

    public Fraction multiply(Fraction o) {
        return new Fraction(this._numerator * o._numerator,
                this._denominator * o._denominator)
                .reduce();
    }

    public Fraction divide(Fraction o) {
        return this.multiply(new Fraction(o._denominator, o._numerator));
    }

    public Fraction reduce() {
        long absNumerator = Math.abs(_numerator);
        long absDenominator = Math.abs(_denominator);

        while (absNumerator != 0 && absDenominator != 0) {
            if (absNumerator > absDenominator) {
                absNumerator %= absDenominator;
            } else {
                absDenominator %= absNumerator;
            }
        }

        long gdc = Long.signum(_denominator) * (absNumerator + absDenominator);
        return new Fraction(_numerator / gdc, _denominator / gdc);
    }

    @Override
    public int compareTo(Fraction other) {
        return (int) Math.signum(doubleValue() - other.doubleValue());
    }

    @Override
    public int intValue() {
        return (int) (_numerator / _denominator);
    }

    @Override
    public long longValue() {
        return _numerator / _denominator;
    }

    @Override
    public float floatValue() {
        return (float) _numerator / _denominator;
    }

    @Override
    public double doubleValue() {
        return (double) _numerator / _denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Fraction) {
            var other = (Fraction) o;
            return this.compareTo(other) == 0;
        }

        return false;
    }

    @Override
    public String toString() {
        return _numerator + (_denominator != 1 ? "/" + _denominator : "");
    }

    @Override
    public int hashCode() {
        return Objects.hash(_numerator, _denominator);
    }

    @Override
    public Object clone() {
        return new Fraction(_numerator, _denominator);
    }
}
