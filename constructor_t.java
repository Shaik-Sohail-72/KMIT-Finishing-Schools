public class constructor_t {
 int numberEggs;// instance variable
 public static void main(String[] args) {
 constructor_t mother = new constructor_t();
 mother.numberEggs = 5; // set variable
 System.out.println(mother.numberEggs); // read variable
 }
}