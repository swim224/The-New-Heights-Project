import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ElevatorSubSystem.Elevator;
import SchedulerSubSystem.Scheduler;

public class Main 
{
	public static List<String> csvReader()
	{ 
	    String file = "csv.txt";
	    List<String> content = new ArrayList<>();

	    BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
	        String line = "";
	        while ((line = br.readLine()) != null) 
	        {
	        	if(!line.contains("Time,")) {
	        		content.add(line);
	            }
	        }
		} catch (IOException e) {
			System.out.println("fail");
		}

	    return content;
	}
	
	public static void main(String[] args) 
	{
		List<String> elevatorData = new ArrayList<String>();
		elevatorData = csvReader();
		Thread elevatorA;
		Scheduler ss = new Scheduler(csvReader());

		elevatorA = new Thread(new Elevator(1, ss),"Elevator");
		elevatorA.start();
	}
}
