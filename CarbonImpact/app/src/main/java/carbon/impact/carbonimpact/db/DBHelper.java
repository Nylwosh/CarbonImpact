package carbon.impact.carbonimpact.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import carbon.impact.carbonimpact.models.Product;

public class DBHelper extends SQLiteOpenHelper {

    // Create Product table request
    // TODO: use a file to store the requests?
    private static final String PRODUCT_TABLE_CREATE = "CREATE TABLE Product("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
            "last_update DATE, "+
            "name TEXT NOT NULL, "+
            "category TEXT, "+
            "unit TEXT, "+
            "cost_by_unit REAL, "+
            "CONSTRAINT name_unique UNIQUE (name)"+
            ");";
    // Delete Product table request
    private static final String PRODUCT_TABLE_DELETE = "DROP TABLE IF EXISTS Product;";


    // Create tables
    @Override
    public void onCreate(SQLiteDatabase db){
        // Create the Product table
        db.execSQL(PRODUCT_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PRODUCT_TABLE_DELETE);
        onCreate(db);
    }

    // CRUD (Create Read Update Delete Product
    public Product createProduct(Product product){
        private String insertProduct = "INSERT INTO Product (last_update, name, category, unit, cost_by_unit)"+
                                   "VALUES (CURRENT_TIMESTAMP, "+
                                   product.getName()+", "+
                                   product.getCategory()+", "+
                                   product.getUnit()+", "+
                                   product.getCostByUnit()+
                                   ");";
        // TODO
    }

    public Product getProduct(Product product){

    }

    public void updateProduct(Product product){

    }

    public void deleteProduct(Product product){

    }
}
