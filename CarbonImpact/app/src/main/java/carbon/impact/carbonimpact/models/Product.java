package carbon.impact.carbonimpact.models;

import carbon.impact.carbonimpact.db.DBHelper;

public class Product {

    // Name of the product
    private String name;
    // Category describing the type of the product (transport, food...)
    private String category;
    // Unit used to count the products
    private String unit;
    // Carbon cost by unit
    private float costByUnit;

    // Database helper
    protected static DBHelper dbHelper;

    // Constructor
    public Product(String name, String category, String unit, float costByUnit){
        this.name = name;
        this.category = category;
        this.unit = unit;
        this.costByUnit = costByUnit;
    }

    // Getters
    public String getName(){ return this.name; }
    public String getCategory(){
        return this.category;
    }
    public String getUnit(){
        return this.unit;
    }
    public float getCostByUnit(){
        return this.costByUnit;
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }
    public void setCostByUnit(float costByUnit){
        this.costByUnit = costByUnit;
    }

    // Database
    public void dbPutProduct(){
        dbHelper.putProduct(this);
        // TODO: handle the returned product?
    }

    public String getProductId(){
        dbHelper.getProductId(this);
    }
}
