import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Fraction> al = new ArrayList<>();
        al.add(new Fraction(3, 4));
        al.add(new Fraction(1, 1));
        al.add(new Fraction(-2, 5));
        al.add(new Fraction(6, -2));
        al.add(new Fraction(2, 7));
        al.add(new Fraction(5, 9));

        Polynomial p1 = new Polynomial(al);
        Polynomial p2 = new Polynomial(al);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.add(p2));
    }
}
