import java.util.*;

class oracle1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> result = find(n, arr);
        System.out.println("Maximum GCD: " + result.get(0));
        System.out.println("Length of subarray with maximum GCD: " + result.get(1));
    }

    public static List<Integer> find(int n, int arr[]) {
        List<Integer> mainList = new ArrayList<>();
        int maxGCD = arr[0];
        int length = 1;

        for (int i = 0; i < n; i++) {
            maxGCD = gcd(maxGCD, arr[i]);
            if (maxGCD == 1) {
                break; // GCD can't be greater than 1 if we encounter a 1
            }
        }

        mainList.add(maxGCD);
        mainList.add(n); // Length is always n for the entire array
        return mainList;
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
