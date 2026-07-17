
import java.util.*;

public class AllPossibleStrings {

    public static List<String> allPossibleStrings(String s) {
        List<String> ans = new ArrayList<>();

        int n = s.length();

        for (int mask = 1; mask < (1 << n); mask++) {
            String str = "";

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    str += s.charAt(i);
                }
            }

            ans.add(str);
        }

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String s = sc.nextLine();

        List<String> result = allPossibleStrings(s);

        System.out.println(result);
    }
}