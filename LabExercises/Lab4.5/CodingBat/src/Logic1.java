public class Logic1 {
 public static void main(String[] args) {
	 Logic1 logic = new Logic1();
	 System.out.println(logic.alarmClock(0, true));
 }
 
 public boolean cigarParty(int cigars, boolean isWeekend) {
	  if (isWeekend && cigars>=40){
	    return true;
	  }
	  else if (!isWeekend && cigars>=40 && cigars<=60){
	    return true;
	  }
	  return false;
	}
 
 public String alarmClock(int day, boolean vacation) {
	  String alarm = "7:00";
	  String alarmWeekend = "10:00";
	  String alarmOff = "off";
	  if (!vacation){
	    if(day == 1 || day == 2 || day == 3 || day == 4 || day == 5 ){
	      return alarm;
	    }
	    else{
	      return alarmWeekend;
	    }
	  }
	  else{
	    if(day == 1 || day == 2 || day == 3 || day == 4 || day == 5 ){
	      return alarmWeekend;
	    }
	    else {
	      return alarmOff;
	  }
	}
	}
 
 public boolean twoAsOne(int a, int b, int c) {
	  if(a+b == c || a+c == b || b+c == a){
	    return true;
	  }
	  return false;
	}
 public int blackjack(int a, int b) {
	  if (a<22 && a>0 && b<22 && b>0){
	  if(a>b){
	    return a;
	  }
	  if(b>a){
	    return b;
	  }
	  if(a<b){
	    return b;
	  }
	  if(b<a){
	    return a;
	  }
	  }
	  
	  return 0;
	  
	}
 public int blackjack2(int a, int b) {
	  if (a<22 && b<22){
	    if(a>b){
	    return a;
	    }
	    if(b>a){
	    return b;
	    }
	  }
	  else if(a>22 && b<22){
	    return b;
	  }
	  else if(b>22 && a<22){
	    return a;
	  }
	  
	  return 0;
	  
	  
	}
}
