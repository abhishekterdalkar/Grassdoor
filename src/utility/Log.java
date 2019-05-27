package utility;

import java.util.logging.Logger;

public class Log {
	 private static Logger Log = Logger.getLogger(Log.class.getName());//
	 
	 
	 public static void warn(String message) {
		 Log.warning(message);
	 }

	public static void info(String message) {
		// TODO Auto-generated method stub
		Log.info(message);
		
	}

}
