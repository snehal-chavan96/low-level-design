// --- Main Function ---
public class StrategyDesignPattern {
    public static void main(String args[]){
        GameCharacter warrior = new Warrior(new SwordAttack(), new ShieldDefense(),new RunMovement());

        warrior.display();
        warrior.attack();
        warrior.defend();
        warrior.move();

        System.out.println("--------------------");

        GameCharacter wizard = new Wizard(new GunAttack(), new MagicDefense(), new TeleportMovement());

        wizard.display();
        wizard.attack();
        wizard.defend();
        wizard.move();
        
    }
}

// --- Strategy Interface for Attack ---
interface AttackBehaviour {
    void attack();
    
}

// --- Concrete Strategies for Attack ---
class SwordAttack implements AttackBehaviour{
    public void attack(){
        System.out.println("Attacking with a sword!");
    }
}

class GunAttack implements AttackBehaviour{
    public void attack(){
        System.out.println("Attacking with a gun!");
    }
}

class NoAttack implements AttackBehaviour{
    public void attack(){
        System.out.println("Cannot attack.");
    }
}

// --- Strategy Interface for Defense ---
interface DefenseBehavior{
    void defend();
}

// --- Concrete Strategies for Defense ---
class ShieldDefense implements DefenseBehavior{
    public void defend(){
        System.out.println("Defending with a shield!");
    }
}

class MagicDefense implements DefenseBehavior{
    public void defend(){
        System.out.println("Using a magic barrier!");
    }
}

class NoDefense implements DefenseBehavior{
    public void defend(){
        System.out.println("Cannot defend");
    }
}


// --- Strategy Interface for Movement ---
interface MovementBehavior{
    void move();
}

// --- Concrete Strategies for Movement ---
class RunMovement implements MovementBehavior {
    public void move() {
        System.out.println("Running on the ground!");
    }
}

class FlyMovement implements MovementBehavior {
    public void move() {
        System.out.println("Flying through the air!");
    }
}

class TeleportMovement implements MovementBehavior {
    public void move() {
        System.out.println("Teleporting to another location!");
    }
}


// --- Base Character Class ---
abstract class GameCharacter{
    protected AttackBehaviour attackBehaviour;
    protected DefenseBehavior defenseBehavior;
    protected MovementBehavior movementBehavior;

    public GameCharacter(
        AttackBehaviour attack,
        DefenseBehavior defense,
        MovementBehavior movement
    ){
        this.attackBehaviour = attack;
        this.defenseBehavior = defense;
        this.movementBehavior = movement;
    }

    public void attack(){
        attackBehaviour.attack();
    }

    public void defend(){
        defenseBehavior.defend();
    }

    public void move(){
        movementBehavior.move();
    }

    public abstract void display();
}

// --- Concrete Character Types ---
class Warrior extends GameCharacter{
    public Warrior(AttackBehaviour a, DefenseBehavior d, MovementBehavior m){
        super(a, d, m);
    }

    public void display(){
        System.out.println("I am a Warrior!");
    }
}

class Wizard extends GameCharacter{
    public Wizard(AttackBehaviour a, DefenseBehavior d, MovementBehavior m){
        super(a, d, m);
    }

    public void display(){
        System.out.println("I am a Wizard!");
    }
}


