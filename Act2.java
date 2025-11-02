package vadil;
import java.util.Scanner;
import java.util.HashSet;
import java.util.*;

public class Act2 {
	 public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        while (true) {
	            System.out.print("Enter a string (a/b only, or 'exit' to quit): ");
	            String str = input.nextLine();

	            if (str.equalsIgnoreCase("exit")) {
	                System.out.println("Program terminated.");
	                break;
	            }

	            Set<String> currentStates = new HashSet<>();
	            currentStates.add("q0");

	            for (char symbol : str.toCharArray()) {
	                if (symbol != 'a' && symbol != 'b') {
	                    System.out.println("Invalid input. Use only 'a' and 'b'.\n");
	                    currentStates.clear();
	                    break;
	                }

	                Set<String> nextStates = new HashSet<>();

	                for (String state : currentStates) {
	                    if (state.equals("q0")) {
	                        if (symbol == 'a') {
	                            nextStates.add("q0");
	                            nextStates.add("q1");
	                        } else if (symbol == 'b') {
	                            nextStates.add("q0");
	                        }
	                    } else if (state.equals("q1")) {
	                        if (symbol == 'a') {
	                            nextStates.add("q1");
	                        } else if (symbol == 'b') {
	                            nextStates.add("q2");
	                        }
	                    } else if (state.equals("q2")) {
	                        nextStates.add("q2");
	                    }
	                }

	                currentStates = nextStates;
	            }

	            if (currentStates.contains("q2"))
	                System.out.println("Output: Accepted\n");
	            else
	                System.out.println("Output: Rejected\n");
	        }

	        input.close();
	    }
	}