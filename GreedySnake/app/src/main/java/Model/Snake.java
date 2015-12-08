package Model;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Snake {

    private final List<CellObject> squares;


    private enum direction {
        up, down, left, right, none
    }

    private direction currentDirection;
    private int growingLeft;




    public Snake(int xStart, int yStart) {
        squares = new ArrayList<CellObject>();
        squares.add(new CellObject(xStart, yStart));
        currentDirection = direction.none;
    }


    public Snake() {
        this(0, 0);
    }


    public int eat(FoodCell food) {
        grow();
        food.setTimeLeftZero();
        return food.getPointValue();
    }


    public CellObject getHead() {
        return squares.get(0);
    }


    public void grow() {
        growingLeft++;
    }



    public void moveInCurrentDirection() {
        addSquareToHead();
        if (squares.size() > 1) {
            removeSquareFromTail();
        }
    }

    private void addSquareToHead() {
        CellObject head = squares.get(0);
        int newX = head.getX();
        int newY = head.getY();
        switch (currentDirection) {
            case up:
                newY--;
                break;
            case down:
                newY++;
                break;
            case left:
                newX--;
                break;
            case right:
                newX++;
                break;
            case none:
                return;
            default:
                return;
        }
        squares.add(0, new CellObject(newX, newY));
    }


    public boolean isHit() {
        Iterator<CellObject> iterator = squares.iterator();
        CellObject head = iterator.next();
        while (iterator.hasNext()) {
            if (iterator.next().equals(head)) {
                return true;
            }
        }
        return false;
    }


    private void removeSquareFromTail() {
        if (growingLeft > 0) {
            growingLeft--;
            return;
        } else {
            squares.remove(squares.size() - 1);
        }
    }



    public void moveUp() {
        if (currentDirection != direction.down) {
            currentDirection = direction.up;
        }
    }



    public void moveDown() {
        if (currentDirection != direction.up) {
            currentDirection = direction.down;
        }
    }



    public void moveLeft() {
        if (currentDirection != direction.right) {
            currentDirection = direction.left;
        }
    }


    public void moveRight() {
        if (currentDirection != direction.left) {
            currentDirection = direction.right;
        }
    }

    /**
     * returns true if part of the snake is at the given position.
     *
     * @param x
     *            x
     * @param y
     *            y
     * @return true if part of the snake is at the given position
     */
    public boolean isAt(int x, int y) {

        return squares.contains(new CellObject(x, y));
    }
}
