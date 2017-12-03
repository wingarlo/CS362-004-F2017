/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println(urlVal.isValid("http://www.amazon.com"));
	   
	   
   }
   
   
   public void testYourFirstPartition()
   {
	   UrlValidator urlVal = new UrlValidator();
	   UrlValidator urlVal1 = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   UrlValidator urlVal2 = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
	   UrlValidator urlVal3 = new UrlValidator(UrlValidator.NO_FRAGMENTS);
	   System.out.println("First partition 1: "+urlVal.isValid("http://www.amazon.com"));
	   System.out.println("First partition 2: "+urlVal.isValid("https://www.amazon.com"));
	   System.out.println("First partition 3: "+urlVal1.isValid("any://www.amazon.com"));
	   System.out.println("First partition 4: "+urlVal1.isValid("andall://www.amazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazon.com"));
	   System.out.println("First partition 5: "+urlVal1.isValid("1ag://www.amazon.com"));
	   System.out.println("First partition 6: "+urlVal2.isValid("http://localhost/"));
	   System.out.println("First partition 7: "+urlVal2.isValid("http://machine/"));
	   System.out.println("First partition 8: "+urlVal3.isValid("http://www.amazon.com"));
   }
   
   public void testYourSecondPartition()
   {
	   UrlValidator urlVal = new UrlValidator();
	   UrlValidator urlVal1 = new UrlValidator(UrlValidator.NO_FRAGMENTS);
	   UrlValidator urlVal2 = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
	   UrlValidator urlVal3 = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println("Second partition 1: "+urlVal.isValid("abc://www.amazon.com"));
	   System.out.println("Second partition 2: "+urlVal.isValid("o-o://www.amazon.com"));
	   System.out.println("Second partition 3: "+urlVal1.isValid("http://www.amazon.com/#1"));
	   System.out.println("Second partition 4: "+urlVal1.isValid("http://www.amazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazonamazon.com/#1"));
	   System.out.println("Second partition 5: "+urlVal2.isValid("http://localhostess/"));
	   System.out.println("Second partition 6: "+urlVal3.isValid("o@o://www.amazon.com"));
	   System.out.println("Second partition 7: "+urlVal3.isValid("o-o://www.amazon.com"));
   }
   
   
   public void testIsValid()
   {
	   for(int i = 0;i<10000;i++)
	   {
		   
	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}
