package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText textCustomerName = (EditText) findViewById(R.id.txt_customer_name);
        String customer_name = textCustomerName.getText().toString();
        CheckBox isAddWhippedCream = (CheckBox) findViewById(R.id.whipped_chkbox);
        boolean hasWhippedCream = isAddWhippedCream.isChecked();
        CheckBox isAddChocolate = (CheckBox) findViewById(R.id.chocolate_chkbox);
        boolean hasChocolate = isAddChocolate.isChecked();

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String orderSummary = createOrderSummary(price,hasWhippedCream,hasChocolate,customer_name);

        String orderSubject = getString(R.string.order_email_subject)+" "+customer_name;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, orderSubject);
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

       // displayMessage(orderSummary);
        }


    /**
     * This method is called when the increment + button is clicked.
     */

    public void submitIncrement(View view) {
        if(quantity == 100) {
            //Show error message as toast
            Toast.makeText(this, getString(R.string.toast_max_limit), Toast.LENGTH_SHORT).show();

            return;
            }
        quantity = quantity + 1;
        displayQuantity(quantity);


    }

    /**
     * This method is called when the decrement - button is clicked.
     */

    public void submitDecrement(View view) {
        if(quantity == 1) {
            //Show error message as toast
            Toast.makeText(this, getString(R.string.toast_min_limit), Toast.LENGTH_SHORT).show();

            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);

    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice(boolean hasWhippedCream,boolean hasChocolate) {
        int price;
        if (hasWhippedCream == true && hasChocolate == true){
            price = (5+1+2)*quantity;
        }else if (hasWhippedCream == true){
            price =  (5+1)* quantity;
        }else if(hasChocolate == true) {
            price = (5+2) * quantity;
        }else{
            price = 5*quantity;
        }

        return price;
    }

    /**
     * Displayed order summary
     */
    private String createOrderSummary(int price,boolean isWhippedCreamAdded,boolean isChocolateAdded,String customerName){

        String orderSummaryMessage = getString(R.string.order_summary_name,customerName);
        orderSummaryMessage = orderSummaryMessage +"\n"+getString(R.string.order_quantity)+": " + quantity;
        orderSummaryMessage = orderSummaryMessage +"\n"+getString(R.string.add_whipped_cream)+"?"+isWhippedCreamAdded;
        orderSummaryMessage = orderSummaryMessage +"\n"+getString(R.string.add_chocolate)+"?"+isChocolateAdded;
        orderSummaryMessage = orderSummaryMessage +"\n"+getString(R.string.order_total)+":"+ NumberFormat.getCurrencyInstance().format(price)+"\n"+getString(R.string.thank_you);

        return orderSummaryMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
   /* private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }*/

}