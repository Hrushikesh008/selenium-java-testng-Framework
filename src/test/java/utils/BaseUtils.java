package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import config.ConstantFile;

public class BaseUtils implements ConstantFile {
	File file;
	Document doc;
	Properties p = new Properties();
	private String value;
	private final String CSV_File_Path = "src/test/resources/SeleniumEasyFormInputData.csv";

	public void readfromxml() {
		file = new File(System.getProperty("user.dir") + "/src/test/java/config/properties.xml");
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read(file);
		} catch (DocumentException e) {
			System.out.println("DocumentException caught in readfromxml" + e.getMessage());
		}
	}

	public String retrirvrXmlValue(String element) {
		return doc.selectSingleNode("//seleniumeasyapp/" + element).getText();
	}

	public String CSVReader(String Header) throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get(CSV_File_Path));
		@SuppressWarnings({ "deprecation", "resource" })
		CSVParser csvParser = new CSVParser(reader,
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
		for (CSVRecord csvRecord : csvParser) {
			value = csvRecord.get(Header);
		}
		return value;
	}

	public Properties getProperties() {
		try {
			File file = new File("src/test/resources/testData.properties");
			FileReader reader = new FileReader(file);
			((Properties) p).load(reader);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return p;
	}
}
