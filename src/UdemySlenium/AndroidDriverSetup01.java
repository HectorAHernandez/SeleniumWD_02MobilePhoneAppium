package UdemySlenium;
//  **** This contains the method to return the Android Driver setup. It was created based on 
//  **** this program T21MobilePhoneTesting01.java, so for documentation read there.
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDriverSetup01 {
public static AndroidDriver<AndroidElement> getAndroidDriver() throws MalformedURLException {

	File appFolder = new File("src");  //Using File method to specifiy the folder where the application is stored.
	File appFile = new File(appFolder, "ApiDemos-debug.apk"); //define the application file for theApiDemod-debug.apk API.	
				
	DesiredCapabilities desCapbty = new DesiredCapabilities();  //Define desired capabilities to send to the Appium server.
	desCapbty.setCapability(MobileCapabilityType.DEVICE_NAME, "PhoneGalaxyNexusAPI27");  //Indicate which phone emulator to use
	desCapbty.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath()); //to follow the coding standard we have to use a File METHOD to pass the 
	//desCapbty.setCapability(MobileCapabilityType.APP, "C:\\Eclipse\\work_space\\MobilePhoneAppium\\src\\UdemySlenium\\ApiDemos-debug.apk"); 
				
	AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),desCapbty);
	return androidDriver;      
}
}
