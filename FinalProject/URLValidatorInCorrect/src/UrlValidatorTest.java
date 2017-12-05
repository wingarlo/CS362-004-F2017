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

	   
	   
   }
   
   
   public void testYourFirstPartition()
   {
	   System.out.println("\n----------------------------------------------------");
	   System.out.println("Partition 1: Length and character equivalence");
	   System.out.println("----------------------------------------------------");
	   UrlValidator urlVal = new UrlValidator();
	   UrlValidator urlVal1 = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   //length with a
	   System.out.println("Expected: true: "+urlVal.isValid("http://www.a.com"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com"));
	   
	   //length with b
	   System.out.println("Expected: true: "+urlVal.isValid("http://www.b.com"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb.com"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb.com"));
	   //assuming if a results the same as b, we  get the same results for all lower case letters.
	   
	   
}
   
   public void testYourSecondPartition()
   {
	   System.out.println("\n----------------------------------------------------");
	   System.out.println("Partition 2: Fragments");
	   System.out.println("----------------------------------------------------");
	   UrlValidator urlVal = new UrlValidator();
	   UrlValidator urlVal1 = new UrlValidator(UrlValidator.NO_FRAGMENTS);
	   System.out.println("Expected: true: "+urlVal.isValid("http://www.amazon.com/#1"));
	   System.out.println("Expected: true: "+urlVal.isValid("http://www.amazon.com/#10"));
	   System.out.println("Expected: true: "+urlVal.isValid("http://www.amazon.com/#1a"));
	   System.out.println("Expected: true: "+urlVal.isValid("http://www.amazon.com/#a"));
	   System.out.println("Expected: true: "+urlVal.isValid("http://www.amazon.com/#haveyouheardthetragedyofdarthplageousthewise"));
	   System.out.println("Expected: true: "+urlVal.isValid("http://www.amazon.com/#!"));
	   System.out.println("Expected: true: "+urlVal.isValid("http://www.amazon.com/#?"));
	   System.out.println("Expected: true: "+urlVal.isValid("http://www.amazon.com/#@#(*&"));
	   
	   System.out.println("Expected: false: "+urlVal1.isValid("http://www.amazon.com/#1"));
	   System.out.println("Expected: false: "+urlVal1.isValid("http://www.amazon.com/#10"));
	   System.out.println("Expected: false: "+urlVal1.isValid("http://www.amazon.com/#1a"));
	   System.out.println("Expected: false: "+urlVal1.isValid("http://www.amazon.com/#a"));
	   System.out.println("Expected: false: "+urlVal1.isValid("http://www.amazon.com/#haveyouheardthetragedyofdarthplageousthewise"));
	   
   }
   
   public void testYourThirdPartition()
   {
	   System.out.println("\n----------------------------------------------------");
	   System.out.println("Partition 3: Local URLs");
	   System.out.println("----------------------------------------------------");
	   UrlValidator urlVal2 = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
	   System.out.println("Expected: true: "+urlVal2.isValid("http://localhost/"));
	   System.out.println("Expected: true: "+urlVal2.isValid("http://machine/"));
	   System.out.println("Expected: false: "+urlVal2.isValid("http://localhostess/"));
	   System.out.println("Expected: false: "+urlVal2.isValid("http://human/"));
   }
   
   public void testYourFourthPartition()
   {
	   System.out.println("\n----------------------------------------------------");
	   System.out.println("Partition 4: Schemes");
	   System.out.println("----------------------------------------------------");
	   UrlValidator urlVal = new UrlValidator();
	   UrlValidator urlVal1 = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   System.out.println("Expected: true: "+urlVal.isValid("http://www.amazon.com"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com"));
	   System.out.println("Expected: false: "+urlVal.isValid("htp://www.amazon.com"));
	   System.out.println("Expected: false: "+urlVal.isValid("somethingotherthanhttps://www.amazon.com"));
	   
	   //character and length test with all schemes allowed
	   System.out.println("Expected: true: "+urlVal1.isValid("a://www.amazon.com"));
	   System.out.println("Expected: true: "+urlVal1.isValid("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa://www.amazon.com"));
	   System.out.println("Expected: true: "+urlVal1.isValid("b://www.amazon.com"));
	   System.out.println("Expected: true: "+urlVal1.isValid("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb://www.amazon.com"));
	   System.out.println("Expected: true: "+urlVal1.isValid("b12://www.amazon.com"));
	   System.out.println("Expected: true: "+urlVal1.isValid("1b2://www.amazon.com"));
	   
	   //special characters
	   System.out.println("Expected: false: "+urlVal1.isValid("o-o://www.amazon.com"));
	   System.out.println("Expected: false: "+urlVal1.isValid("o@o://www.amazon.com"));
	   System.out.println("Expected: false: "+urlVal1.isValid("b o b://www.amazon.com"));
	   System.out.println("Expected: false: "+urlVal1.isValid("o!://www.amazon.com"));
	   System.out.println("Expected: false: "+urlVal1.isValid("}o://www.amazon.com"));
	   System.out.println("Expected: false: "+urlVal1.isValid("*o://www.amazon.com"));
	   System.out.println("Expected: false: "+urlVal1.isValid("?://www.amazon.com"));
	   
   }
   
   public void testYourFifthPartition()
   {
	   System.out.println("\n----------------------------------------------------");
	   System.out.println("Partition 5: Ports and Paths");
	   System.out.println("----------------------------------------------------");
	   UrlValidator urlVal = new UrlValidator();
	   UrlValidator urlVal1 = new UrlValidator(UrlValidator.ALLOW_2_SLASHES);
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:1/under/there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:11/under/there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:111/under/there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:1111/under/there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:1/under//there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:11/under//there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:111/under//there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:1111/under//there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:8042/under/there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:9999/under/there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:9999999999/under/there"));
	   System.out.println("Expected: false: "+urlVal.isValid("https://www.amazon.com:8000/under//there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com:8000/under/there/under/where/haha/gotcha/what/do/you/mean/gotcha/I/got/you/to/say/underwear/oh/haha/that/is/pretty/funny"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com/under/there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com/under/there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com/under/there"));
	   System.out.println("Expected: false: "+urlVal.isValid("https://www.amazon.com/under//there"));
	   System.out.println("Expected: true: "+urlVal.isValid("https://www.amazon.com/under/there/under/where/haha/gotcha/what/do/you/mean/gotcha/I/got/you/to/say/underwear/oh/haha/that/is/pretty/funny"));
	   System.out.println("Expected: false: "+urlVal.isValid("https://www.amazon.com /under/there"));
	   System.out.println("Expected: false: "+urlVal.isValid("https://www.amazon.com /under /there"));

	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:1/under/there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:11/under/there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:111/under/there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:1111/under/there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:1/under//there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:11/under//there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:111/under//there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:1111/under//there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:8042/under/there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:9999/under/there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:9999999999/under/there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:8000/under//there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com:8000/under/there/under/where/haha/gotcha/what/do/you/mean/gotcha/I/got/you/to/say/underwear/oh/haha/that/is/pretty/funny"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com/under/there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com/under/there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com/under/there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com/under//there"));
	   System.out.println("Expected: true: "+urlVal1.isValid("https://www.amazon.com/under/there/under/where/haha/gotcha/what/do/you/mean/gotcha/I/got/you/to/say/underwear/oh/haha/that/is/pretty/funny"));
	   System.out.println("Expected: false: "+urlVal1.isValid("https://www.amazon.com /under/there"));
	   System.out.println("Expected: false: "+urlVal1.isValid("https://www.amazon.com /under /there"));
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
