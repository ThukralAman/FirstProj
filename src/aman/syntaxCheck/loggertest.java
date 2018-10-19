package aman.syntaxCheck;

class Logger {
	private static Logger logger;
	
	private Logger() {
		
	}
	
	
	
	public static Logger  getInstance() {
		if(logger!=null) {
			return logger;
		}else{
			logger = new Logger();
			return logger;
		}
	}
}

public class loggertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	

	}

}
