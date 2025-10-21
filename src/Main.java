import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(read());
//        DogWalkCompany c = new DogWalkCompany();
//        System.out.println(c);
//        int hour = c.addDogs();
//        System.out.println(c);
//        DogWalker w = new DogWalker(4, c);
//        System.out.println(w.walkDogs(hour) + " dogs walked.");
//        System.out.println(c.numAvailableDogs(hour) + " dogs remaining.");
//        hour = c.addDogs();
//        for (int i = 7; i < 11; i++) {
//            c.addDogs();
//        }
//        System.out.println(c);
//        System.out.println("$" + w.dogWalkShift(7,10) + ".00 earned");
    }

    public static int read() throws FileNotFoundException {
        int money = 0;
        //variabletype[] variablename = new variabletype[size of list]
        DogWalkCompany[] companies = new DogWalkCompany[1000]; //empty list of dogwalkercompanies
        File file = new File("Companies.txt");
        Scanner scan = new Scanner(file);
        int index = 0;
        while(scan.hasNextLine()){ //looks through file line by line
            int[] dogs = new int[24]; //creates a list for each line
            for (int i = 0 ; i < dogs.length; i++){
                dogs[i] = scan.nextInt();
            }
            companies[index] = new DogWalkCompany(dogs);
            index++; //adds 1 to update where we are for companies file
        }
        DogWalker[] walkers = new DogWalker[(int)Math.pow (10,4)]; // creates empty list for dogwalkers
        file = new File ("Walkers.txt");
        scan = new Scanner(file);
        index = 0;
        while (scan.hasNextLine()) {
            int dogs = scan.nextInt(); //first number of line (max dogs can be walked)
            DogWalkCompany company = companies[scan.nextInt()]; //calls corresponding company
            walkers[index] = new DogWalker(dogs, company); //setting previously empty elements to dogWalker objects with dog and company info
                    money += walkers[index].dogWalkShift(scan.nextInt(), scan.nextInt()); //calls your start and your end hour and then returns your pay of the individual walker which is then added to the total money
            index++;
        }
        return money;
    }
}
