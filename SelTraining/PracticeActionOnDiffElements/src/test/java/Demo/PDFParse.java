package Demo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PDFParse {


	@Test
	public void start() throws IOException{

		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://www.princexml.com/samples/invoice/invoicesample.pdf");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		URL url = new URL(driver.getCurrentUrl()); 
		BufferedInputStream   fileToParse = new BufferedInputStream (url.openStream());

		//parse()  --  This will parse the stream and populate the COSDocument object. 
		//COSDocument object --  This is the in-memory representation of the PDF document

		PDFParser parser=new PDFParser(fileToParse);
		parser.parse();

		//getPDDocument() -- This will get the PD document that was parsed. When you are done with this document you must call    close() on it to release resources
		//PDFTextStripper() -- This class will take a pdf document and strip out all of the text and ignore the formatting and           such.

		String output=new PDFTextStripper().getText(parser.getPDDocument());
		System.out.println(output);
		parser.getPDDocument().close(); 
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

}
