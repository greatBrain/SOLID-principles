public class GameCharacter
{
	  public GameCharacter(String charName, int charHealth)
	  {
         String name = charName;
         int health = charHealth
	  }

    public void set_attack()
    {
         system.out.println("Attack body to body");
    }

    public void get_health_status()
    {
         system.out.println("Character:" + name + ", health status:" + health);
    }
}


//Class that extends and override this methods.
class Warrior extends GameCharacter
{
    public void Warrior(String name, int health)
    {
        super(name, health);
    }

    @override
    public void set_attack()
    {
        system.out.println(name + " attack using a blade"); 
    }
}


class Mage extends GameCharacter
{

    public Mage(String name, int health) {
        super(name, health);
    }

    @Override
    public void set_attack() {
        System.out.println(name + " cast a spell");
    }
}

// HOW IT WORKS
/*
 Base class GameCharacter: It defines the common attributes and methods for all characters. For example, name and health, as well as a generic attack that any character can perform. This class is open for extension because it can be inherited to create new subclasses, but it is closed for modification, as we don't need to change its code to add new types of characters.

Subclasses Warrior and Mage: Both extend the GameCharacter class and override the attack() method to provide specific behaviors for each type of character. The Warrior attacks with a sword, and the Mage casts a spell.

Main class Game: Here, instances of Warrior and Mage are created, and we see how each one attacks differently, even though they share the same character interface. This demonstrates that we can extend functionality (add new characters) without modifying the base Character class.

Future extensions: If you want to add, for example, an Archer, you just need to create a new class that extends Character without altering the existing code.

 */
