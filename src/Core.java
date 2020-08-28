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

    HashMap<UIEntitiesENUM.ENTETIES, List<Character>> gameCore = new HashMap<UIEntitiesENUM.ENTETIES, List<Character>>();
    Enemies enemyBots;

    public Core(JFrame frameInstance){
        this.frameInstance = frameInstance;
        enemyBots = new Enemies(entityWidth, entityHeight, numberOfEnemies, LevelsENUM.LEVELS.LEVEL_ONE, frameInstance);
    }

    public void initAllElements(){
        initPlayer();
        initEnemies();
    }

    public void initPlayer(){
        Character player = new Character(entityWidth, entityHeight, 500, 500, true, "assets/shooter.jpg", frameInstance, 3);
        List<Character> playerList = new ArrayList<>();
        playerList.add(player);
        gameCore.put(UIEntitiesENUM.ENTETIES.PLAYER, playerList);
    }

    private void initEnemies(){
        List<Character> enemiesList = enemyBots.initEnemies(numberOfEnemies);
        gameCore.put(UIEntitiesENUM.ENTETIES.ENEMIES, enemiesList);
    }



    public void animateEnemieBots(){
        enemyBots.moveAllEnemies();
    }


    public Character getPlayer(){
        return gameCore.get(UIEntitiesENUM.ENTETIES.PLAYER).get(0);
    }

    public List<Character> getAllElementsToBeRendered(){
        List<Character> toBeReturned = new ArrayList<>();
        List<Character> players = gameCore.get(UIEntitiesENUM.ENTETIES.PLAYER);
        List<Character> enemies = gameCore.get(UIEntitiesENUM.ENTETIES.ENEMIES);

        toBeReturned.addAll(players);
        toBeReturned.addAll(enemies);

        return toBeReturned;
    }
}
