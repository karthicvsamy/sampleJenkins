package executions.Testyantra.practice;

import org.testng.annotations.Test;

import com.alphaShoppee.adminModule.DataProviderClass;

public class TestClass1 {

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "provideData")
	public void method1(Object o1, Object o2) {
		
		System.out.println(o1+" "+o2);
	}
	
//	@Test
	public void method2() {
		System.out.println("Method 2 Test 1");
	}
	
//	@Test
	public void method3() {
		System.out.println("Method 2 Test 1");
	}
}
