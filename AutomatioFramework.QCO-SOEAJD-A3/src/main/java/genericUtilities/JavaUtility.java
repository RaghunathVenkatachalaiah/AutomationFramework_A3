package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class Consists fo generic method related to java
 * @author Raghunath
 */
public class JavaUtility {

	/**
	 * This method will generate syste date in a give format
	 * @return 
	 * @return
	 */
	public String getDate()
	{
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String date = f.format(d);
		return date;
	}
}
