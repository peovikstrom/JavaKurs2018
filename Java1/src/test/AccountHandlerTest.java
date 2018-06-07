package test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountHandlerTest {
	
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void testShouldReturnTrue() {
		int a = 1;
		int b = 2;
		int c = a + b;
		
		Assert.assertTrue(c == 3);
	}
}
