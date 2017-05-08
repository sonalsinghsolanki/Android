/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.habittrackerapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.habittrackerapplication.data.HabitContract.HabitEntry;
import com.example.android.habittrackerapplication.data.HabitDbHelper;

/**
 * Displays list of pets that were entered and stored in the app.
 */
public class CatalogActivity extends AppCompatActivity {

    /** Database helper that will provide us access to the database */
    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        mDbHelper = new HabitDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    /**
     * Temporary helper method to display information in the onscreen TextView about the state of
     * the habit database.
     */
    private Cursor getDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_DESCRIPTION,
                HabitEntry.COLUMN_HABIT_CATEGORY,
                HabitEntry.COLUMN_HABIT_NO_OF_DAYS
        };


        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                HabitEntry._ID + " ASC";
        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        return cursor;
    }

    private void displayDatabaseInfo(){
        Cursor currentCursor=getDatabaseInfo();

        TextView displayView = (TextView) findViewById(R.id.text_view_habit);

        try {
            // Create a header in the Text View that looks like this:
            //
            // The habits table contains <number of rows in Cursor> habits.
            // _id - name - short descrption - category - no of days
            //
            // In the while loop below, iterate through the rows of the cursor and display
            // the information from each column in this order.
            displayView.setText("The habit table contains " + currentCursor.getCount() + " habits.\n\n");
            displayView.append(HabitEntry._ID + " - " +
                    HabitEntry.COLUMN_HABIT_NAME + " - " +
                    HabitEntry.COLUMN_HABIT_DESCRIPTION + " - " +
                    HabitEntry.COLUMN_HABIT_CATEGORY + " - " +
                    HabitEntry.COLUMN_HABIT_NO_OF_DAYS + "\n");

            // Figure out the index of each column
            int idColumnIndex = currentCursor.getColumnIndex(HabitEntry._ID);
            int nameColumnIndex = currentCursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
            int sDescriptionColumnIndex = currentCursor.getColumnIndex(HabitEntry.COLUMN_HABIT_DESCRIPTION);
            int categoryColumnIndex = currentCursor.getColumnIndex(HabitEntry.COLUMN_HABIT_CATEGORY);
            int daysColumnIndex = currentCursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NO_OF_DAYS);

            // Iterate through all the returned rows in the cursor
            while (currentCursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = currentCursor.getInt(idColumnIndex);
                String currentName = currentCursor.getString(nameColumnIndex);
                String currentDescription = currentCursor.getString(sDescriptionColumnIndex);
                int currentCategory = currentCursor.getInt(categoryColumnIndex);
                int currentDay = currentCursor.getInt(daysColumnIndex);
                // Display the values from each column of the current row in the cursor in the TextView
                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentDescription + " - " +
                        currentCategory + " - " +
                        currentDay));
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            currentCursor.close();
        }
    }

    /**
     * Helper method to insert hardcoded habit data into the database. For debugging purposes only.
     */
    private void insertHabit() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and Toto's habit attributes are the values.
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "Running");
        values.put(HabitEntry.COLUMN_HABIT_DESCRIPTION, "Run 2 miles daily");
        values.put(HabitEntry.COLUMN_HABIT_CATEGORY, HabitEntry.CATEGORY_FITNESS);
        values.put(HabitEntry.COLUMN_HABIT_NO_OF_DAYS, 7);

        // Insert a new row for Running in the database, returning the ID of that new row.
        // The first argument for db.insert() is the pets table name.
        // The second argument provides the name of a column in which the framework
        // can insert NULL in the event that the ContentValues is empty (if
        // this is set to "null", then the framework will not insert a row when
        // there are no values).
        // The third argument is the ContentValues object containing the info for Running.
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);
    }
    private void deleteAllHabits() {

        // Create database helper
        HabitDbHelper mDbHelper = new HabitDbHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Delete all rows from table
        long allRowId = db.delete(HabitEntry.TABLE_NAME, "1", null);

        // Show a toast message depending on whether or not the insertion was successful
        if (allRowId != 0) {
            // If all the rows deleted
            Toast.makeText(this, allRowId+" : of rows deleted for habits", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Error in deletion", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                insertHabit();
                displayDatabaseInfo();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                deleteAllHabits();
                displayDatabaseInfo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}