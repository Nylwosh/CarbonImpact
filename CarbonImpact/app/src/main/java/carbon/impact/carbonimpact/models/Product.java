package carbon.impact.carbonimpact.models;

/**
 * Product element
 */
public class Product {

    // ID of the product (inside the database)
    private long id;
    // Timestamp of the last time the product has been update in the database
    private String lastUpdate;
    // Name of the product
    private String name;
    // Category describing the type of the product (transport, food...)
    private String category;
    // Unit used to count the products
    private String unit;
    // Carbon cost by unit
    private float carbonCostByUnit;

    // Empty constructor
    public Product(){
        this.id = -1;
        this.carbonCostByUnit = -1;
    }

    // Constructor with elements
    public Product(String name, String category, String unit, float carbonCostByUnit){
        this.id = -1;
        this.lastUpdate = null;

        this.name = name;
        this.category = category;
        this.unit = unit;
        this.carbonCostByUnit = carbonCostByUnit;
    }

    // Getters
    public long getID(){ return this.id; }
    public String getLastUpdate(){ return this.lastUpdate; } // TODO: deal with a Timestamp
    public String getName(){ return this.name; }
    public String getCategory(){
        return this.category;
    }
    public String getUnit(){
        return this.unit;
    }
    public float getCarbonCostByUnit(){
        return this.carbonCostByUnit;
    }

    // Setters
    public void setId(long id) { this.id = id; }
    public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }
    public void setName(String name){
        this.name = name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }
    public void setCarbonCostByUnit(float carbonCostByUnit){
        this.carbonCostByUnit = carbonCostByUnit;
    }
}
