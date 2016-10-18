package js.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(SlowTests.class)
public class CategoryTest {
	
	@Test
	public void test() {
		Assert.assertTrue(true);
	}

}
