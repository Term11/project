package bwf.teaching.book.web.tool;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Tool {

	public static String getRandFileName(String fix) {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + fix;
	}
	
}
