package com.example.android.reportcardapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ashutosh on 12/26/2016.
 */
public class ReportCardAdapter extends ArrayAdapter<ReportCard> {

    public ReportCardAdapter(Activity context, ArrayList<ReportCard> reportCards) {
        super(context, 0, reportCards);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link ReportCard} object located at this position in the list
        ReportCard currentReportCardObject = getItem(position);

        // Find the Course Name TextView in the list_item.xml layout with the ID course_text_view
        TextView courseNameTextView = (TextView) listItemView.findViewById(R.id.course_text_view);
        // Get the Course name from the current Reportcard object and
        // set this text on the course TextView
        courseNameTextView.setText(currentReportCardObject.toString());

       /* // Find the Marks TextView in the list_item.xml layout with the ID marks_text_view
        TextView marksTextView = (TextView) listItemView.findViewById(R.id.marks_text_view);
        // Get the marks from the current Report card object and
        // set this text on the marks TextView

        double marks = currentReportCardObject.getCourseMarks();
        marksTextView.setText(Double.toString(marks));

        // Find the Grades TextView in the list_item.xml layout with the ID grades_text_view
        TextView gradesTextView = (TextView) listItemView.findViewById(R.id.grades_text_view);
        // Get the grades from the current Report card object and
        // set this text on the grades TextView
        gradesTextView.setText(currentReportCardObject.getCourseGrades());

        // Find the Credits TextView in the list_item.xml layout with the ID credit_text_view
        TextView creditsTextView = (TextView) listItemView.findViewById(R.id.credits_text_view);
        // Get the credits from the current Report card object and
        // set this text on the credits TextView
        double credits = currentReportCardObject.getCourseCredits();
        creditsTextView.setText(Double.toString(credits));
*/
        return listItemView;


    }
}
