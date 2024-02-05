# CabBookingApp
Its a general cab booking app 
Cab Booking Application

Description:

Implement a cab booking application. Below are the expected features from the system.

Features:
The application allows users to book rides on a route.
Users can register themself.
Driving partner can onboard on the system with the vehicle details
Users can search and select one from multiple available rides on a route with the same source and destination based on the nearest to the user
Requirements:
Application should allow user onboarding.
add_user(user_detail)
Add basic user details
Application should allow Driver onboarding
add_driver(driver_details,vehicle_details,current_location)
This will create an instance of the driver and will mark his current location on the map      
Application should allow the user to find a ride based on the criteria below
find_ride (Username,Source , destination)
It will return a list of available ride 
choose_ride(Username,drive_name)
It will choose the drive name from the list 


Other Notes:
Write a driver class for demo purposes. Which will execute all the commands at one place in the code and have test cases.
Do not use any database or NoSQL store, use in-memory data-structure for now. 
Do not create any UI for the application.
Please prioritize code compilation, execution and completion. 
Work on the expected output first and then add bonus features of your own.

