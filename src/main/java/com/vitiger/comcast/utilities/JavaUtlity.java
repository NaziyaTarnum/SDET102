package com.vitiger.comcast.utilities;

import java.util.Random;

/**
 * this class contains java specific  libraries
 * @author Naziya
 *
 */

public class JavaUtlity {
	/**
	 * This method used to generate the integer Random number with in the boundary of 0 to 1000
	 * @return
	 */
	public int getRandomnumber()
	{
		Random random=new Random();
	 int randomnum=random.nextInt(1000);
	 return randomnum;
	}
	
	
	

}
