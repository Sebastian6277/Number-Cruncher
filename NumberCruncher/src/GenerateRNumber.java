import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GenerateRNumber {
	
	    public void generateNumber(Levels levels, String difficulty) {
	    	// -------------------------------------------------------------------------------------------------------------------------------------------
			// Method                : generateNumber
			// Method Parameters     : Level: we instantiate the Levels3 class, 
	    	//                         String difficulty: This will allow us to call each level 
			// Method return         : 
			// Synopsis              : In this method we are going to generate 1000 random numbers for comparison purposes
			//
			// Modifications :             Author:                        Notes:
			//     Date:
			//   2023/06/05             C.Sebastian                    Initial Setup
			// --------------------------------------------------------------------------------------------------------------------------------------------
	        Random random = new Random();
	        List<Integer> randomNumbers = new ArrayList<>();
	        int numberAmount = 0;

	        if (difficulty.equals("easy")) {
	           numberAmount = 1000;                                                           //number of elements generated                                                              
	           if(levels.complete ==3 ) {                                                     
	        	   levels.numberRange+=10;                                                    //we instantiate the number range from levels class,
	           }                                                                              //in this case every time the stage is complete the number range increase 10 numbers 
	        } else if (difficulty.equals("moderate")) {
	            numberAmount = 1000;
	            if(levels.complete ==5 ) {
	            	levels.numberRange+=100;                                                 //In this case very time the stage is complete, the number range increased 100 more numbers
		        }
	        } else if (difficulty.equals("difficult")) {
	            numberAmount = 1000;	 
	            if(levels.complete ==7 ) {
	            	levels.numberRange+=1000;                                                //In this case very time the stage is complete, the number range increased 1000 more numbers
		        }
	        }

	        
	        for (int index = 0; index < numberAmount; index++) {                              //We always generate 1000 random numbers 
	            int randomNumber = random.nextInt(levels.numberRange) + 1;
	            randomNumbers.add(randomNumber);
	        }

	        
	        List<Integer> modes = findModes(randomNumbers);                                    //the number that repeats most times in the list is calculated

	       
	        while (modes.size() > 1) {                                                         //if there are more than one mode, a new list is generated 
	            randomNumbers.clear();
	            for (int index = 0; index < numberAmount; index++) {
	                int randomNumber = random.nextInt(levels.numberRange) + 1;
	                randomNumbers.add(randomNumber);
	            }
	            modes = findModes(randomNumbers);
	        }

	        levels.setGuessLabels(randomNumbers);
	    }

	    private List<Integer> findModes(List<Integer> numbers) {                             //We received the numbers list  
	    	// -------------------------------------------------------------------------------------------------------------------------------------------
		    // Method                : findModes(List<Integer> numbers)  	
		    // Method Parameters     : List<Integer> numbers : scrolls through the list numbers 
		    // Method return         : List: The modes list is returned, containing the statistical modes found in the original list of numbers.
		    // Synopsis              : In this method we are going to identify the modes for the list of numbers.
		   	//
			// Modifications :             Author:                        Notes:
		    //     Date:
		    //   2023/05/29             C.Sebastian                    Initial Setup
		    // --------------------------------------------------------------------------------------------------------------------------------------------
	    	
	    	Map<Integer, Integer> frequencyMap = new HashMap<>();                            //We use a map to follow the sequence 
	        int maxFrequency = 0;

	        for (int number : numbers) {                                                     //here is the list of numbers
	            int frequency = frequencyMap.getOrDefault(number, 0) + 1;
	            frequencyMap.put(number, frequency);
	            maxFrequency = Math.max(maxFrequency, frequency);
	        }

	        List<Integer> modes = new ArrayList<>();                                         //we create a new list to keep the modes found 
	        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
	            if (entry.getValue() == maxFrequency) {                                      //we verify of the entry.getvalue is equal to maxFrequency 
	                modes.add(entry.getKey());                                               //if both are equal we add it to the list "modes"
	            }
	        }

	        return modes;
	    }
	}
