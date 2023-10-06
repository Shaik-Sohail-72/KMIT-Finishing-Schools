import java.util.*;
class oracle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> ls=new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int ele=sc.nextInt();
            ls.add(ele);
        }
        System.out.println(gcdArrays(ls));
    }
    public static List<Integer> gcdArrays(List<Integer> ls) {
        int n=ls.size();
        List<Integer> mainList = new ArrayList<>();
        int maxGCD = Integer.MIN_VALUE;
        int length = 0;
        for (int i = 0; i < n; i++) {
            int currentGCD = ls.get(i);
            for (int j = i + 1; j < n; j++) {
                currentGCD = gcd(currentGCD, ls.get(j));
                if (currentGCD > maxGCD) {
                    maxGCD = currentGCD;
                    length = j - i + 1;
                } else if (currentGCD == maxGCD && j - i + 1 > length) {
                    length = j - i + 1;
                }
            }
        }
        mainList.add(maxGCD);
        mainList.add(length);
        return mainList;
    }
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
