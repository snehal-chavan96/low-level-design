package FactoryDesignPattern;

// Burger Interface
interface Burger{
    void prepare();
}

// Concrete Burger Implementations
class BasicBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger implements Burger{
    public void prepare(){

        System.out.println("Preparing Standard Burger with bun, patty, cheese and lettuce!");

    }
}

class PremiumBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

//BurgerFactory
class BurgerFactory{
    public static Burger createBurger(String type){
        if(type == null){
            throw new IllegalArgumentException("Burger type cannot be null");
        }
    

    switch(type.toLowerCase()){
        case "basic":
            return new BasicBurger();

        case "standard":
            return new StandardBurger();
        
        case "premium":
            return new PremiumBurger();

        default:
            throw new IllegalArgumentException("Invalid burger type: "+type);
        }
    }
}

//Main Class
public class SimpleFactory {
    public static void main(String[] args) {
        String type = "standard";
        Burger burger = BurgerFactory.createBurger(type);

        burger.prepare();
    }    
}
