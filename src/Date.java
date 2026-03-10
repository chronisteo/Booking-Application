import java.io.Serializable;

/**
 * class that represents a specific date(day/month/year)
 */

public class Date implements Serializable {
    private final int day;
    private final int month;
    private final int year;

    /**
     * constructor that gets as parameters day,month and year
     * @param day specific day
     * @param month specific month
     * @param year specific year
     */

    public Date(int day, int month, int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }


    /**
     * method that gets the day of the date
     * @return day
     */

    public int getDay() {
        return day;
    }

    /**
     * method that gets the month of the date
     * @return month
     */

    public int getMonth() {
        return month;
    }

    /**
     * method that gets the year of the date
     * @return year
     */

    public int getYear() {
        return year;
    }

    /**
     * method that prints the date
     */

    public void show(){
        System.out.print(day+"/"+month+"/"+year);
    }

    /**
     * method that checks if two dates are equal
     * @param d second date
     * @return true if the two dates are equal,otherwise false
     */

    public boolean isEquals(Date d){
        return (day==d.getDay() && month==d.getMonth() && year==d.getYear());
    }

    /**
     * method that checks if first date is lessThan second date
     * @param d second date
     * @return true if first date is lessThan second,otherwise false
     */

    public boolean lessThan(Date d){
        if(year<d.year)
            return true;
        else if(year>d.year)
            return false;
        else{
            if(month<d.month)
                return true;
            else if(month>d.month)
                return false;
            else
                if(day<d.day)
                    return true;
                else if(day>d.day)
                    return false;
                else
                    return false;
        }

    }

    /**
     * method that checks if first date is moreThan second date
     * @param d second date
     * @return true if first date is moreThan second,otherwise false
     */

    public boolean moreThan(Date d){
        if(lessThan(d))
            return false;
        return !isEquals(d);
    }

    /**
     *
     * @return string of the date
     */

    public String toString(){
        return day+"/"+month+"/"+year;
    }
}























