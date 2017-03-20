package com.example.android.habittrackerapplication.data;

import android.provider.BaseColumns;

/**
 * API Contract for the habits app.
 */
public final class HabitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract() {}

    /**
     * Inner class that defines constant values for the habits database table.
     * Each entry in the table represents a single habit.
     */
    public static final class HabitEntry implements BaseColumns {

        /** Name of database table for habits */
        public final static String TABLE_NAME = "habits";

        /**
         * Unique ID number for the habit (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the habit.
         *
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_NAME ="name";

        /**
         * Short Description of the habit.
         *
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_DESCRIPTION = "description";

        /**
         * Category of the habit.
         *
         * The only possible values are {@link #CATEGORY_UNKNOWN}, {@link #CATEGORY_FITNESS},
         * {@link #CATEGORY_SELFIMPROVEMENT or{@link #CATEGORY_EATING}.

         *
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_CATEGORY = "category";

        /**
         * Days to complete a habit.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_HABIT_NO_OF_DAYS = "days";

        /**
         * Possible values for the category of the habit.
         */
        public static final int CATEGORY_UNKNOWN = 0;
        public static final int CATEGORY_FITNESS = 1;
        public static final int CATEGORY_SELFIMPROVEMENT = 2;
        public static final int CATEGORY_EATING = 3;
    }

}