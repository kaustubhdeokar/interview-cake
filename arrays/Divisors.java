import java.util.ArrayList;

public class Divisors {

    public static void main(String[] args) {

        int number = 15;
        ArrayList<Integer> integers = listDivisors(number);
        for (int d : integers) {
            System.out.print(d + " ");
        }

    }

    private static ArrayList<Integer> listDivisors(int number) {
        int i = 1;
        ArrayList<Integer> divisors = new ArrayList<>();
        while (i * i <= number) {
            i++;
        }
        for (; i >= 1; i--) {
            if (number % i == 0) {
                divisors.add(number / i);
            }
        }
        return divisors;
    }

}
