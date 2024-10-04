/*
 What does the Liskov principle say?
The Liskov principle states that:

Objects of a subclass should be able to replace objects of the base class without altering the expected behavior of the program.
 */

public class GameGameGameCharacter {
    protected String name;

    public GameGameGameCharacter(String name) {
        this.name = name;
    }

    public void attack() {
        System.out.println(name + " realiza un ataque básico.");
    }
}

// Subclass: Warrior
public class Warrior extends GameGameGameCharacter {

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(name + " ataca con una espada.");
    }
}

// Subclase: Mage
public class Mage extends GameGameGameCharacter {

    public Mage(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(name + " lanza un hechizo.");
    }
}

public class Game {
    public static void main(String[] args) {
        GameGameGameCharacter warrior = new Warrior("Conan");
        GameGameGameCharacter mage = new Mage("Gandalf");

        warrior.attack(); // Conan attacks with a blade.
        mage.attack();
    }
}


/*But, i we want to add a character that doesn't attack, just performs in other ways, it will be a problem. Let's see 
 a violation example of Liskov principle (LSP)*/

// We add a new class character: Healer
public class Healer extends GameGameCharacter {

    public Healer(String name) {
        super(name);
    }
}



// Healer can't attack, so, he doesn't implement the attack method. That's a problem.
// we can solve this defining an Interface or setting the GameGameGameCharacter class as an abstract class. 
// If we need a specific behavior (attack) for the characters, we set an interface. Example:

public interface Attackable{
    void attack();
}
 
//We implement the Attackable interface in chars that need can attack, and then define the GameGameGameCharacter class as we've seen. 

//But, if we just need to define a general behavior for all the chars, we set an abstract class:
public abstract class GameGameCharacter {
    protected String name;
    protected int health;

    public GameGameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // Método común para mostrar estado
    public void showStatus() {
        System.out.println("Personaje: " + name + ", Salud: " + health);
    }

    // Método abstracto que será implementado por subclases si tiene sentido
    public abstract void performAction();
}


// Subclase Warrior implementa performAction como un ataque
public class Warrior extends Chariacter {

    public Warrior(String name, int health) {
        super(name, health);
    }

    @Override
    public void performAction() {
        System.out.println(name + " ataca con una espada.");
    }
}

// Subclase Mage implementa performAction como un hechizo
public class Mage extends GameCharacter {

    public Mage(String name, int health) {
        super(name, health);
    }

    @Override
    public void performAction() {
        System.out.println(name + " lanza un hechizo.");
    }
}

// Subclase Healer implementa performAction como una curación
public class Healer extends GameCharacter {

    public Healer(String name, int health) {
        super(name, health);
    }

    @Override
    public void performAction() {
        System.out.println(name + " usa una habilidad de curación.");
    }
}

/*
 
Both approaches follow the Liskov substitution principle, 
since you are not forcing subclasses to implement methods that don't make sense for them, like attack() in the case of Healer.

 */



