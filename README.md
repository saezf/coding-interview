# Context

A company rents bikes under following options:

1. Rental by hour, charging $5 per hour

2. Rental by day, charging $20 a day

3. Rental by week, charging $60 a week

4. Family Rental is a promotion that can include from 3 to 5 Rentals (of any type) with a discount of 30% of the total price

# Design

The design is simple and consist in just two classes, an Enum to model all sorts of rentals and a Class to implement the domain logic.  
A cart is responsible for keeping track of rentals and calculate the total amount to be charged for the rentals.
Throughout a Cart is possible to do the following:
+ Add, remove or even update the quantities for any rental
+ Check-in the rental(s), meaning delivering the bikes and it's when the charge starts
+ Check-out the rental(s), meaning returning the bikes and it's when the charge ends
+ Get total amount for all rentals, including discount if applicable

## About charge
Charge starts immediately upon check-in. 
Charge is calculated by day, hour or week, and cannot be fractioned.  
Any rental is charged for the whole period, meaning that when the period is complete charge is incremented by the type (hour, day, week). For instance: 
- Rental by hour: 1 hour and 0 minutes is charged **1 hour**
- Rental by hour: 1 hour and 1 minute is charged **2 hours**
- Rental by day:  1 day and 0 hours is charged **1 day**
- Rental by day : 1 day and 1 hour is charged **2 days**
- Rental by week: 1 week and 0 days is charged **1 week**
- Rental by week: 1 week and 1 day is charged **2 weeks**

# Development practices
Although it is a small project for an interview process. recommended practices have been applied as would be done in a real project. Mainly: 
+ Keep the code as simple as possible, applying KISS principle
+ Refactor whenever is necessary, using DRY principle
+ Focus on the main task, applying YAGNI principle
+ Javadoc to document

# How to run the tests
Unit tests were made using [Junit 4](https://junit.org/junit4). 
Just add junit4 lib to the classpath of the project.  
Follow this [guide](https://github.com/junit-team/junit4/wiki/Getting-started#run-the-test) for detailed instructions.
