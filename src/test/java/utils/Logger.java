package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;

public class Logger {
	private static String appName = "SeleniumEasy";
	private static final int STACKTRACE_DEPTH = 4;

	private Logger() {
	}

	private static final class InstanceHolder {
		private static final Logger instance = new Logger();
	}

	public static Logger getInstance() {
		return InstanceHolder.instance;
	}

	public static void logDebug(String message) {
		log(Level.FINER, message);
	}

	public static void info(String message) {
		log(Level.INFO, message);
	}

	public static void logWarning(String message) {
		log(Level.WARNING, message);
	}

	public static void logSevere(Throwable e) {
		log(Level.SEVERE, e.toString());
	}

	private static void log(Level level, String message) {
		DateFormat df = new SimpleDateFormat("hh:mm:ss");
		String currentTime = df.format(Calendar.getInstance().getTime());
		String logMessage = "[" + appName + "]" + "[" + currentTime + "]" + "[" + level + "]" + "["
				+ getCallingClassName(STACKTRACE_DEPTH) + "]" + message;
		System.out.println(logMessage);
	}

	private static String getCallingClassName(int stackLevel) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		if (stackLevel >= stackTrace.length)
			return null;
		String[] className = stackTrace[stackLevel].getClassName().split("\\.");
		String[] methodName = stackTrace[stackLevel].getMethodName().split("\\.");
		return className[className.length - 1] + ":" + methodName[methodName.length - 1];
	}
}