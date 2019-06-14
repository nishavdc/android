/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;
    int priceOfWippedCream = 1;
    int priceOfChocolte = 2;
    int priceOfOne = 5;
    int maxCups = 10;
    int minCups = 1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        //to check if the user needs wipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.wippedCreamCheckBox);
        boolean hasWippedCream = whippedCreamCheckBox.isChecked();
//        //to check if the user needs Chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolateCheckBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
//        //to get user name
        EditText nameString = (EditText) findViewById(R.id.nameField);
        String nameOfPerson = nameString.getText().toString();
//        //calculates the total price
        int price = calculateprice(hasWippedCream, hasChocolate);
        String priceMessage = createOrderSummery(price, hasWippedCream, hasChocolate, nameOfPerson);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:"));//only email apps will handle this
//        intent.putExtra(Intent.EXTRA_EMAIL, addresses);// to specify the To field
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + nameOfPerson);//subject field
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);//to add text to the body
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * to show the order summery
     *
     * @param nameOfPerson   gives the name of the customer
     * @param hasChocolate   to check whetehr the user needs chocolate topping
     * @param hasWippedCream to check whether the user needs wipped cream
     * @return order summery
     **/
    public String createOrderSummery(int price, boolean hasWippedCream, boolean hasChocolate, String nameOfPerson) {

        String priceMessage = getString(R.string.order_sumery_name,nameOfPerson);
        priceMessage += "\nAdd whipped cream? " + hasWippedCream;
        priceMessage += "\nAdd chocolate? " + hasChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\n"+getString(R.string.thank_you);
        displayMessage(priceMessage);
        return priceMessage;
    }


    /**
     * Calculates the price of the order based on the current quantity.
     **/
    private int calculateprice(boolean hasWippedCream, boolean hasChocolate) {
        if (hasWippedCream && hasChocolate) {
            int price = quantity * (priceOfOne + priceOfChocolte + priceOfWippedCream);
            return price;
        } else if (hasChocolate) {
            int price = quantity * (priceOfOne + priceOfChocolte);
            return price;
        } else if (hasWippedCream) {
            int price = quantity * (priceOfOne + priceOfWippedCream);
            return price;
        } else
            return quantity * priceOfOne;
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        if (quantity < maxCups) {
            quantity = quantity + 1;
        } else {
            Toast.makeText(this, "You cannot have more than than " + maxCups + " coffees", Toast.LENGTH_SHORT).show();

        }
        displayQuantity(quantity);
    }

    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view) {
        if (quantity > minCups) {
            quantity = quantity - 1;
        } else {
            Toast.makeText(this, "You cannot have less than " + minCups + " coffee", Toast.LENGTH_SHORT).show();
        }

        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberofcoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberofcoffees);
    }

//    /**
//     * This method displays the given price on the screen.
//     */
//    private void displayPrice (int number) {
//        TextView orderSummeryTextView = (TextView) findViewById(R.id.order_summery_text_view);
//        orderSummeryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummeryTextView = (TextView) findViewById(R.id.order_summery_text_view);
        /** (TextView) is used to cast view type into TextView type.
         * Because findViewById has a return type of View and we cannot use .setText on View type **/
        orderSummeryTextView.setText(message);
        //orderSummeryTextView.setTextColor(Color.BLUE);

    }
}