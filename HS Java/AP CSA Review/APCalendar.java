public class APCalendar {
    private static boolean isLeapYear (int year){
        
    }

    public static int numberOfLeapYears(int year1, int year2) {
        int leapYears = 0;
        
        for(int i = year1; i <= year2; i++){
            if(isLeapYear(i)){
                leapYears++;
            }
        }
        return leapYears;
    }

    private static int firstDayOfYear(int year){

    }

    private static int dayOfYear(int month, int day, int year){

    }

    public static int dayOfWeek(int month, int day, int year){
        return (dayOfYear(month, day, year) % 7) + firstDayOfYear(year);
    }
}