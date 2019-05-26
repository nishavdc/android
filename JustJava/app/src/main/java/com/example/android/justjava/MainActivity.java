/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
//    int PriceOfOne=10;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price=calculateprice();
        createOrderSummery(price);
    }

    /**to show the order summery**/
    public String createOrderSummery(int price)
    {

        String priceMessage= "Name=Nisha \nQuantity: "+quantity+"\nTotal:$ "+(price) + "\nThank You!";
        displayMessage(priceMessage);
        return priceMessage;
    }


    /**Calculates the price of the order based on the current quantity.**/
    private int calculateprice()
    {
        int price=quantity *5 ;
        return price;
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
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
    private void displayMessage(String message)
    {
        TextView orderSummeryTextView = (TextView) findViewById(R.id.order_summery_text_view);
        /** (TextView) is used to cast view type into TextView type.
         * Because findViewById has a return type of View and we cannot use .setText on View type **/
        orderSummeryTextView.setText(message);
        //orderSummeryTextView.setTextColor(Color.BLUE);

    }
}