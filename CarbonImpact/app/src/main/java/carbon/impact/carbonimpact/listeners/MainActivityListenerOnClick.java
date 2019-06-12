package carbon.impact.carbonimpact.listeners;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import carbon.impact.carbonimpact.db.DBProductController;

/**
 * Listener of the "Submit" button for the MainActivity
 */
public class MainActivityListenerOnClick implements View.OnClickListener {

    Context context; // Context of the activity
    EditText inputName; // EditText widget where the name of the product is entered
    EditText inputCategory; // EditText widget where the category of the product is entered
    EditText inputUnit; // EditText widget where the unit of the product is entered
    // EditText widget where the carbon cost per unit of the product is entered
    EditText inputCarbonCostPerUnit;

    /**
     * Constructor
     *
     * @param context   The context of the activity
     * @param inputName  The EditText widget where the name of the product is entered
     * @param inputCategory  The EditText widget where the category of the product is entered
     * @param inputUnit  The EditText widget where the unit of the product is entered
     * @param inputCarbonCostPerUnit The EditText widget where the carbon cost per unit of the product
     *                          is entered
     */
    public MainActivityListenerOnClick(Context context, EditText inputName, EditText inputCategory,
                                       EditText inputUnit, EditText inputCarbonCostPerUnit){
        this.context = context;
        this.inputName = inputName;
        this.inputCategory = inputCategory;
        this.inputUnit = inputUnit;
        this.inputCarbonCostPerUnit = inputCarbonCostPerUnit;
    }

    @Override
    public void onClick(View v) {
        System.out.println(v.toString());

        // Get the product's elements
        String name = inputName.getText().toString();
        String category = inputCategory.getText().toString();
        String unit = inputUnit.getText().toString();
        float carbonCostPerUnit = Float.valueOf(inputCarbonCostPerUnit.getText().toString());

        DBProductController dbProductController = new DBProductController(this.context);
        dbProductController.createProduct(name, category, unit, carbonCostPerUnit);
    }
}
