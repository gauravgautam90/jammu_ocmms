
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WorkingDays {

	public static String calDueDate(Date appDate, int Wdays) {

		String dueDate = "";
		Date abc = new Date();
		Date abc1 = new Date();

		abc = appDate;
		SimpleDateFormat s;
		s = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(abc);
		abc1 = calendar1.getTime();
		int days = Wdays;
		for (int i = 0; i < days;) {
			calendar1.add(Calendar.DAY_OF_MONTH, -1);
			if ((calendar1.get(Calendar.DAY_OF_WEEK) > 1)
					&& (calendar1.get(Calendar.DAY_OF_WEEK) <= 6)) {
				i++;
			}

		}

		abc1 = calendar1.getTime();
		dueDate = s.format(abc1);

		return dueDate;
	}

	public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
		System.out.println("startDate-------"+startDate);
		System.out.println("endDate-------"+endDate);
		Calendar startCal = Calendar.getInstance();
	    startCal.setTime(startDate);        

	    Calendar endCal = Calendar.getInstance();
	    endCal.setTime(endDate);

	    int workDays = 0;
	    
	    Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(startDate);
        cal2.setTime(endDate);
	    
        if (cal1.after(cal2)) {
            return 0;
        }

        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
	        return 0;
	    }
	    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
	        startCal.setTime(endDate);
	        endCal.setTime(startDate);
	    }
	    do {
	        startCal.add(Calendar.DAY_OF_MONTH, 1);
	        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	            ++workDays;
	        }
	    } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

	    
	    return workDays;
	}
	
	
	public static String calDueDateUpdate(Date appDate, int Wdays) {

		String dueDate = "";
		Date abc = new Date();
		Date abc1 = new Date();

		abc = appDate;
		SimpleDateFormat s;
		s = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(abc);
		abc1 = calendar1.getTime();
		int days = Wdays;
		for (int i = 0; i < days;) {
			calendar1.add(Calendar.DAY_OF_MONTH, 1);
			if ((calendar1.get(Calendar.DAY_OF_WEEK) > 1)
					&& (calendar1.get(Calendar.DAY_OF_WEEK) <= 6)) {
				i++;
			}

		}

		abc1 = calendar1.getTime();
		dueDate = s.format(abc1);

		return dueDate;
	}

}