package Project1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


//	                LockedMeApplication                         
//	 LockedMeApplicationFull is a File Handling Utility                 	
//	*****************************************************************	
//	 Created by: Ahmed Mouaki Benani Chebihat                        
//	 Current version: 1.0                                            
//	 Email: amouaki@gmail.com                                        
//	 Mobile: +966-59-301-3177                                        
//	 Phase-1 Project                                                 
//	                                                                 
//	 LockedMeApplicationFull Usage:                                 
//	 ----------------------------------------------                                 
//	 Tasks are selected by entering Integer numbers                        
//	                                                                 
//	 Application Name: LockedMeApplicationFull

// The Following are all the methods used in this application:
// ===========================================================
// welcomeScreen()
// MainMenuOptions()
// subMenuOptions()
// mainMenuTaskManager(int userSelectedOption)
// subMenuTaskManager(int userSelectedOption)
// directoryDisplayAscending()
// addFile()
// deleteFile()
// searchFile()
//
//

// ===================   START OF THE MAIN APPLICATION  ==============================================
public class LockedMeApplicationFull {

	public static void main(String[] args) {		
		
		int userSelectedOption = -1; 
		Scanner scan = new Scanner(System.in);
		
		// invoking the Welcome Screen
		welcomeScreen();
		
		// invoking the Main Menu
		MainMenuOptions();
		
	//____________________________________________________ 
	//   ENSURE THE USER HAS ENTERED A VALID INTEGER [0-2]	
	//____________________________________________________ 
		do {
			if ( scan.hasNextInt() ) // Checks whether the user has entered an Integer 
			{
					int scanSelectedNum = scan.nextInt();
					
					if ( (scanSelectedNum >= 0 && scanSelectedNum <= 2) ) // ensures that the entered integer is within the required range 
					{
						userSelectedOption = scanSelectedNum;
					} else // in case the user enters an out of range integer value
					{	
						System.out.println("*****     ERROR MESSAGE                   *****");
						System.out.println(" SELECTED INTEGER OPTION IS OUT OF RANGE....!!!");
						System.out.println("-----------------------------------------------");
						userSelectedOption = -999;
						MainMenuOptions();
					}		
			} else { // in case the user enters a non integer value
				System.out.println("*****     ERROR MESSAGE         *****");
				System.out.println(" INVALID OPTION SELECTED...!!!       ");
				System.out.println("-------------------------------------");
				MainMenuOptions();
				userSelectedOption = -999;
				scan.next();
			}
			mainMenuTaskManager(userSelectedOption);
			
		} while( userSelectedOption != 0);  // Ensures that the program will stay running, until the user enters "0" value
		
	}//main
	
// ===================   END OF THE MAIN APPLICATION   ==============================================	
	

	
	
//===========================================================================================
//***************************     BEGINING OF FILE UITILITIES     ***************************	
//===========================================================================================

	
	//=============================================================================================
	/// welcomeScreen(): Display the Application Welcome Screen Message    		
	//=============================================================================================	
		
	public static void welcomeScreen() {
				
	   Scanner scanner = new Scanner(System.in);
	   String temp;
		
	   System.out.print("*****************************************************************\n"+
				 		"                LockedMe.com Application                         \n"+
				 		" LockedMeApplication is a File Handling application Utility      \n"+	
				 		"*****************************************************************\n"+	
				 		" Created by: Ahmed Mouaki Benani Chebihat                        \n"+
				 		" Current version: 1.0                                            \n"+
				 		" Email: amouaki@gmail.com                                        \n"+
				 		" Mobile: +966-59-301-3177                                        \n"+
				 		"                                                                 \n"+
				 		" LockedMeApplication Usage:                                      \n"+
				 		" -------------------------------                                 \n"+
				 		" Tasks are selected by entering Integer numbers                  \n"+      
				 		"                                                                 \n"+
				 		"*****************************************************************\n"+
				 		" Please, press [ENTER] or any key to proceed:                    \n");  
			   
	   temp = scanner.nextLine();  // accepts any key from the keyboard
	   temp = null;
			   		   
	}
	
				
	//=============================================================================================
	/// displayMainMenu(): Display the Main Menu    		
	//=============================================================================================	
			
