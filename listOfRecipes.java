/*
You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. Ingredients to a recipe may need to be created from other recipes, i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. 
Note that two recipes may contain each other in their ingredients.

 input=bread//recipies
yeast flour corn//supplies
2
yeast flour
output=[bread]

Example 1:

Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
Output: ["bread"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
Example 2:

Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
Example 3:

Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich","burger"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".
 

Constraints:

n == recipes.length == ingredients.length
1 <= n <= 100
1 <= ingredients[i].length, supplies.length <= 100
1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10
recipes[i], ingredients[i][j], and supplies[k] consist only of lowercase English letters.
All the values of recipes and supplies combined are unique.
Each ingredients[i] does not contain any duplicate values.
*/

import java.util.*;

class ListOfRecipes
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String r[] = sc.nextLine().split(" ");
        String s[] = sc.nextLine().split(" ");
        List<List<String>> al = new ArrayList<>();
        for (int i = 0; i < r.length; i++) {
            String n = sc.next();
            List<String> al1 = new ArrayList<>();
            for (int j = 0; j < Integer.parseInt(n); j++) {
                al1.add(sc.next());
            }
            al.add(al1);
        }
        System.out.println(find(r, al, s));
    }

    public static final int NOT_VISITED = 0;
    public static final int VISITING = 1;
    public static final int VISITED = 2;

    public static List<String> find(String recipes[], List<List<String>> ingredients, String supplies[]) {
        Map<String, Integer> status = new HashMap<>();
        Map<String, List<String>> prereqs = new HashMap<>();

        for (int i = 0; i < recipes.length; ++i) {
            status.put(recipes[i], NOT_VISITED);
            prereqs.put(recipes[i], ingredients.get(i));
        }

        for (String s : supplies) {
            status.put(s, VISITED);
        }

        List<String> output = new ArrayList<>();
        for (String s : recipes) {
            dfs(s, prereqs, status, output);
        }

        return output;
    }

    public static boolean dfs(String s, Map<String, List<String>> prereqs, Map<String, Integer> status,
            List<String> output) {
        if (!status.containsKey(s)) {
            return false;
        }

        if (status.get(s) == VISITING) {
            return false;
        }

        if (status.get(s) == VISITED) {
            return true;
        }

        status.put(s, VISITING);
        for (String p : prereqs.get(s)) {
            if (!dfs(p, prereqs, status, output)) {
                return false;
            }
        }
        status.put(s, VISITED);
        output.add(s);

        return true;
    }
}





         
