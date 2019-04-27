package UdemySlenium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
    
// this is an example of Mobile Phone Application testing.
// following section 15, lecture # 111 I was to configure a virtual phone to be used for our testing.
// In the Android Studio IDE, I have configured an AVD (Android Virtual Device) for a mobile phone with name: 
// HectorVirtualPhone01. To turn on this mobile phone, without using the Android Studio IDE software:
// 1- Open a DOS (cmd) session.
// 2- CD C:\Users\ssshh\AppData\Local\Android\Sdk\platform-tools
// 3- Issue command: emulator -avd EmulatorHectorVirtualPhone01
// 2- CD C:\Users\ssshh\AppData\Local\Android\Sdk\emulator      //this directory runs both phone.
// 3                  emulator -avd PhoneGalaxyNexusAPI27
 
// In another CMD session: To install the appium server, because we have already installed Node.js software, we can us the npm command:
// 4- npm install -g appium       Note: IF I need to UNINSTALL appium, this is the command: npm uninstall -g appium
// to start the appium server issue command:
// 5- c:\appium
// this confirmation is displayed:
// 		Welcome to Appium v1.8.1
// 		[Appium] Appium REST http interface listener started on 0.0.0.0:4723
//     
//   to configure appium Client for front-end execution:
//   to download the appium client
// 6- Google "download appium"
// 7- click on link "Downloads - Appium: Mobile App Automation Made Awesome."
// 8- click on the jar link for the most recent version
// 9- Save and execute.   
///

public class T21MobilePhoneTesting01 {

public static void main(String[] args) throws MalformedURLException {
// TO start working with a Mobile Phone application, first we have to:
// 1- Make sure that the Phone emulator is running 
//       - CD C:\Users\ssshh\AppData\Local\Android\Sdk\platform-tools
//       - Issue command: emulator -avd EmulatorHectorVirtualPhone01
// 2- Make sure that the Appium server is up and running: 
//       - c:\appium    (this command trigger the appium server)
// 3- Instantate the DesiredCapablities Class in order to be able to send the emulator information and application to run, to the 
//    Appium server              
// 
	   // below start setting the app information, to locate the api. this code is the same for all application, only adapting parameters
	    File appFolder = new File("src");  //Using File method to specifiy the folder where the application is stored.
		File appFile = new File(appFolder, "ApiDemos-debug.apk"); //define the application file for theApiDemod-debug.apk API.	
				
		DesiredCapabilities desCapbty = new DesiredCapabilities();  //Define desired capabilities to send to the Appium server.
		desCapbty.setCapability(MobileCapabilityType.DEVICE_NAME, "PhonePixelXLAPI28");  //Indicate which phone emulator to use
		//desCapbty.setCapability(MobileCapabilityType.APP, "C:\\Eclipse\\work_space\\MobilePhoneAppium\\src\\UdemySlenium\\ApiDemos-debug.apk"); //to follow the coding standard we have to use a File METHOD to pass the
		desCapbty.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath()); //to follow the coding standard we have to use a File METHOD to pass the 
		                                  //value of the FILE containing the application we want to install and invoke. to get the path, once
		    // we have placed the application in the src directory of the package, (right click it and go to property and copy it from
		    // resource location.) from line 46 we insert the second parameter of this desired capability: appFile.getAbsolutePath(), to get
		    // the absolute path where the API is stored.
        // to send the connection to the Appium server we need to create and invoke an Android Driver class. desCapbty contains all the
		// information to connect to the Appium server, so we can use it in the second parameter of the definition of the androidDriver.
		//AndroidDriver andDriver = new AndroidDriver(connection To Appium Server's link, desCapbty); as follow:
		AndroidDriver<AndroidElement> andDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),desCapbty);
		//andDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 
}

}
