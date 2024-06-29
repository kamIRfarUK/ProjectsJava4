package H_models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, Double rating){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name must contain a value.");
        }
        if (!(format.equals("DVD") || format.equals("Blue-Ray"))){
            throw new IllegalArgumentException("Format must be DVD or Blue-Ray.");
        }
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("Invalid Rating.");
        }
        this.name=name;
        this.format=format;
        this.rating=rating;
        this.sellingPrice = format.equals("Blue-Ray") ? 4.25 : 2.25;
        this.rentalPrice = format.equals("Blue-Ray") ? 1.99 : 0.99;
        this.isAvailable = true;

    }

    public Movie(Movie source){
        this.name=source.name;
        this.format=source.format;
        this.rating=source.rating;
        this.sellingPrice=source.sellingPrice;
        this.rentalPrice=source.rentalPrice;
        this.isAvailable=source.isAvailable;


    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public double getRating() {
        return rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name must contain a value.");
        }
        this.name = name;
    }

    public void setFormat(String format) {
        if (!(format.equals("DVD") || format.equals("Blue-Ray"))){
            throw new IllegalArgumentException("Format must be DVD or Blue-Ray.");
        }
        this.format = format;
        setSellingPrice(format.equals("Blue-Ray") ? 4.25 : 2.25 );
        setRentalPrice(format.equals("Blue-Ray") ? 1.99 : 0.99 );

    }

    public void setRating(double rating) {
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("Invalid Rating.");
        }
        this.rating = rating;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String toString() {
        return "Movie\n" +
                "\t Name=" + this.name + '\n' +
                "\t Format=" + this.format + '\n' +
                "\t Rating=" + this.rating +'\n' +
                "\t SellingPrice=" + this.sellingPrice +'\n' +
                "\t RentalPrice=" + this.rentalPrice +'\n' +
                "\t Availability=" + ( this.isAvailable ? "In-Stock" : "Rented" ) +'\n';

    }
}
