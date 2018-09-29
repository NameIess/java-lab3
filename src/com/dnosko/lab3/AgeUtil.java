package com.dnosko.lab3;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AgeUtil {
    private static final int DAYS_IN_MONTH = 30;
    private static final int DAYS_IN_WEEK = 7;
    private static final int DAYS_IN_YEAR = 365;
    private static final int PREVIOUS = 1;
    public static final String AGE_IN_YEARS = "ageInYears";
    public static final String AGE_IN_MONTHS = "ageInMonths";
    public static final String AGE_IN_DAYS = "ageInDays";
    public static final String AGE_IN_WEEKS = "ageInWeeks";

    public static Map<String, Number> countAge(int birthYear, int birthMonth, int birthDay) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentDayOfYear = currentDate.getDayOfYear();
        int currentDayOfMonth = currentDate.getDayOfMonth();
        int currentMonth = currentDate.getMonthValue();
        isBirthday(currentDayOfMonth, currentMonth, birthDay, birthMonth);

        int ageInDays = ageInDays(currentDayOfYear, currentYear, birthYear, birthMonth, birthDay);
        double ageInMonth = ageInMonths(ageInDays);
        double ageInYears = ageInYears(ageInDays);
        double ageInWeeks = ageInWeeks(ageInDays);

        Map<String, Number> ageData = new HashMap<>();
        ageData.put(AGE_IN_YEARS, ageInYears);
        ageData.put(AGE_IN_MONTHS, ageInMonth);
        ageData.put(AGE_IN_DAYS, ageInDays);
        ageData.put(AGE_IN_WEEKS, ageInWeeks);



        return ageData;
    }

    public static String getInfo (Map<String, Number> ageData){
        return "Your age is: \n" +
                ageData.get(AGE_IN_YEARS) + " years\n"
                + ageData.get(AGE_IN_MONTHS) + " months\n"
                + ageData.get(AGE_IN_DAYS) + " days\n"
                + ageData.get(AGE_IN_WEEKS) + " weeks\n";
    }

    private static double ageInYears(double ageInDays) {
        return ageInDays / DAYS_IN_YEAR;
    }

    private static double ageInMonths(double ageInDays) {

        return ageInDays / DAYS_IN_MONTH;
    }

    private static int ageInDays(int currentDayOfYear, int currentYear, int birthYear,  int birthMonth, int birthDay) {
        int allDays = (currentYear - PREVIOUS) * DAYS_IN_YEAR + currentDayOfYear;
        int daysBeforeBirth = (birthYear - PREVIOUS) * DAYS_IN_YEAR + (birthMonth - PREVIOUS) * DAYS_IN_MONTH + birthDay;
        return allDays - daysBeforeBirth;
}

    private static double ageInWeeks(double ageInDays) {
        return ageInDays / DAYS_IN_WEEK;
    }

    private static void isBirthday(int currentDayOfMonth, int currentMonth, int birthDay, int birthMonth){

        if(currentDayOfMonth == birthDay && currentMonth == birthMonth){
            System.out.println("HAPPY BIRTHDAY TO YOU, BITCH!");
        }

    }

}
