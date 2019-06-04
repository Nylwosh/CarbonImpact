package carbon.impact.carbonimpact.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import carbon.impact.carbonimpact.models.Product;

import java.util.Date;
import java.sql.Timestamp;

/**
 * Controls the operations relative to the Product table in the database.
 */
public class DBProductController extends DBHelper{

    /**
     * Constructor
     */
    public DBProductController(Context context){
        super(context);
    }



    // CRUD (Create Read Update Delete Product

    /**
     * Inserts a new product in the Product table of the database.
     *
     * @param product   The new product to add
     *
     * @return  Whether or not the product has been well inserted
     */
    public boolean createProduct(Product product){
        /*String insertProduct = "INSERT INTO Product (last_update, name, category, unit, carbon_cost_by_unit)"+
                "VALUES (CURRENT_TIMESTAMP, "+
                product.getName()+", "+
                product.getCategory()+", "+
                product.getUnit()+", "+
                product.getCarbonCostByUnit()+
                ");";*/

        ContentValues values = new ContentValues();
        // Last update of the product
        values.put("last_update", new Timestamp(new Date().getTime()).toString());
        // Name of the product
        values.put("name", product.getName());
        // Category of the Product
        values.put("category", product.getCategory());
        // Unit in which the product is counted
        values.put("unit", product.getUnit());
        // Carbon cost by unit of the product
        values.put("carbon_cost_by_unit", product.getCarbonCostByUnit());

        try {
            SQLiteDatabase db = this.getWritableDatabase();
            long newProductID = db.insertOrThrow("Product", //table
                    null, // nullColumnHack,
                    values); // values
            product.setId(newProductID);
            db.close();

            return true; // The product has been correctly inserted into the database

        // If an error occurred
        } catch (SQLException sqlException){
            return false; // The product has not been correctly inserted into the database
        }
    }

    /**
     * Gets the number of products inserted into the database.
     *
     * @return  The number of products inserted into the database
     */
    public int getNumberOfProducts(){
        SQLiteDatabase db = this.getReadableDatabase();
        int count = db.rawQuery("SELECT * FROM Product;", null).getCount();
        db.close();
        return count;
    }

    /**
     * Gets a product from the database.
     *
     * @param productId Id of the product to get
     *
     * @return  An instance of the retrieved product.
     *          (An empty instance if no product corresponds to this id in the database.)
     */
    public Product getProduct(long productId){
        // Create the product instance
        Product retrievedProduct = new Product();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Product WHERE id = "+productId, null); // TODO: look at how to use selectionArgs

        // If at least one entry is returned, we consider the first one and get its elements
        if (cursor.moveToFirst()){
            // Product id
            long id = cursor.getLong(cursor.getColumnIndex("id"));
            retrievedProduct.setId(id);
            // Product last update
            String lastUpdate = cursor.getString(cursor.getColumnIndex("last_update"));
            retrievedProduct.setLastUpdate(lastUpdate);
            // Product name
            String name = cursor.getString(cursor.getColumnIndex("name"));
            retrievedProduct.setName(name);
            // Product category
            String category = cursor.getString(cursor.getColumnIndex("category"));
            retrievedProduct.setCategory(category);
            // Product carbonCostByUnit
            float carbonCostByUnit = cursor.getFloat(cursor.getColumnIndex("carbon_cost_by_unit"));
            retrievedProduct.setCarbonCostByUnit(carbonCostByUnit);
        }

        cursor.close();
        db.close();

        return retrievedProduct;
    }

    /**
     * Updates the information of a product. Does not modify its id.
     *
     * @param product   The modified product
     *
     * @return  True if the update has been correctly done, false otherwise
     */
    public boolean updateProduct(Product product){
        ContentValues values = new ContentValues();

        // Last update of the product
        values.put("last_update", new Timestamp(new Date().getTime()).toString());
        // Name of the product
        values.put("name", product.getName());
        // Category of the Product
        values.put("category", product.getCategory());
        // Unit in which the product is counted
        values.put("unit", product.getUnit());
        // Carbon cost by unit of the product
        values.put("carbon_cost_by_unit", product.getCarbonCostByUnit());

        String where = "id = ?";
        String[] whereArgs = { Long.toString(product.getID()) };

        SQLiteDatabase db = this.getWritableDatabase();
        int numberOfModifiedRows = db.update("Product", values, where, whereArgs);
        db.close();

        return numberOfModifiedRows == 1;
    }

    /**
     * Deletes a product from the database
     *
     * @param productId     Id of the product to delete
     * @return              True if the deletion has been correctly done, false otherwise
     */
    public boolean deleteProduct(long productId){
        SQLiteDatabase db = this.getWritableDatabase();
        int numberOfDeletedRows = db.delete("Product", "id = '"+productId+"'", null);
        db.close();

        return numberOfDeletedRows == 1;
    }
}
