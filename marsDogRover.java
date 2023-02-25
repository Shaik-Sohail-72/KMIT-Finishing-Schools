/*On Mars, there are n energy outposts resting around the planet, each energy outpost 
supplies energy, and energy at the ith outpost is energy[i]. We have a robotic dog 
that runs on an energy cell, it costs charge[i] of energy for the dog to run from 
the ith outpost to the next i+1th outpost. The dog begins the journey with an 
empty energy cell at one of the energy outposts.

Given two integer arrays energy and charge, return the index of starting energy outpost if  
the dog can travel around the planet once in a sunwise direction, otherwise, return -1

Sample 
Input:
5     //no of outposts                                                                                                                  
1 2 3 4 5  // energy                                                                                                             
3 4 5 1 2  // charge    

output:3 
Explanation:
Start at outpost 3 (index 3) and charge up with 4 units of energy. dog's cell = 0 + 4 = 4
Travel to outpost 4. dog's cell = 4 - 1 + 5 = 8
Travel to outpost 0. dog's cell = 8 - 2 + 1 = 7
Travel to outpost 1. dog's cell = 7 - 3 + 2 = 6
Travel to outpost 2. dog's cell = 6 - 4 + 3 = 5
Travel to outpost 3. The cost is 5. dog's cell is just enough to travel back to outpost 3.
Therefore, return 3 as the starting index.

Sample2
Input:
3     // no of outposts                                                                                                                  
2 3 4   // energy                                                                                                 
3 4 3   // charge                                                                                                                
output:-1 
Explanation:
The dog can't start at outpost 0 or 1, as there is not enough energy to travel to the next outpost.
if the dog starts at outpost 2 and fills with 4 units of energy. dog's cell = 0 + 4 = 4
Travel to outpost 0. Your tank = 4 - 3 + 2 = 3
Travel to outpost 1. Your tank = 3 - 3 + 3 = 3
The dog cannot travel back to outpost 2, as it requires 4 units of energy but it only has 3.
Therefore, the dog can't travel around the circuit once no matter where it starts.
*/

import java.util.*;
class marsDogRover{
    public static int cal(int a,int arr[],int arr1[]){
        int total_energy=0;
        int curr_energy=0;
        int index=0;
        for(int i=0;i<a;i++){
            total_energy+=(arr[i]-arr1[i]);
            curr_energy+=(arr[i]-arr1[i]);
            if(curr_energy<(arr[(i+1)%a]-arr1[i])){
                index=i;
                curr_energy=0; 
            }
        }
        if(total_energy<0){
            return -1;
        }else{
            return index;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int energy[]=new int[n];
        int charge[]=new int[n];
        for(int i=0;i<n;i++){
            energy[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            charge[i]=sc.nextInt();
        }
        System.out.println(cal(n,energy,charge));
    }
}