import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Fraction> _coefficients;

    public Polynomial(Iterable<Fraction> coeffs) {
        _coefficients = new ArrayList<>();

        for (var c : coeffs) {
            _coefficients.add(c);
        }
    }

    public double getValue(double x) {
        double value = 0;

        for (int order = 0; order < _coefficients.size(); order++) {
            value += _coefficients.get(order).doubleValue() * Math.pow(x, order);
        }
        return value;
    }

    public Polynomial add(Polynomial p) {
        ArrayList<Fraction> longPolynomial, shortPolynomial;

        if (this._coefficients.size() >= p._coefficients.size()) {
            longPolynomial = this._coefficients;
            shortPolynomial = p._coefficients;
        } else {
            longPolynomial = p._coefficients;
            shortPolynomial = this._coefficients;
        }

        var newCoefficients = new ArrayList<Fraction>(longPolynomial.size());

        for (int i = 0; i < shortPolynomial.size(); i++) {
            newCoefficients.add(longPolynomial.get(i).add(shortPolynomial.get(i)));
        }

        for (int i = shortPolynomial.size(); i < longPolynomial.size(); i++) {
            newCoefficients.add(longPolynomial.get(i));
        }

        return new Polynomial(newCoefficients);
    }

    @Override
    public String toString() {
        ArrayList<String> monomials = new ArrayList<>(_coefficients.size());
        for (int i = 0; i < _coefficients.size(); i++) {
            if (_coefficients.get(i).doubleValue() == 0) {
                continue;
            }

            StringBuilder monomial = new StringBuilder(_coefficients.get(i).toString());

            if (i > 0) {
                monomial.append('x');
            }

            if (i > 1) {
                monomial.append("^" + i);
            }

            monomials.add(monomial.toString());
        }

        return String.join(" + ", monomials);
    }
}
