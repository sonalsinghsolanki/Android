package com.example.android.inventoryapplication;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.inventoryapplication.data.InventoryContract.ProductEntry;

import static com.example.android.inventoryapplication.data.InventoryContract.ProductEntry.COLUMN_PRODUCT_QUANTITY;

/**
 * {@link InventoryCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of product data as its data source. This adapter knows
 * how to create list items for each row of product data in the {@link Cursor}.
 */
public class InventoryCursorAdapter extends CursorAdapter {

    /**
     * Constructs a new {@link InventoryCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public InventoryCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**
     * This method binds the product data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current product can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView quantityTextView = (TextView) view.findViewById(R.id.quantity);
        TextView priceTextView = (TextView) view.findViewById(R.id.price);

        //Sell button click
        Button sellButton = (Button) view.findViewById(R.id.bt_sold);

        //get the position before the button is clicked
        final int position = cursor.getPosition();
        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("On click","On sell button click");

                //move the cursor to the correct position
                cursor.moveToPosition(position);

                int itemIdColumnIndex = cursor.getColumnIndex(ProductEntry._ID);
                final long itemId = cursor.getLong(itemIdColumnIndex);

                //then use the id to create the Uri
                //get the Uri for the current product
                Uri mCurrentProductUri = ContentUris.withAppendedId(ProductEntry.CONTENT_URI, itemId);

                // Find the columns of phone attributes that we're interested in
                int quantityColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_QUANTITY);

                //read the product attributes from the Cursor for the current product
                String productQuantity = cursor.getString(quantityColumnIndex);

                //convert the string to an integer
                int updateQuantity = Integer.parseInt(productQuantity);

                if (updateQuantity > 0) {
                    //Decrease by 1
                    int mQuantity = updateQuantity- 1;
                    ContentValues values = new ContentValues();
                    values.put(COLUMN_PRODUCT_QUANTITY, mQuantity);
                    int rowsAffected = context.getContentResolver().update(mCurrentProductUri, values, null, null);
                }else{
                    Toast.makeText(context, "Quantity is 0 and can't be reduced.", Toast.LENGTH_SHORT).show();
                }
                }
        });
        // Find the columns of product attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_NAME);
        int quantityColumnIndex = cursor.getColumnIndex(COLUMN_PRODUCT_QUANTITY);
        int priceColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_PRICE);

        // Read the product attributes from the Cursor for the current product
        String productName = cursor.getString(nameColumnIndex);
        Integer productQuantity = cursor.getInt(quantityColumnIndex);
        Integer productPrice = cursor.getInt(priceColumnIndex);


        // Update the TextViews with the attributes for the current product
        nameTextView.setText(productName);
        quantityTextView.setText(Integer.toString(productQuantity));
        priceTextView.setText(Integer.toString(productPrice));
    }
}