import entities.LevelsENUM;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemies extends  Character {
    private int numberOfEnemies;
    private boolean isMovingToRight = false;

    private JFrame frameInstance;
    private LevelsENUM.LEVELS level;

    private int screenWidth ;
    private int screenHeight;
    private int spaceBetween = 30;

    private int xInit;
    private int yInit;

    private int elementsPerRow = 0;
    private int lastCompleteRowElementIndex = 0;
    private int firstCompleteRowElementIndex = 0;

    private List bulletsInstanceList;

    public Enemies(int width, int height, int numberOfEnemies, LevelsENUM.LEVELS level, JFrame frameInstance, List bulletsInstanceList) {
        super(width, height, true, "assets/enemy.jpg");

        this.frameInstance = frameInstance;
        this.numberOfEnemies = numberOfEnemies;
        this.bulletsInstanceList = bulletsInstanceList;

        this.level = level;

        screenWidth = frameInstance.getWidth();
        screenHeight = frameInstance.getHeight();

        xInit = screenWidth * 1/4;
        yInit = screenHeight * 1/10;
    }

    List<Character> enemies = new ArrayList<Character>();


    public List<Character> initEnemies(int numberOfEnemies) {

        int currentX = xInit;
        int currentY = yInit;

        for(int i = 0; i<numberOfEnemies; i++){
            if(currentX > (screenWidth - xInit - getWidth())){
                if(elementsPerRow == 0) elementsPerRow = i;
                lastCompleteRowElementIndex += elementsPerRow;

                currentX = xInit;
                currentY += spaceBetween;
            }
            Character character = new Character(getWidth(), getHeight(), currentX , currentY, true, "assets/enemy.jpg", frameInstance, 1, this.bulletsInstanceList);
            enemies.add(character);
            currentX += spaceBetween;
        }
        lastCompleteRowElementIndex--;

        if(lastCompleteRowElementIndex == numberOfEnemies){
            firstCompleteRowElementIndex = lastCompleteRowElementIndex - elementsPerRow + 1;
        }else{
            firstCompleteRowElementIndex =  lastCompleteRowElementIndex+1;
        }

        return this.enemies;
    }

    private Character getRandomCharacter(){
        int toBeReturnedIndex = -1;
        Random random = new Random();
        while(toBeReturnedIndex == -1){
            int localIndex = random.nextInt(enemies.size());
            if(enemies.get(localIndex).isVisible) toBeReturnedIndex = localIndex;
        }

        return enemies.get(toBeReturnedIndex);
    }

    public void moveAllEnemies(){
        Character shootingEl = getRandomCharacter();
        shootingEl.shoot(-1);

        for(int i = 0; i<numberOfEnemies; i++){
            if (isMovingToRight) {
                if(!enemies.get(lastCompleteRowElementIndex).areCoordinatesValid(enemies.get(lastCompleteRowElementIndex).getX() + spaceBetween, "x")){
                    isMovingToRight = !isMovingToRight;
                    break;
                } else{
                    enemies.get(i).moveRight();
                }
            } else {
                if(!enemies.get(firstCompleteRowElementIndex).areCoordinatesValid(enemies.get(firstCompleteRowElementIndex).getX() - spaceBetween, "x")){
                    isMovingToRight = !isMovingToRight;
                    enemies.get(firstCompleteRowElementIndex).moveRight();
                    break;
                } else{
                    enemies.get(i).moveLeft();
                }
            }
        }
    }
}
