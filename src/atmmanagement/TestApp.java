package atmmanagement;

import java.util.*;
import java.text.*;

public class TestApp {

	public static void main(String[] args) {

		Random ran = new Random();
		
//		System.out.println(Math.abs(ran.nextLong(100000000000L, 999999999999L)));
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss aaa");
		String d = sdf.format(date);
		System.out.println(d);

	}

}
