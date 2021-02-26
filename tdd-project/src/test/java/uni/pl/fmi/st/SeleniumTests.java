package uni.pl.fmi.st;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import uni.pl.fmi.st.selenium.models.WikipediaPageModel;

public class SeleniumTests {
	WebDriver driver;
	WikipediaPageModel wikipediaPageModel;
	@BeforeClass
	public static void setupClass() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	}
	@Before
	public void setup() {
		driver = new ChromeDriver();
		wikipediaPageModel = new WikipediaPageModel(driver);
	}
	
	
	@Test
	public void checkTabOverviewLabel() {
		wikipediaPageModel.navigateToMain();
		
		final String result = wikipediaPageModel.getOverviewTabText();
		assertEquals("Преглед", result);
		
	
	}
	@Test public void checkSearchResult() {
		wikipediaPageModel.navigateToMain();
		wikipediaPageModel.setSearchValue("ябълка");
		wikipediaPageModel.clickSeachButton();
		
		final String expectedURL = "https://bg.wikipedia.org/wiki/%D0%AF%D0%B1%D1%8A%D0%BB%D0%BA%D0%B0";
		final String result = driver.getCurrentUrl();
		
		assertEquals(expectedURL, result);
		}
	@Test
	public void checkHeaderTextAfterSearch() {
		wikipediaPageModel.navigateToMain();
		wikipediaPageModel.setSearchValue("круша");
		wikipediaPageModel.clickSeachButton();
		
		final String expectedURL = "https://bg.wikipedia.org/wiki/%D0%9A%D1%80%D1%83%D1%88%D0%B0";
		final String result = driver.getCurrentUrl();
		
		assertEquals(expectedURL, result);
		
		WebElement header = wikipediaPageModel.getHeaderElement();
		
		assertEquals("h1", header.getTagName());
		assertEquals("Круша", header.getText());
		}
	@Test
	public void changeLanguage() {
		wikipediaPageModel.navigateToMain();
		wikipediaPageModel.setSearchValue("праскова");
		wikipediaPageModel.clickSeachButton();

		WebElement header = wikipediaPageModel.getSecondHeaderElement();
		
		assertEquals("На други езици", header.getText());

		}
	
	
	
	
	
	
	
	@After
	public void after() {
		driver.close();
		
	}
}
