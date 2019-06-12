package carbon.impact.carbonimpact.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Handles the operations relative to the database.
 */
public class DBHelper extends SQLiteOpenHelper {

    // Database name
    private static final String DATABASE_NAME = "CarbonImpactDatabase";
    // Database version
    private static final int DATABASE_VERSION = 1;

    // Create Product table request
    // TODO: use a file to store the requests?
    private static final String PRODUCT_TABLE_CREATE = "CREATE TABLE Product("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
            "last_update TEXT, "+ // TODO: consider the type "DATE"
            "name TEXT NOT NULL, "+
            "category TEXT, "+
            "unit TEXT, "+
            "carbon_cost_by_unit REAL);";
    // Delete Product table request
    private static final String PRODUCT_TABLE_DELETE = "DROP TABLE IF EXISTS Product;";


    /**
     * Constructor
     *
     * @param context   The context of the activity
     */
    public DBHelper(Context context){
        super(context, //context
              DATABASE_NAME, // db name
       null, // factory (type: CursorFactory)
              DATABASE_VERSION); // db version
    }

    /**
     * Creates the database.
     *
     * @param db    The current database
     */
    @Override
    public void onCreate(SQLiteDatabase db){
        // Create the Product table
        db.execSQL(PRODUCT_TABLE_CREATE);
    }

    /**
     * Executes the operations we have to do when the database is upgraded. For now, it deletes
     * all the databases and create new ones.
     *
     * @param db            The current database
     * @param oldVersion    The last version of the database (from which the old tables to delete come)
     * @param newVersion    The new version of the database (from which the new tables to create come)
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PRODUCT_TABLE_DELETE);
        onCreate(db);
    }
}
