package Model;

/**
 * Created by tiantianxie on 11/11/15.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Snake {
    private enum direction {
        up, down, left, right, none
    }

    private direction currentDirection;
    private int growingLeft;

    /**
     * holds parts of the snake (sorted: head of snake is at beginning, tail at
     * end).
     */
    private final List<CellObject> squares;

    /**
     * constructs new snake at specified coordinates.
     * <p>
     * The snake is one square in size and will not move.
     *
     * @param xStart
     *            xStart
     * @param yStart
     *            yStart
     */
    public Snake(int xStart, int yStart) {
        squares = new ArrayList<CellObject>();
        squares.add(new CellObject(xStart, yStart));
        currentDirection = direction.none;
    }

    /**
     * constructs new snake at the 0/0 coordinate.
     * <p>
     * The snake is one square in size and will not move.
     */
    public Snake() {
        this(0, 0);
    }

    /**
     * consumes the bonus and returns its value.
     *
     * @param food
     *            bonus
     * @return value of bonus
     */
    public int eat(FoodCell food) {
        grow();
        food.setTimeLeftZero();
        return food.getPointValue();
    }

    /**
     * returns the head of the snake.
     *
     * @return head of snake
     */
    public CellObject getHead() {
        return squares.get(0);
    }

    /**
     * if called, on next move the tail will not be removed, thus the snake
     * grows.
     */
    public void grow() {
        growingLeft++;
    }



    /**
     * moves snake in current direction. If it still has to grow the tail will
     * not be removed, otherwise it will. Then, a new square will be added to
     * the head.
     */
    public void moveInCurrentDirection() {
        addSquareToHead();
        if (squares.size() > 1) {
            removeSquareFromTail();
        }
    }

    /**
     * adds a square in front of the current head of the snake (in the direction
     * specified in currentDirection).
     */
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

    /**
     * returns true if the head is at the same position as any other square of
     * the snake.
     *
     * @return true if the head is at the same position as any other square of
     *         the snake
     */
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

    /**
     * removes the tail of the snake if the snake has more than one square.
     */
    private void removeSquareFromTail() {
        if (growingLeft > 0) {
            growingLeft--;
            return; // do not remove tail (grow)
        } else {
            squares.remove(squares.size() - 1); // remove tail
        }
    }

    /**
     * changes the current direction of the snake. On next
     * moveInCurrentDirection() the snake will move in this direction.
     */

    public void moveUp() {
        if (currentDirection != direction.down) { // it is not possible to move
            // in the opposite direction
            currentDirection = direction.up;
        }
    }

    /**
     * changes the current direction of the snake. On next
     * moveInCurrentDirection() the snake will move in this direction.
     */

    public void moveDown() {
        if (currentDirection != direction.up) { // it is not possible to move in
            // the opposite direction
            currentDirection = direction.down;
        }
    }

    /**
     * changes the current direction of the snake. On next
     * moveInCurrentDirection() the snake will move in this direction.
     */

    public void moveLeft() {
        if (currentDirection != direction.right) { // it is not possible to move
            // in the opposite direction
            currentDirection = direction.left;
        }
    }

    /**
     * changes the current direction of the snake. On next
     * moveInCurrentDirection() the snake will move in this direction.
     */

    public void moveRight() {
        if (currentDirection != direction.left) { // it is not possible to move
            // in the opposite direction
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
        // TODO this should be done more efficiently
        return squares.contains(new CellObject(x, y));
    }
}
