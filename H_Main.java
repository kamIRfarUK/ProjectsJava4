import H_models.Store;
import H_models.Movie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class H_Main {


    static Store store = new Store();

    public static void main(String[] args){
        System.out.println("\n*********************JAVA VIDEO STORE************************\n");
        //"C:\Users\kamir faruk\IdeaProjects\Bookcamp\src\Hmovies.txt"
        try {
            loadMovies("C:\\Users\\kamir faruk\\IdeaProjects\\Bookcamp\\src\\Hmovies.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally{
            System.out.println("Movies Loaded!!");
            System.out.println(store);
            manageMovies();
        }


        //testing Movie object: new object that is created that is current object
//                Movie movie = new Movie("Perks","Blue-Ray",7.22);
//                System.out.println(movie.getName());
//                movie.setFormat("DVD");
//                System.out.println(movie.getFormat());

        //testing source object: object that is passed in
        //copying values from source obj to current object one by one
//                Movie movie = new Movie("Perks","Blue-Ray",7.22);
//                System.out.println(movie.getName());
//                movie.setFormat("DVD");
//                Movie movie2 = new Movie(movie);
//                System.out.println(movie2.getFormat());

//        //testing toString method of the movie object
//                Movie movie = new Movie("Perks","Blue-Ray",7.22);
//                movie.setFormat("DVD");
//                Movie movie2 = new Movie(movie);
//                System.out.println(movie2);

        //testing store class
//        Store store = new Store();
//        store.addMovie(new Movie("Perks","DVD",9.2));
//        store.addMovie(new Movie("Godfather 2","DVD",6.9));
//        store.addMovie(new Movie("Cincinatti","Blue-Ray",9.0));
//        System.out.println(store);
//        store.action("Perks","sell");
//        store.action("Cincinatti","rent");
//        System.out.println(store);



    }
    //Function Name: loadMovies()
    //@param fileName (String)
    //@throws FileNotFoundExceptfon
    //Inside the function:
    //1. loads movies from
    //2. adds all movies to the store object's movie field.
    //Hint: change the delimited from white space to

    public static void loadMovies(String fileName) throws FileNotFoundException{
        FileInputStream fil = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fil);

        while(scanFile.hasNextLine()){
            String line = scanFile.nextLine();
            String[] words = line.split("--");
            store.addMovie(new Movie(words[0],words[1],Double.parseDouble(words[2])));
        }
        scanFile.close();
    }
    //Function Name: manageMovies()
    //Inside the function:
    //1.Starts a new instance of Scanner
    //2.In an infinite loop, the user can choose to a) purchase b) rent c) return.
    //      case a: ask for the name and sell.
    //      case b: ask for the name and rent.
    //      case c: ask for the name and return.
    //3.call close() from the Scanner object.

    public static void manageMovies(){
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("\nWould you like to \n\ta)purchase.\n\tb)rent.\n\tc)return.");
            String response = scan.nextLine();

            if(!(response.equals("a")||response.equals("b")||response.equals("c")))  {
                scan.close();
                break;
            }
            System.out.println("Enter the name of the movie: ");
            String name = scan.nextLine();
            if(store.getMovie(name) == null){
                System.out.println("\nThe movie is not available for purchase.\n");
                continue;
            }

            switch (response){
                case "a" :
                    if(!(store.getMovie(name).isAvailable())){
                        System.out.println("Movie is currently Unavailable for purchase!");
                        continue;
                    }
                    store.action( name, "sell");
                    break;
                case "b" : store.action( name, "rent");
                    break;
                case "c" : store.action( name, "return");
                    break;
            }
            System.out.println("\n\tUPDATED MOVIES\n"+store);
        }
    }
}
