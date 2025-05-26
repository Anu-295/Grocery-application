package testscript;

import org.testng.annotations.Test;

import pages.CategoryPage;

public class CeateNewCategoryTest extends Base {
  @Test
  public void createNewCategory() {
	  CategoryPage categorypage=new CategoryPage();
	  categorypage.createNewCategory("Alovera");
	  
  }
}
