package com.nighthawk.spring_portfolio.mvc.calendar;

// Prototype Implementation

public class APCalendar {

    /** Returns true if year is a leap year and false otherwise.
     * isLeapYear(2019) returns False
     * isLeapYear(2016) returns True
     */          
    public static boolean isLeapYear(int year) {

        if ( (year % 4 == 0) && (year % 100 != 0)){
            return true;
        }
        else if ( year % 400 == 0 ){
            return true;
        }
        else {
            return false;
        }
        }
     
        
    /** Returns the value representing the day of the week 
     * 0 denotes Sunday, 
     * 1 denotes Monday, ..., 
     * 6 denotes Saturday. 
     * firstDayOfYear(2019) returns 2 for Tuesday.
    */
    public static int firstDayOfYear(int year) {
        // implementation not shown
        // Date currentDate = new Date(year-1900, 0, 1);
        // return currentDate.getDay();
        return 0;
    }
    /** Returns n, where month, day, and year specify the nth day of the year.
     * This method accounts for whether year is a leap year. 
     * dayOfYear(1, 1, 2019) return 1
     * dayOfYear(3, 1, 2017) returns 60, since 2017 is not a leap year
     * dayOfYear(3, 1, 2016) returns 61, since 2016 is a leap year. 
    */ 
    public static int dayOfYear(int month, int day, int year) {
        return (int) (Math.random() * (366 - 1)) + 1;
        }
    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
    */ 
    public static int numberOfLeapYears(int year1, int year2) {
        // to be implemented in part (a)
        int count = 0;
        for (int i = year1; i <= year2; i++) {
            if (isLeapYear(i)) {
                count++;
            }
        }
        return count;
    }

    /** Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year) { 
        // to be implemented in part (b)
        int day_of_the_year = dayOfYear(month, day, year);
        int remainder = day_of_the_year % 7;
        int first_day = firstDayOfYear(year);
        return first_day + remainder - 1;
        }


        

    /** Tester method */
    public static void main(String[] args) {
        // Private access modifiers
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(0001));
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(1, 1, 2022));

        // Public access modifiers
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(2022));
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(2000, 2022));
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(1, 1, 2022));
    }

}