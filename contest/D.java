// Game of Throwns
import java.util.*;
class D {
	public static int currStudent = 0;
	public static int numStudents;
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
    	numStudents = in.nextInt();
    	int numComs = in.nextInt();
    	Stack<Integer> comHistory = new Stack<Integer>();

    	for(int i = 0; i < numComs; i++) {
    		String command = in.next();
    		if(command.equals("undo")) {
    			int undoCount = Integer.parseInt(in.next());
    			for(int x = 0; x < undoCount; x++) {
    				int com = comHistory.empty() ? 0 : comHistory.pop();
    				executeCommand(com * -1);
    			}

    		} else {
    			int com = Integer.parseInt(command);

    			comHistory.push(com);
    			executeCommand(com); 
    		}
    		
    	}
		System.out.println(currStudent);
		
	}
	public static void executeCommand(int command) {
		currStudent = ( currStudent + command ) % numStudents;
		if(currStudent < 0) {
			currStudent += numStudents;
		}
	}
}
