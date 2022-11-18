package com.nighthawk.spring_portfolio.mvc.calendar;

/** Simple POJO 
 * Used to Interface with APCalendar
 * The toString method(s) prepares object for JSON serialization
 * Note... this is NOT an entity, just an abstraction
 */
class Year {
   private int year;
   private boolean isLeapYear;
   private int firstDayOfYear;
   private int numberOfLeapYears;
   private int dayOfYear;
   private int dayOfWeek;

   // zero argument constructor
   public Year() {} 

   /* year getter/setters */
   public int getYear() {
      return year;
   }
   public void setYear(int year) {
      this.year = year;
      this.setIsLeapYear(year);
      this.firstDayOfYear(year);
   }

   /* isLeapYear getter/setters */
   public boolean getIsLeapYear(int year) {
      return APCalendar.isLeapYear(year);
   }
   private void setIsLeapYear(int year) {  // this is private to avoid tampering
      this.isLeapYear = APCalendar.isLeapYear(year);
   }

   /* isLeapYearToString formatted to be mapped to JSON */
   public String isLeapYearToString(){
      return ( "{ \"year\": "  +this.year+  ", " + "\"isLeapYear\": "  +this.isLeapYear+ " }" );
   }	

   public int getfirstDayOfYear(int year) {
      return APCalendar.firstDayOfYear(year);
   }
   public String firstDayOfYearToString () {
      return ( "{ \"year\": "  +this.year+  ", " + "\"firstDayOfYear\": "  +this.firstDayOfYear(year)+ " }" );
   }	

   public int numberOfLeapYears(int year1, int year2) {
      return APCalendar.numberOfLeapYears(year1, year2);
   }

   public void setNumberOfLeapYears(int year1, int year2) {  // this is private to avoid tampering
      this.numberOfLeapYears = APCalendar.numberOfLeapYears(year1, year2);
   }

   /* standard toString placeholder until class is extended */
   public String numberOfLeapYearsToString(){
      return ( "{ \"numberOfLeapYears\": "  + this.numberOfLeapYears + " }" );
   }
   static int dayofyear(int d, int m, int y){
      int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
      if (m < 3)
          y--;
      return (y + y / 4 - y / 100 + y / 400 + t[m - 1]+ d) % 7;
   }
   public int firstDayOfYear(int year) {
      return dayofyear(1, 1, year);
   }

   public void setDayOfYear(int month, int day, int year) {
      this.dayOfYear=APCalendar.dayOfYear(month, day, year);
   }

   public String dayOfYearToString(){
      return ( "{ \"dayOfYear\": "  + this.dayOfYear + " }" );
   }
   public int dayOfWeek(int month, int day, int year) {
      return APCalendar.dayOfWeek(month, day, year);
   }
   public void setDayOfWeek(int month, int day, int year) {  // this is private to avoid tampering
      this.dayOfWeek = APCalendar.dayOfWeek(month, day, year);
   }

   public String dayOfWeekToString(){
      return ( "{ \"dayOfWeek\": "  + this.dayOfWeek + " }" );
   }	
   
   /* standard toString placeholder until class is extended */
   public String toString() { 
      return isLeapYearToString(); 
   }

   public static void main(String[] args) {
      Year year = new Year();
      year.setYear(2022);
      System.out.println(year);
   }
}