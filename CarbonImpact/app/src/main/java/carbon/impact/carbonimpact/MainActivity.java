package carbon.impact.carbonimpact;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import carbon.impact.carbonimpact.db.DBProductController;
import carbon.impact.carbonimpact.listeners.MainActivityListenerOnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the inputs
        EditText inputName = findViewById(R.id.input_product_name);
        EditText inputCategory = findViewById(R.id.input_product_category);
        EditText inputUnit = findViewById(R.id.input_product_unit);
        EditText inputCarbonCostPerUnit = findViewById(R.id.input_product_carbon_cost_per_unit);
        Button submitProduct = findViewById(R.id.submit_product);

        // Instantiate the submit button listener
        MainActivityListenerOnClick onClickSubmitListener = new MainActivityListenerOnClick(this,
                inputName, inputCategory, inputUnit, inputCarbonCostPerUnit);

        // Link the listener to the submit button
        submitProduct.setOnClickListener(onClickSubmitListener);
    }
}
