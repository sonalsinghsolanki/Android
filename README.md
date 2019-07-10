# Android
All the projects completed for Udacity Android Nano Degree

1.Booklisting project display lists of books based on search entered by user.This projects uses loaders to load data  asynchronously to an activity,network connection using HttpUrlConnection class to connect to internet and get JSON response which is further stored in book objects using JSON objects.Search string is used as https://www.googleapis.com/books/v1/volumes?q=".

2.Court Counter Master project uses onclick event of button in xml file to update UI.

3.HappyBirthday. is a app featuring Text on Image while Image is placed on full screen using Imageview property android:scaleType="centerCrop" and Textview is placed on upper right corner as well as lower left corner using property as android:layout_alignParentBottom="true"
android:layout_alignParentRight="true" while viewgroup is Relative layout.

4.HabitTrackerApplication is an application for user to record a habit that he or she needs to develop ,mentioning category to which it belongs to as well as number of days required for user to complete the same.This app uses concepts of SQL DB creation using helper classes defined, a separate class file defined for database structure ,use of deletion and addition of habits using SQL functions ,use of spinner with adapter to display categories of habits, display of habit added using textviews and view groups while addition and saving of new habits in database.This app also used menu options to add dummy data and delete habits in bulk.

5.IndoreCityTourApp is an app giving information	about a city named Indore in Madhya Pradesh.App uses concept of Intents to show different activity on click event of a button.
List of places in a particular activity uses array lists to store data in array, uses adapter and list view to display contents of array lists as per layout defined for listview.

6.InventoryApplication:This app is used to add ,delete ,update and display products in an store. Uses loaders(deprecated from API 28) to load data on separate thread to avoid unresponsive	behavior of an activity if loaded directly in activity.Uses concept of Content Provider manages access to a central repository of data by itself, stored by other apps, and provide a way to share data with other apps.They encapsulate the data, and provide mechanisms for defining data security. 

7.JustJava:This app is an ordering app which takes order from customer and on submit send a. Confirmation email to customer for order placed with order details.App uses concept of Intent wherein action mentioned as a parameter for intent uses appropriate installed app to perform further action like email services of gmail or ask user to install appropriate apps to support further action.
