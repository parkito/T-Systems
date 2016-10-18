package js.junit;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
@SuiteClasses( { CategoryTest.class, CategoryTest1.class})
public class CategorySuite {

}
