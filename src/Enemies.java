//import javax.swing.*;

import entities.LevelsENUM;

import javax.swing.*;

public class Enemies extends  Character {
   private int speed;
    private int numberOfEnemies;
    LevelsENUM.LEVELS level;

    public Enemies(int width, int height, int speed, int numberOfEnemies, LevelsENUM.LEVELS level) {
        super(width, height, true, "assets/enemy.jpg");

        this.numberOfEnemies = numberOfEnemies;
        this.speed = speed;
        this.level = level;
    }

    Character[] enemies = new Character[numberOfEnemies];

    public Character[] initEnemies() {
        for(int i = 1; i<=10; i++){
            enemies[i] = new Character(getWidth(), getHeight(),  true, "assets/enemy.jpg");
        }
        return enemies;
    }
}
