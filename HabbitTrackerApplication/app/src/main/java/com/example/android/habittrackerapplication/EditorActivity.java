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
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.habittrackerapplication.data.HabitDbHelper;
import com.example.android.habittrackerapplication.data.HabitContract.HabitEntry;

/**
 * Allows user to create a new habit or edit an existing one.
 */
public class EditorActivity extends AppCompatActivity {

    /** EditText field to enter the habit's name */
    private EditText mNameEditText;

    /** EditText field to enter the habit's short description */
    private EditText mShortDescriptionEditText;

    /** EditText field to enter the habit's days to complete */
    private EditText mDaysToCompleteEditText;

    /** EditText field to enter the habit's category */
    private Spinner mHabitCategorySpinner;

    /**
     * Category of the habit. The possible valid values are in the HabitContract.java file:
     * {@link HabitEntry#CATEGORY_UNKNOWN}, {@link HabitEntry#CATEGORY_FITNESS},{@link HabitEntry#CATEGORY_SELFIMPROVEMENT or
     * {@link HabitEntry#CATEGORY_EATING}.
     */
    private int mCategory = HabitEntry.CATEGORY_UNKNOWN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all relevant views that we will need to read user input from
        mNameEditText = (EditText) findViewById(R.id.edit_habit_name);
        mShortDescriptionEditText = (EditText) findViewById(R.id.edit_habit_description);
        mDaysToCompleteEditText = (EditText) findViewById(R.id.edit_habit_days);
        mHabitCategorySpinner = (Spinner) findViewById(R.id.spinner_habit_category);

        setupSpinner();
    }

    /**
     * Setup the dropdown spinner that allows the user to select the category of the habit.
     */
    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter categorySpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_category_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        categorySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mHabitCategorySpinner.setAdapter(categorySpinnerAdapter);

        // Set the integer mSelected to the constant values
        mHabitCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.habit_category_fitness))) {
                        mCategory = HabitEntry.CATEGORY_FITNESS;
                    } else if (selection.equals(getString(R.string.habit_category_unknown))) {
                        mCategory = HabitEntry.CATEGORY_UNKNOWN;
                    }else if (selection.equals(getString(R.string.habit_category_eating))) {
                        mCategory = HabitEntry.CATEGORY_EATING;
                    } else {
                        mCategory = HabitEntry.CATEGORY_SELFIMPROVEMENT;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mCategory = HabitEntry.CATEGORY_UNKNOWN;
            }
        });
    }

    /**
     * Get user input from editor and save new habit into database.
     */
    private void insertHabit() {
        // Read from input fields
        // Use trim to eliminate leading or trailing white space
        String nameString = mNameEditText.getText().toString().trim();
        String descriptionString = mShortDescriptionEditText.getText().toString().trim();
        String daysString = mDaysToCompleteEditText.getText().toString().trim();
        int days = Integer.parseInt(daysString);

        // Create database helper
        HabitDbHelper mDbHelper = new HabitDbHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and habit attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, nameString);
        values.put(HabitEntry.COLUMN_HABIT_DESCRIPTION, descriptionString);
        values.put(HabitEntry.COLUMN_HABIT_CATEGORY, mCategory);
        values.put(HabitEntry.COLUMN_HABIT_NO_OF_DAYS, days);

        // Insert a new row for habit in the database, returning the ID of that new row.
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving habit", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save pet to database
                insertHabit();
                // Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Delte all rows
                //do nothing

                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}