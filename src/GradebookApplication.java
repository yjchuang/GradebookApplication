import java.util.Scanner;
import java.lang.String;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GradebookApplication {

	static String[] firstName = new String[100];
	static String[] gender = new String[100];
	static String[] major = new String[100];
	static String[] stateOfOrigin = new String[100];
	static double[] score = new double[100];
	static double averageForMD = 0.0;
	static double averageForDC = 0.0;
	static double averageForVA = 0.0;
	static double averageForCS = 0.0;
	static double averageForEE = 0.0;
	static double averageForIS = 0.0;

	public static void main(String[] args) {

		double overAllAverage=0.0, averageForFemale=0.0, averageForMale=0.0; 

		boolean response = false;

		//initializing scores to 0.0
		for (int j = 0; j < 100; ++j)
		{
			score[j] = 0.0;
		}

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 100; ++i) 
		{

			response = ReadOneStudentRecord(sc, i);

			//user doesn't want to continue
			if (response == false) 
			{
				CalculateAverage(i+1, overAllAverage, averageForFemale, averageForMale);

				break;
			}
		}
		sc.close();
	}

	public static boolean ReadOneStudentRecord(Scanner sc, int index)
	{
		System.out.println("Enter Student first name "
				+ "Gender (M/F), Major (CS, EE, or IS), "
				+ "State of Origin (MD, DC, or VA), and test Score");
		firstName[index] =  sc.next();
		gender[index] = sc.next();
		major[index] = sc.next();
		stateOfOrigin[index] = sc.next();
		score[index] = sc.nextDouble();
		sc.nextLine();

		System.out.println("Do you want to continue (y/n)? ");
		String response = sc.next();
		if (response.equalsIgnoreCase("y"))
		{
			return(true);
		}
		else
		{
			return(false);
		}

	}

	public static void CalculateAverage(int numberOfStudent, 
			double overAllAverage, double averageForFemale,
			double averageForMale)
	{
		overAllAverage=0.0; 
		averageForFemale=0.0; 
		averageForMale=0.0; 
		int numberOfMale = 0;
		int numberOfFemale = 0;
		int numberOfMDStudents = 0;
		int numberOfDCStudents = 0;
		int numberOfVAStudents = 0;
		int numberOfCSStudents = 0;
		int numberOfEEStudents = 0;
		int numberOfISStudents = 0;
		
		DateFormat dateFormat = new SimpleDateFormat("/MM/dd/yyyy");
		Date date = new Date(System.currentTimeMillis());
		//System.out.println("Today is " + date);
		System.out.println("Today is " + dateFormat.format(date));
		

		for (int i=0; i < numberOfStudent; ++i)
		{
			overAllAverage += score[i];
			if (gender[i].equalsIgnoreCase("m"))	//male student
			{
				averageForMale += score[i];
				++numberOfMale;
			}
			else									//female student
			{
				averageForFemale += score[i];
				++numberOfFemale;
			}

			//major averages
			if (major[i].equalsIgnoreCase("CS"))
			{
				averageForCS += score[i];
				++numberOfCSStudents;
			}
			else if (major[i].equalsIgnoreCase("EE"))
			{
				averageForEE += score[i];
				++numberOfEEStudents;
			}
			else // average for IS
			{
				averageForIS += score[i];
				++numberOfISStudents;
			}


			//state of origin averages
			if (stateOfOrigin[i].equalsIgnoreCase("MD"))
			{
				averageForMD += score[i];
				++numberOfMDStudents;
			}
			else if (stateOfOrigin[i].equalsIgnoreCase("VA"))
			{
				averageForVA += score[i];
				++numberOfVAStudents;
			}
			else // average for DC
			{
				averageForDC += score[i];
				++numberOfDCStudents;
			}

		}
		if(numberOfStudent > 0)
			overAllAverage = overAllAverage/numberOfStudent;

		//male average
		if(numberOfMale > 0)
			averageForMale = averageForMale/numberOfMale;
		//female average
		if(numberOfFemale > 0)
			averageForFemale = averageForFemale/numberOfFemale;

		//major and state averages
		if(numberOfDCStudents > 0)
			averageForDC = averageForDC/numberOfDCStudents;
		if(numberOfVAStudents > 0)
			averageForVA = averageForVA/numberOfVAStudents;
		if(numberOfMDStudents > 0)
			averageForMD = averageForMD/numberOfMDStudents;
		if(numberOfCSStudents > 0)
			averageForCS = averageForCS/numberOfCSStudents;
		if(numberOfEEStudents > 0)
			averageForEE = averageForEE/numberOfEEStudents;
		if(numberOfISStudents > 0)
			averageForIS = averageForIS/numberOfISStudents;

		System.out.println("Number of students: " + numberOfStudent);
		System.out.println("Over all average: " + overAllAverage);
		System.out.println("Average for female students: " + averageForFemale);
		System.out.println("Average for male students: " + averageForMale);
		System.out.println("Average for CS major: " + averageForCS);
		System.out.println("Average for EE major: " + averageForEE);
		System.out.println("Average for IS major: " + averageForIS);
		System.out.println("Average for MD state students: " + averageForMD);
		System.out.println("Average for DC state students: " + averageForDC);
		System.out.println("Average for VA state students: " + averageForVA);

	}


}