	public static void MainMenuOptions() {
				
		// OPTION-1: Main Menu
		  System.out.print("*****************************************************************\n"+
				           "   MAIN NENU: Enter an Integer [0 - 2] to select an option       \n"+
					 	   "*****************************************************************\n"+	
		                   "1. List All Files & Directories in Ascending Order               \n"+  				
		                   "2. File Manipulations (add, delete, search, previous menu)       \n"+
		                   "0. EXIT                                                          \n"+
						   "   Chose an option: ");
		}
			
			
	//=============================================================================================
	/// option2SubMenu(): Display the Sub Menu for the Second Option    		
	//=============================================================================================	

	public static void subMenuOptions() {
		
	  // OPTION - 2: Sub-Menu
	  System.out.print("****************************************************************\n"+
               		   "FILE MANIPULATION: Enter an Integer [0 - 4] to select an option \n"+
               		   "****************************************************************\n"+	
              		   "1. Add a File                                                   \n"+
               		   "2. Delete a File                                                \n"+  				
               		   "3. Search for a File                                            \n"+
               		   "4. Return to Main Menu                                          \n"+
               		   "0. EXIT                                                         \n"+
               		   "   Chose an option: ");
				  
	//--------------------------------------------------------------------------------- 
	//   Ensures that the user has entered a valid integer value in the range of: [0-4]	
	//_________________________________________________________________________________ 
	int userSelectedOption = -1; 
	Scanner scan = new Scanner(System.in); 
	
			if ( scan.hasNextInt() )  // Checks whether the user has entered an Integer 
			{
					int scanSelectedNum = scan.nextInt();
					
					if ( (scanSelectedNum >= 0 && scanSelectedNum <= 4) ) 
					{
						userSelectedOption = scanSelectedNum;
					} else   // in case the user enters an out of range integer value
					{
						System.out.println("*****     ERROR MESSAGE                   *****");
						System.out.println(" SELECTED INTEGER OPTION IS OUT OF RANGE....!!!");
						System.out.println("-----------------------------------------------");
						subMenuOptions();
						userSelectedOption = -999;	
					}		
			} else {  // in case the user enters a non integer value
				System.out.println("*****     ERROR MESSAGE         *****");
				System.out.println(" INVALID OPTION SELECTED...!!!       ");
				System.out.println("-------------------------------------");
				subMenuOptions();
				userSelectedOption = -999;
				scan.next();
			}
			
			subMenuTaskManager(userSelectedOption);
	}
		
	
	//==============================================================================================
	///     subMenuTaskManager(option): Delegates OPTION-2 Sub-Menu Tasks to the appropriate methods    		
	//==============================================================================================			
					
	public static void subMenuTaskManager(int userSelectedOption) {
			
		switch (userSelectedOption) {
			
		case 0: // 0. Exit
			System.exit(0); // 0. EXIT
			break;
		case 1: // 1. Add a File
			addFile();
			subMenuOptions();
			break;
		case 2: // 2. Delete a File
			deleteFile();
			subMenuOptions();
			break;
		case 3: // 3. Search a File
			searchFile();
			subMenuOptions();
			break;
		case 4:  // 4. Go back to the Main Menu
			MainMenuOptions();
			break;
		default:		
			break;					
		}	
	}		
	
			
	//===========================================================================================
	///     mainMenuTaskManager(userSelectedOption): Delegates OPTION-1 Menu Tasks to the appropriate methods     		
	//===========================================================================================			
				
	public static void mainMenuTaskManager(int userSelectedOption) {
				
		switch (userSelectedOption) {
				
				case 0: // 0. Exit
					System.exit(0); 
					break;
				case 1: // 1. OPTION - 1: List All Files & Directories in Ascending Order
					directoryDisplayAscending();
					MainMenuOptions();
					break;
				case 2: // OPTION - 2: File Manipulation Utility
					subMenuOptions();
					break;
				default:		
					break;						
		}
	}
			

