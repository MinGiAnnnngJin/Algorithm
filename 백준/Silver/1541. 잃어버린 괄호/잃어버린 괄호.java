import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        sc.close();
        System.out.println(mainExpression(n));
    }
    public static int mainExpression(String expression) {
    String[] groups = expression.split("-");
    int total = sumOfGroup(groups[0]);
    for (int i = 1; i < groups.length; i++) {
        total -= sumOfGroup(groups[i]);
    }
    return total;
    }
    private static int sumOfGroup(String group) {
        String[] numbers = group.split("\\+");
        int sum = 0;
        for(String number : numbers) {
            sum+=Integer.parseInt(number);
        }
        return sum;
    }
}
