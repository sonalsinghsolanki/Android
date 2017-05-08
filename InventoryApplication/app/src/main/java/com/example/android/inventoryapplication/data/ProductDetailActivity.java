package com.example.android.inventoryapplication.data;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.inventoryapplication.R;

import static com.example.android.inventoryapplication.data.InventoryContract.ProductEntry.COLUMN_PRODUCT_QUANTITY;
import static com.example.android.inventoryapplication.data.InventoryContract.ProductEntry.COLUMN_PRODUCT_SOLD_QUANTITY;

/**
 * Created by Ashutosh on 4/27/2017.
 */

public class ProductDetailActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    /** Identifier for the product data loader */
    private static final int EXISTING_PRODUCT_LOADER = 0;

    /** Content URI for the existing product  */
    private Uri mCurrentProductUri;

    /** TextView field for the products name */
    private TextView mNameTextView;

    /** EditText field for the products quantity */
    private EditText mQuantityEditText;

    /** TextView field for the products price */
    private TextView mPriceTextView;

    /** TextView field for the products sold quantity */
    private TextView mSoldQuantityTextView;

    /** Boolean flag that keeps track of whether the product has been edited (true) or not (false) */
    private boolean mProductHasChanged = false;

    /** TextView field for the products supplier name */
    private TextView mSupplierNameTextView;

    /** TextView field for the products supplier email id */
    private TextView mSupplierEmailTextView;

    /**ImageView field for the product Image*/
    private ImageView mProductImageView;

    /**Image Uri for reteriving product image from database*/
    private String mProductImageUri;

    /**
     * OnTouchListener that listens for any user touches on a View, implying that they are modifying
     * the view, and we change the mProductHasChanged boolean to true.
     */
    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mProductHasChanged = true;
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        // Examine the intent that was used to launch this activity,
        // in order to figure out if we're creating a viewing and editing an existing one.
        Intent intent = getIntent();
        mCurrentProductUri = intent.getData();

        // Initialize a loader to read the product data from the database
            // and display the current values in the editor
          getLoaderManager().initLoader(EXISTING_PRODUCT_LOADER, null, this);

        // Find all relevant views that we will need to read user input from
        mNameTextView = (TextView) findViewById(R.id.name);
        mQuantityEditText = (EditText) findViewById(R.id.quantity);
        mPriceTextView = (TextView) findViewById(R.id.price);
        mSoldQuantityTextView = (TextView) findViewById(R.id.sold_quantity);
        mSupplierNameTextView = (TextView) findViewById(R.id.supplier_name);
        mSupplierEmailTextView = (TextView) findViewById(R.id.supplier_emailid);
        mProductImageView =(ImageView)findViewById(R.id.product_image);

        //Sell button click
        Button bt_sale = (Button)findViewById(R.id.bt_sale);
        bt_sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Current quantity
                int currentQuantity = Integer.parseInt(mQuantityEditText.getText().toString());
                int soldQuantity = Integer.parseInt(mSoldQuantityTextView.getText().toString());

                if (currentQuantity > 0) {
                    currentQuantity -= 1;
                    soldQuantity +=1;
                    mQuantityEditText.setText(Integer.toString(currentQuantity));
                    mSoldQuantityTextView.setText(Integer.toString(soldQuantity));

                    ContentValues values = new ContentValues();
                    values.put(COLUMN_PRODUCT_QUANTITY, currentQuantity);
                    values.put(COLUMN_PRODUCT_SOLD_QUANTITY, soldQuantity);
                    int rowsAffected = getContentResolver().update(mCurrentProductUri, values, null, null);
                }else {
                    Toast.makeText(ProductDetailActivity.this, "Quantity is 0 and can't be reduced.", Toast.LENGTH_SHORT).show();

                }

            }
        });

        //Order Product Click
        Button bt_order = (Button)findViewById(R.id.bt_order);
        bt_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get Supplier name
                CharSequence supplierCharSequence =  mSupplierNameTextView.getText();
                String supplier = supplierCharSequence.toString();

                //Get item name
                CharSequence nameCharSequence = mNameTextView.getText();
                String itemName = nameCharSequence.toString();

                //Get Supplier Email id
                String sEmailId = mSupplierEmailTextView.getText().toString();

                //Display the request to the supplier
                String message = createSupplierRequest(supplier,itemName);

                //Use intent to launch email app. send the supplier request in the email body
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {sEmailId});
                intent.putExtra(Intent.EXTRA_SUBJECT,"Reorder Request");
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(intent);
                }
            private String createSupplierRequest(String supplier, String item){
                String emailMessage = "Hello " + supplier + ","
                        + "\n\nIt looks like we are running low on " + item
                        + " and would like to reorder more."
                        + "\nRegards,"
                        +"\nShubham Store Co.";
                return emailMessage;
            }
        });
         Button bt_delete = (Button)findViewById(R.id.bt_delete);
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteConfirmationDialog();
            }
        });

        Button bt_modify_quantity = (Button)findViewById(R.id.bt_update_quantity);
        bt_modify_quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentQuantity = Integer.parseInt(mQuantityEditText.getText().toString());

                ContentValues values = new ContentValues();
                values.put(COLUMN_PRODUCT_QUANTITY, currentQuantity);
                int rowsAffected = getContentResolver().update(mCurrentProductUri, values, null, null);
                if (rowsAffected == 0)
                {
                    Toast.makeText(ProductDetailActivity.this, "Quantity cannot be updated.", Toast.LENGTH_SHORT).show();
                                }else {
                    Toast.makeText(ProductDetailActivity.this, "Quantity updated.", Toast.LENGTH_SHORT).show();
            }


        }
        });
    }


     /**
     * This method is called when the back button is pressed.
     */
    @Override
    public void onBackPressed() {
        // If the product hasn't changed, continue with handling back button press
        if (!mProductHasChanged) {
            super.onBackPressed();
            return;
        }

    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Since the editor shows all product attributes, define a projection that contains
        // all columns from the product table
        String[] projection = {
                InventoryContract.ProductEntry._ID,
                InventoryContract.ProductEntry.COLUMN_PRODUCT_NAME,
                InventoryContract.ProductEntry.COLUMN_PRODUCT_QUANTITY,
                InventoryContract.ProductEntry.COLUMN_PRODUCT_PRICE,
                InventoryContract.ProductEntry.COLUMN_PRODUCT_SOLD_QUANTITY,
                InventoryContract.ProductEntry.COLUMN_PRODUCT_SUPPLIER_NAME,
                InventoryContract.ProductEntry.COLUMN_PRODUCT_SUPPLIER_EMAIL_ADDRESS,
                InventoryContract.ProductEntry.COLUMN_PRODUCT_IMAGE
        };

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                mCurrentProductUri,         // Query the content URI for the current product
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        // Bail early if the cursor is null or there is less than 1 row in the cursor
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        // Proceed with moving to the first row of the cursor and reading data from it
        // (This should be the only row in the cursor)
        if (cursor.moveToFirst()) {
            // Find the columns of product attributes that we're interested in
            int nameColumnIndex = cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_PRODUCT_NAME);
            int quantityColumnIndex = cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_PRODUCT_QUANTITY);
            int priceColumnIndex = cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_PRODUCT_PRICE);
            int soldQuantityColumnIndex = cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_PRODUCT_SOLD_QUANTITY);
            int supplierNameColumnIndex = cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_PRODUCT_SUPPLIER_NAME);
            int supplierNameEmailidColumnIndex = cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_PRODUCT_SUPPLIER_EMAIL_ADDRESS);
            int productImageColumnIndex = cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_PRODUCT_IMAGE);

            // Extract out the value from the Cursor for the given column index
            String name = cursor.getString(nameColumnIndex);
            int quantity = cursor.getInt(quantityColumnIndex);
            int price = cursor.getInt(priceColumnIndex);
            int sold_quantity = cursor.getInt(soldQuantityColumnIndex);
            String supplier_name = cursor.getString(supplierNameColumnIndex);
            String supplier_emailid = cursor.getString(supplierNameEmailidColumnIndex);
            String product_image = cursor.getString(productImageColumnIndex);

            // Update the views on the screen with the values from the database
            mNameTextView.setText(name);
            mQuantityEditText.setText(Integer.toString(quantity));
            mPriceTextView.setText(Integer.toString(price));
            mSoldQuantityTextView.setText(Integer.toString(sold_quantity));
            mSupplierNameTextView.setText(supplier_name);
            mSupplierEmailTextView.setText(supplier_emailid);
            mProductImageView.setImageURI(product_image);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // If the loader is invalidated, clear out all the data from the input fields.
        mNameTextView.setText("");
        mQuantityEditText.setText("");
        mPriceTextView.setText("");
        mSoldQuantityTextView.setText("");
        mSupplierNameTextView.setText("");
        mSupplierEmailTextView.setText("");
    }


    /**
     * Prompt the user to confirm that they want to delete this product.
     */
    private void showDeleteConfirmationDialog() {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the product.
                deleteProduct();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Cancel" button, so dismiss the dialog
                // and continue editing the product.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    /**
     * Perform the deletion of the product in the database.
     */
    private void deleteProduct() {
        // Only perform the delete if this is an existing product.
        if (mCurrentProductUri != null) {
            // Call the ContentResolver to delete the product at the given content URI.
            // Pass in null for the selection and selection args because the mCurrentProductUri
            // content URI already identifies the product that we want.
            int rowsDeleted = getContentResolver().delete(mCurrentProductUri, null, null);

            // Show a toast message depending on whether or not the delete was successful.
            if (rowsDeleted == 0) {
                // If no rows were deleted, then there was an error with the delete.
                Toast.makeText(this, getString(R.string.editor_delete_product_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                // Otherwise, the delete was successful and we can display a toast.
                Toast.makeText(this, getString(R.string.editor_delete_product_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }

        // Close the activity
        finish();
    }
}

