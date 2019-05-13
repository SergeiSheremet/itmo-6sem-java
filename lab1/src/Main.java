/**
 * @author Sergei
 * @deprecated
 */
public class Main
{
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Starting project");

        //------------------

        boolean v_boolean = false;
        byte v_byte = 1;
        short v_short = 2;
        char v_char = 3;
        int v_int = 4;
        long v_long = 5;
        float v_float = 6;
        double v_double = 7;

        System.out.println("boolean: " + v_boolean);
        System.out.println("byte: " + v_byte);
        System.out.println("short: " + v_short);
        System.out.println("char: " + v_char);
        System.out.println("int: " + v_int);
        System.out.println("long: " + v_long);
        System.out.println("float: " + v_float);
        System.out.println("double: " + v_double);

        v_byte = 120;
        v_short = 129;
        v_char = 'a';
        v_int = 65999;
        v_long = 2147483647;
        v_float = 0.33333334f;
        v_double = 0.3333333333333333;
        v_double = 1;

        //---------------------

        for (char c = 'a'; c <= 'z'; c++)
        {
            System.out.print(c);
        }

        long begin = new java.util.Date().getTime();
        for (int i = 0; i <= 1e8; i++) {}
        long end = new java.util.Date().getTime();
        System.out.println(end-begin);

        begin = new java.util.Date().getTime();
        for (long i = 0; i <= 1e8; i++) {}
        end = new java.util.Date().getTime();
        System.out.println(end-begin);

        //----------------------

        int[] mas = { 12, 43, 12, -65, 778, 123, 32, 76 };
        int c = Integer.MIN_VALUE;

        for (int i : mas)
        {
            c = Math.max(c, i);
        }

        System.out.println(c);

        int[][] matrix = new int[3][3];

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                matrix[i][j] = (int)Math.round(Math.random() * 10);
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        for (int i = 0; i < matrix.length; i++)
        for (int j = 0; j < i; j++)
        {
            int t = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = t;
        }

        for (int[] row : matrix)
        {
            for (int i : row) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }
}
