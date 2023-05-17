/*K-4 City 

In the near future, human engineers have realized that the optimal model for organizing infrastructure in cities is the fully connected graph. Kura recently moved into the town of Koenigsberg. Its a small town that consists of only 4 houses, for each of its inhabitants. As the new arrival, Kura discovers that he has three neighbors: Leon, Lieb and Hamil. Also, he finds a map of the town in your house. It looks like this in a weighted graph format: Kura's house is marked as h, Leon's house is marked as a, 

Lieb's house is marked as b, and Hamil's house is marked as c and ha, hb, hc, ab, bc & ca represent the repective distances between the houses. 

From the map, Kura was able to determine that the distance from any place ' x ' on the map to a place ' y ' on the map is same as the distance from ' y ' to ' x '. After spending the day unpacking, Kura decided to visit 2 of his neighbors. Since, he has limited energy to walk, you must help Kura determine the minimum distance he must walk to meet any 2 of his neighbors and come back home. He doesn't mind visiting the same neighbor or passing the same road multiple times. The only goal is to minimize the total distance traveled.


 Input:=The input consists of one line containing space separated 6 integers representing ha, hb, hc, ac,ab,bc as described in the problem. 

output:=A single number representing minimum distance that kura needs to travel to visit any 2 of his neighbors and return home. 

Constraints:
1<=ha,hb,hc,ac,ab,bc<=10 to power 12

Sample input:3 2 8 8 1 4
Sample output: 6
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ha = scanner.nextInt();
        int hb = scanner.nextInt();
        int hc = scanner.nextInt();
        int ac = scanner.nextInt();
        int ab = scanner.nextInt();
        int bc = scanner.nextInt();
        int distance1 = ha + ab + hb;
        int distance2 = ha + ac + hc;
        int distance3 = hb + bc + hc;
        int minDistance = Math.min(distance1, Math.min(distance2, distance3));
        System.out.println(minDistance);
    }
}