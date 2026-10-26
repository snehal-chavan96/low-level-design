package SingletonDesignPattern;


class Logger{
    
    // 1. Single Instance
    private static Logger instance;


    // 2. Private Constructor
    private Logger(){
        System.out.println("Logger instance created!");
    }

    // 3. Global access point 
    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }

        return instance;
    }

    // Logging Method 
    public void log(String message){
        System.out.println("[LOG]: "+message);
    }

}

public class SingletonDesignPattern{
    public static void main(String[] args) {
        
        // First request
        Logger logger1 = Logger.getInstance();
        logger1.log("Payment initiated");

        Logger logger2 = Logger.getInstance();
        logger2.log("User logged in");

        Logger logger3 = Logger.getInstance();
        logger3.log("Order placed");

        System.out.println(logger1 == logger2);
        System.out.println(logger2 == logger3);
    }
}