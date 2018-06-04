package Demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ExportCSV {
	WebDriver driver;

	private static String downloadPath = "C:\\Users\\donthaka\\Downloads";
	private String URL="http://www.seleniumeasy.com/test/table-data-download-demo.html"; 



	@Test
	public void testExportAllRecords() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(URL);
		int noOfEntries = getNumberOfEntries();
		System.out.println("Total number of entries are :- "+noOfEntries);

		WebElement elementCSV = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/a[2]"));
		elementCSV.click();

		File file = getLatestFilefromDir(downloadPath);
		String csvFileName = file.getName();
		System.out.println("CSV File Downloaded is :- "+csvFileName);

		System.out.println("Verifying number of entries with number of entries in csv");
		Assert.assertEquals(noOfEntries, getRecordsCountInCSV(downloadPath,csvFileName));
	}

	public int getNumberOfEntries() {

		String entriesTxt = driver.findElement(By.id("example_info")).getText().trim();
		String[] aEntriesText = entriesTxt.split(" ");
		String totalEntriesText = aEntriesText[aEntriesText.length-2];
		return Integer.parseInt(totalEntriesText);
	}

	public int getRecordsCountInCSV(String downloadPath, String csvFileName) {
		int lineNumberCount = 0;
		try {
			if (!csvFileName.isEmpty() || csvFileName != null) {
				String filePath =	downloadPath + System.getProperty("file.separator") + csvFileName;
				System.out.println(filePath);
				File file = new File(filePath);
				if (file.exists()) {
					System.out.println("File found :" +csvFileName);
					FileReader fr = new FileReader(file);
					LineNumberReader linenumberreader = new LineNumberReader(fr);
					while (linenumberreader.readLine() != null) {
						lineNumberCount++;
					}
					//To remove the header
					lineNumberCount=lineNumberCount-1;
					System.out.println("Total number of lines found in csv : " + (lineNumberCount));
					linenumberreader.close();
				} else {
					System.out.println("File does not exists");
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return lineNumberCount;
	}

	private File getLatestFilefromDir(String dirPath){
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
		
		}
		return lastModifiedFile;
	}
}



