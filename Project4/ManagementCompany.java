package Project4;
public class ManagementCompany {

    private final int MAX_PROPERTY = 5;
    private final int MGMT_WIDTH = 10;
    private final int MGMT_DEPTH = 10;
    private double mgmFeePer;
    private String name;
    private Property[] properties;
    private String taxID;
    private Plot plot;

    /**
     * A simple no-args constructor for ManagementCompany
     */
    public ManagementCompany() {
        name = taxID = "";
        mgmFeePer = 0;
        properties = new Property[MAX_PROPERTY];
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    /**
     *
     * @param name the company's name
     * @param taxID the company's taxID
     * @param mgmFeePer the percentage of rent taken as a management fee
     */
    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer/100;
        properties = new Property[MAX_PROPERTY];
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    /**
     *
     * @param name the company's name
     * @param taxID the company's taxID
     * @param mgmFeePer the percentage of rent taken as a management fee
     * @param x the top-left x coordinate of the management plot
     * @param y the top-left y coordinate of the management plot
     * @param width the width of the management plot
     * @param depth the depth of the management plot
     */
    public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer/100;
        properties = new Property[MAX_PROPERTY];
        plot = new Plot(x, y, width, depth);
    }

    /**
     *  A clone constructor that performs a deep clone of the passed ManagementCompany parameter
     * @param company the ManagementCompany to clone
     */

    public ManagementCompany(ManagementCompany company) {
        this.name = company.getName();
        this.taxID = company.getTaxID();
        this.mgmFeePer = company.getMgmFeePer()/100;
        for (int i = 0; i < properties.length; i++) {
            if (company.properties[i] != null) {
                properties[i] = new Property(company.properties[i]);
            } else {
                break;
            }
        }
        plot = new Plot(company.plot);
    }

    /**
     * Adds the property given to the properties array. returns the index of the property if the operation was successful
     * returns -1 if the array was full
     * returns -2 if the given property is null
     * returns -3 if the property is not inside the ManagementCompany's plot
     * returns -4 if the property overlaps any of the properties already in the management plot.
     * @param property the property to add
     * @return the index of the property, or the failure code of the addProperty operation
     */
    public int addProperty(Property property) {
        if (property == null)
            return -2;
        else if (!this.plot.encompasses(property.getPlot()))
            return -3;
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null) {
                if (property.getPlot().overlaps(properties[i].getPlot())) {
                    return -4;
                }
            } else {
                break;
            }
        }
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                properties[i] = new Property(property);
                return i;
            }
        }
        return -1;
    }

    /**
     * Creates a new property from the given values, and uses the default Plot constructor. returns the index of the property if the operation was successful
     * returns -1 if the array was full
     * returns -3 if the property is not inside the ManagementCompany's plot
     * returns -4 if the property overlaps any of the properties already in the management plot.
     * @param propertyName the name of the property
     * @param city the city the property is in
     * @param rent the rent of the property
     * @param owner the owner of the property
     * @return the index of the property, or the failure code of the addProperty operation
     */
    public int addProperty(String propertyName, String city, double rent, String owner) {
        Property property = new Property(propertyName, city, rent, owner);
        if (!this.plot.encompasses(property.getPlot()))
            return -3;
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null) {
                if (property.getPlot().overlaps(properties[i].getPlot())) {
                    return -4;
                }
            } else {
                break;
            }
        }
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                properties[i] = new Property(property);
                return i;
            }
        }
        return -1;
    }

    /**
     * Creates a new property from the given values. returns the index of the property if the operation was successful
     * returns -1 if the array was full
     * returns -3 if the property is not inside the ManagementCompany's plot
     * returns -4 if the property overlaps any of the properties already in the management plot.
     * @param propertyName the name of the property
     * @param city the city the property is in
     * @param rent the rent of the property
     * @param ownerName the owner of the property
     * @param x the top-left x coordinate of the property
     * @param y the top-left y coordinate of the property
     * @param width the width of the property
     * @param depth the depth of the property
     * @return the index of the property, or the failure code of the addProperty operation
     */
    public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width, int depth) {
        Property property = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
        if (!this.plot.encompasses(property.getPlot()))
            return -3;
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null) {
                if (property.getPlot().overlaps(properties[i].getPlot())) {
                    return -4;
                }
            } else {
                break;
            }
        }
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                properties[i] = new Property(property);
                return i;
            }
        }
        return -1;
    }

    /**
     * Sums the rents of all the properties
     * @return the total rent of the property
     */
    public double totalRent() {
        // init needed total variable
        double total = 0;
        // loop thru the properties array
        for (int i = 0; i < MAX_PROPERTY; i++) {
            // check if the properties array is null
            if (properties[i] != null) {
                // sum the rent of the current property will the total rent
                total += properties[i].getRentAmount();
            } else {
                break;
            }
        }
        // return total rent
        return total;
    }

    /**
     *
     * @return the index of the property with the highest rent value
     */
    private int maxRentPropertyIndex() {
        int indexMaxRent = 0;
        for (int i = 1; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                break;
            }
            if (properties[i].getRentAmount() > properties[indexMaxRent].getRentAmount())
                indexMaxRent = i;
        }
        return indexMaxRent;
    }

    
    public double maxRentProp() {
        return properties[maxRentPropertyIndex()].getRentAmount();
    }

    
    private String displayPropertyAtIndex(int i) {
        return properties[i].toString();
    }

    @Override
    public String toString() {
        String output = "List of the properties for " + name + ", taxID: " + taxID;
        output += "\n_________________________________________________________\n";
        for (int i = 0; i < MAX_PROPERTY && properties[i] != null; i++) {
        	output += displayPropertyAtIndex(i);
        }
        output += "\n_________________________________________________________\n";
        output += String.format("Total Management Fee: %.1f", totalRent()*mgmFeePer); // format this to once decimal place

        return output;
    }

    public int getMAX_PROPERTY() {
        return MAX_PROPERTY;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public Plot getPlot() {
        return new Plot(plot);
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }
}