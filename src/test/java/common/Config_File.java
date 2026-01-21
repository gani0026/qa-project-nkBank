package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Config_File {
	public Properties prop;
	public File fe;
	public String properiesOf(String propeties) throws Exception {

		String systemPath=System.getProperty("user.dir");
		
		String filePath="\\src\\main\\resources\\config.properties";
		fe = new File(systemPath+filePath);
		FileInputStream file=new FileInputStream(fe);
		prop= new Properties();
		prop.load(file);
		String str=		 prop.getProperty(propeties);

		return str;

	}

}