	//=============================================================================================
	///     searchFile(): Search for a user specified Filename     	
	//=============================================================================================	
	public static void searchFile() {
			
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of a file to search ==>: ");
		String fileToBeFound  = scan.next();
		File currentDirectory = new File("."); // points to the current directory
		String[] filesList = currentDirectory.list(); // gets all the files and folders in the current directory
		boolean fileFoundFlag = false;
				
		if (filesList == null) 
		{
			System.out.println("------------------------------");
			System.out.println("Current Directory is Empty...!");
			System.out.println("------------------------------");
		} else 
		{
			// Perform the Linear search in the "filesList" array.
			for (int i = 0; i < filesList.length; i++) 
			{
				String filename = filesList[i];
				
				if (filename.equals(fileToBeFound)) // case sensitive comparison 
				{
					System.out.println("---------------------------------------------");
					System.out.println("File: " + filename + " was successfully found");
					System.out.println("---------------------------------------------");
					fileFoundFlag = true;
				}
			} // for-loop
		} // else-condition
				
		if (fileFoundFlag == false) 
		{
			System.out.println("----------------------");
			System.out.println("File was Not Found...!");
			System.out.println("----------------------");
		}
	} 

			
	//=============================================================================================
	///     addFile(): CREATES A NEW FILE     	
	//=============================================================================================
									
	public static void addFile() {
		System.out.print("Enter the filename you want to create ==>: ");
		Scanner scan = new Scanner(System.in);
		File file = new File(scan.next());
				
		try
		{
			if (file.createNewFile()) {
				System.out.println("-------------------------------------------------------");
				System.out.println("File " +file.getName() + " was successfully Created...!");
				System.out.println("-------------------------------------------------------");
			} else 
			{
				System.out.println("---------------------------------------------");
				System.out.println("File " +file.getName() + " already Exists...!");
				System.out.println("---------------------------------------------");
			} 
									
			} catch (IOException e) {
				System.out.println("*****     ERROR MESSAGE         *****");
				e.printStackTrace();
				System.out.println("----      END OF ERROR MESSAGE  -----");
			}		
	}
									

//=============================================================================================
///         deleteFile(): DELETES AN EXISTING FILE    	
//=============================================================================================
				
	public static void deleteFile() {
					
		Scanner scan = new Scanner(System.in);
	
		try {
			System.out.print("Enter the filename you want to Delete ==>: ");
			File file2Delete = new File(scan.next());
				
			if(file2Delete.exists()) 
			{	
				if(file2Delete.delete()) 
				{
					System.out.println("------------------------------");
					System.out.println(" File " +file2Delete.getName() +" successfully deleted...!");
					System.out.println("------------------------------");
				}
					
			} else {
				System.out.println("-------------------");
				System.out.println(" File " + file2Delete.getName() + " was not found...!");
				System.out.println("-------------------");
			}			
								
		} catch (NoSuchElementException e) {
			System.out.println("*****     ERROR MESSAGE         *****");
			e.printStackTrace();
			System.out.println("----      END OF ERROR MESSAGE  -----");
		}
		
	} 
	
		

	//=============================================================================================
	///     directoryDisplayAscending(): Displays Files & Directories in Ascending  Order     	
	//=============================================================================================		
	public static void directoryDisplayAscending() {
		
		File path = new File("."); // points to the current directory  	    
		File[] listFiles = path.listFiles();		
		ArrayList<File> arrayListFiles = new ArrayList<>();
		
		for (File item: listFiles) {
			arrayListFiles.add(item);
		}					
		
		// SORTING THE COLLECTION IN ASCENDING ORDER		
		Collections.sort(arrayListFiles, new Comparator<File>() {
			public int compare(File e1, File e2) {
				return e1.compareTo(e2);
			}
		}); 	
		
		//  LISTING OF FILES & DIRECTORY
		
		if (arrayListFiles != null) 
		{
			System.out.println("--------------------------------");
			System.out.println("  Listing of Files & Directories   ");
			System.out.println("--------------------------------");
			System.out.println("");

			for (File item : arrayListFiles) 
			{
				if (item.isDirectory()) {
					System.out.println("DIRECORY: "+item.getName());

				} else if(item.isFile()) {
					System.out.println("FILE    : "+item.getName());
				} else {
					System.out.println("---------------------------------------------");
					System.out.println(" Type of Directory or File not recognized ...!");
					System.out.println("---------------------------------------------");
				} 
			}
			System.out.println("");
		} 
	
	}	
		
	
//*********************     END OF FILE UITILITIES     ***************************
	
	
//===========================================================================================	
}//parent	
	
//============================================================================================
