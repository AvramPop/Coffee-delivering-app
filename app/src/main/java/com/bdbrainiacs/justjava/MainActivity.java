package com.bdbrainiacs.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.weep_cream_checkbox);
        boolean mHasWhippedCream =whippedCreamCheckBox.isChecked();

        int price = calculatePrice();
        String message = createOrderSummary(price, mHasWhippedCream);
        displaySummary(message);
        Log.v("MainActivity", message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displaySummary(String text) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(text);
    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0) {
            quantity--;
        }
        display(quantity);
    }

    private int calculatePrice(){
        return quantity * 5;
    }

    private String createOrderSummary(int price, boolean hasWhippedCream){
        String message = "Name: Dani" + "\n" + (hasWhippedCream ? "With Whipped Cream" : "Without Whipped Cream") + "\nQuantity:" + quantity + "\nTotal: $" + price + "\nThank You!";
        return message;
    }
}