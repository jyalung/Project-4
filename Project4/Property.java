package Project4;

public class Property {

    private String city;
    private String owner;
    private String propertyName;
    private double rent;
    private Plot plot;


    public Property() {
        city = "";
        owner = "";
        propertyName = "";
        rent = 0;
        plot = new Plot();
    }

    public Property(Property p) {
        this.propertyName = p.getPropertyName();
        this.city = p.getCity();
        this.rent = p.getRentAmount();
        this.owner = p.getOwner();
        this.plot = new Plot(p.plot);
    }

    public Property(String propertyName, String city, double rent, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rent = rent;
        this.owner = owner;
        plot = new Plot();
    }
    
    public Property(String propertyName, String city, double rent, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rent = rent;
        this.owner = owner;
        plot = new Plot(x, y, width, depth);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setRentAmount(double rent) {
        this.rent = rent;
    }

    public double getRentAmount() {
        return rent;
    }

    public void setPlot(int x, int y, int width, int depth) {
        this.plot = new Plot(x, y, width, depth);
    }

    public Plot getPlot() {
        return plot;
    }
    
   
    public String toString() {
    	String message = "Property Name: " + propertyName
				+ "\nLocated in " + city
				+ "\nBelonging to: " + owner
				+ "\nRent Amount: " + rent + "\n";
		return message;
    }
}