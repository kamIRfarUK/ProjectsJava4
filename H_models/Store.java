package H_models;

import java.util.ArrayList;

public class Store {


    //Welcome to the Java Video Store.
    //The store sells movies and lets the user rent/return them.
    //The store starts by adding movies to its collection.
    //A movie is described by its name, format, rating.
    //A movie can be in-stock or rented.
    //The selling price of a movie is $4.25 for Blue-Ray format and $2.25 for DVD.
    //The rental price of a movie is $1.99 for Blue-Ray format and $0.99 for DVD.

    ArrayList<Movie> movies;

    public Store(){
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie( int index){
        return new Movie(this.movies.get(index));
    }
    public Movie getMovie(String name){
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name)) {
                return new Movie(this.movies.get(i));
            }
        }
        return null;
    }

    public void setMovie(int index, Movie movie){
        this.movies.set(index,new Movie(movie));
    }

    public void addMovie(Movie movie){
        this.movies.add(new Movie(movie));
    }

    public void action(String name, String action){
        if(movies.isEmpty()){
            throw new IllegalStateException("Empty Store is not valid to perform action.");
        }
        if(!(action.equals("sell") || action.equals("rent") || action.equals("return") )){
            throw new IllegalArgumentException("Action Invalid! must be only sell,rent or return.");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name must contain a value.");
        }
        for (int i = 0; i < this.movies.size(); i++) {
            if(this.movies.get(i).getName().equals(name)){
                switch (action){
                    case "sell" :
                    if(!(this.movies.get(i).isAvailable())){
                        throw new IllegalStateException("Cannot sell movie if already rented out!.");
                    }
                     this.movies.remove(i);
                        break;
                    case "rent" : this.movies.get(i).setAvailable(false);
                        break;
                    case "return" : this.movies.get(i).setAvailable(true);
                        break;

                }
            }
        }
    }
    //cases handled by Action and switch
//    public void sellMovie(String name){
//        for (int i = 0; i < this.movies.size(); i++) {
//            if(this.movies.get(i).getName().equals(name)){
//                this.movies.remove(i);
//            }
//        }
//    }
//    public void rentMovie(String name){
//        for (int i = 0; i < this.movies.size(); i++) {
//            if(this.movies.get(i).getName().equals(name)){
//                this.movies.get(i).setAvailable(false);
//            }
//        }
//    }
//    public void returnMovie(String name){
//        for (int i = 0; i < this.movies.size(); i++) {
//            if(this.movies.get(i).getName().equals(name)){
//                this.movies.get(i).setAvailable(true);
//            }
//        }
//    }



    public String toString() {
        String temp ="";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }
}
