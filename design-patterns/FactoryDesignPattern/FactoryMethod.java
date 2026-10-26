package FactoryDesignPattern;


interface Burger{

    void prepare();

}

//Concrete Products
class BasicBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Basic Burger with bun patty and ketchup!");
    }
}
class  StandardBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce and secret sauce");
    }
}

class BasicWheatBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Basic Wheat Burger with wheat bun, patty, and ketchup!");
    }
}

class StandardWheatBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Standard Wheat Burger with wheat bun, patty, cheese, and lettuce");
    }
}

class PremiumWheatBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Premium Wheat Burger with wheat bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

// Creator: Declares the Factory Method
abstract class BurgerFactory{

    // Factory Method
    public abstract Burger creatBurger();

    // Business logic that uses the Factory Method
    public void orderBurger(){
        Burger burger = creatBurger();
        burger.prepare();
    }
}

// Concrete Creators for Singh Burger
class SinghBasicBurgerFactory extends BurgerFactory{
    public Burger creatBurger(){
        return new BasicBurger();
    }
}

class SinghStandardBurgerFactory extends BurgerFactory{
    public Burger creatBurger(){
        return new StandardBurger();
    }
}

// Concrete Creators for King Burger
class KingBasicBurgerFactory extends BurgerFactory{
    public Burger creatBurger(){
        return new StandardBurger();
    }
}

class KingPremiumBurgerFactory extends BurgerFactory{
    public Burger creatBurger(){
        return new  PremiumBurger();
    }
}
// Main Class
public class FactoryMethod {
  public static void main(String[] args) {
    
    BurgerFactory factory = new SinghBasicBurgerFactory();
    factory.orderBurger();

    System.out.println();
    
    // Order a Standard Burger from Singh Burger
    factory = new SinghStandardBurgerFactory();
    factory.orderBurger();
  }  
}

