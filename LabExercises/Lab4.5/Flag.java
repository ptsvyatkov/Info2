
public class Flag {

	public static void main(String[] args) {
		Flag flag = new Flag();
		String outputLine;  
		for (int row = 1; row <= 40; row++){      
		    outputLine = "";      
		    for (int column = 1; column <= 40; column++){
		        outputLine = outputLine+flag.determineCharacter (column, row);
		    }      
		    System.out.println (outputLine);
		}  
		
		
		}
	public char determineCharacter (int column, int row) {
		char a = 'a';
		//Border
		if (column<3) {
			return '?';
		}
		
		if (column>38) {
			return '?';
		}
		if (row<3) {
			return '?';
		}
		
		if (row>38) {
			return '?';
		}
		
		//recangle plus inside recangle
		if(column==18 && row<18 && row>2) {
			return '|';
		}
		if (row==17 && column>2 && column<18) {
			return '-';
		}
		if (row>2 && row<17 && column>2 && column<18 && row%3==0 && column%2==1) {
			return '/';
		}
		if (row>2 && row<17 && column>2 && column<18 && row%3==0 && column%2==0) {
			return '=';
		}
		if (row>2 && row<17 && column>2 && column<18 && row%3==1 && column%2==1) {
			return '=';
		}
		if (row>2 && row<17 && column>2 && column<18 && row%3==1 && column%2==0) {
			return '/';
		}
		//hier noch das leerzeichen rein
		if (row>2 && row<17 && column>2 && column<18 && row%3==2 && column%2==1) {
			return '=';
		}
		if (row>2 && row<17 && column>2 && column<18 && row%3==2 && column%2==0) {
			return '/';
		}
		
		//diagonale and below and beneath diagonale, diagonale noch nicht ganz richtig
		if(row==(column*(-1)+41)) {
			return '+';	
		}
		
		
		if(row<(column*(-1)+41)) {
			if (column%5==0) {
				return '(';	
			}else {
				return ' ';
			}
			
		} else {
			if (row%3==0) {
				return ')';
			} else {
				return ' ';
			}
		}

		
	}

}
