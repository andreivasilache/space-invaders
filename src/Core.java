import entities.LevelsENUM;
import entities.UIEntitiesENUM;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Core {

    int entityWidth = 25;
    int entityHeight = 25;
    int numberOfEnemies = 55;

    JFrame frameInstance;

    HashMap<UIEntitiesENUM.ENTETIES, Object> gameCore = new HashMap<UIEntitiesENUM.ENTETIES, Object>();
    Enemies enemyBots;

    public Core(JFrame frameInstance){
        this.frameInstance = frameInstance;
    }

    public void initAllElements(){
        initBulletsList();
        initPlayer();
        initEnemies();
    }

    private void initBulletsList(){
        List<Bullet> bullets = new ArrayList<>();
        gameCore.put(UIEntitiesENUM.ENTETIES.BULLETS, bullets);
    }

    private  List getBulletsList(){
        List<Character> bullets = (List<Character>) gameCore.get(UIEntitiesENUM.ENTETIES.BULLETS);
        return bullets;
    }

    private void initPlayer(){
        List bulletsInstanceList = getBulletsList();
        Character player = new Character(entityWidth, entityHeight, 500, 500, true, "assets/shooter.jpg", frameInstance, 3,  bulletsInstanceList);
        List<Character> playerList = new ArrayList<>();
        playerList.add(player);
        gameCore.put(UIEntitiesENUM.ENTETIES.PLAYER, playerList);
    }

    private void initEnemies(){
        List bulletsInstanceList = getBulletsList();
        enemyBots = new Enemies(entityWidth, entityHeight, numberOfEnemies, LevelsENUM.LEVELS.LEVEL_ONE, frameInstance, bulletsInstanceList);

        List<Character> enemiesList = enemyBots.initEnemies(numberOfEnemies);
        gameCore.put(UIEntitiesENUM.ENTETIES.ENEMIES, enemiesList);
    }

    public void animateEnemieBots(){
        enemyBots.moveAllEnemies();
    }

    public void animateBullets(){
        List<Bullet> bullets = getBulletsList();
        for (int i=0; i<bullets.size(); i++){
            bullets.get(i).moveBullet();
        }
    }

    private void isValidBullet(int x, int y){

    }

    public Character getPlayer(){
        return ((List<Character>) gameCore.get(UIEntitiesENUM.ENTETIES.PLAYER)).get(0);
    }

    public List<Character> getAllElementsToBeRendered(){
        List<Character> toBeReturned = new ArrayList<>();
        List<Character> players = (List<Character>) gameCore.get(UIEntitiesENUM.ENTETIES.PLAYER);
        List<Character> enemies = (List<Character>) gameCore.get(UIEntitiesENUM.ENTETIES.ENEMIES);
        List<Bullet> bullets = (List<Bullet>) gameCore.get(UIEntitiesENUM.ENTETIES.BULLETS);

        toBeReturned.addAll(players);
        toBeReturned.addAll(enemies);
        toBeReturned.addAll(bullets);

        return toBeReturned;
    }
}
