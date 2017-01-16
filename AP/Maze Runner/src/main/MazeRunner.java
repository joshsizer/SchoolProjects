package main;

public class MazeRunner {
  /**
   * Represents a direction (North, South, East, West), and holds the "sign" of the direction. For example,
   * in the 2D array reference frame, North would decrease the "y-index" by one, so its sign is -1.
   */
  public static enum Heading {
    NORTH(-1),
    SOUTH(1), 
    EAST(1), 
    WEST(-1);
    
    private Heading left;
    private Heading right;
    private Heading behind;
    
    private int inc;
    private Heading(int inc) {
      this.inc = inc;
    }
    
    public int getSign() {
      return inc;
    }
  }
  
  /** Simulates the maze using the left handed approach */
  public static final boolean LEFT_HANDED = true;
  /** Simulates the maze using the right handed approach */
  public static final boolean RIGHT_HANDED = false;
  
  /** Used for determining whether we have reaches one of the two base cases*/
  private int startx, starty, endx, endy;
  /** Whether the function <code>traverseMaze</code> has been called yet */
  private boolean started;
  
  /**
   * The default constructor for a MazeRunner
   */
  public MazeRunner(int startx, int starty, int endx, int endy) {
    this.startx = startx;
    this.starty = starty;
    this.endx = endx;
    this.endy = endy;
  }

  /**
   * Starts of the traversal of the maze.
   *
   * Precondition: the 2D maze is populated correctly and the start and end x and y point to the
   * correct start location
   * Postcondition: see the overloaded traverseMaze()
   * 
   * @param maze The 2D maze
   * @param heading The direction you are facing
   * @param hand Which hand to use to follow the wall
   */
  public void traverseMaze(char[][] maze, Heading heading, boolean hand) {
    traverseMaze(maze, startx, starty, heading, hand, 1);
  }
  
  /**
   * Precondition: The x and y are valid indices of maze and stage is a number between 0 and 3
   * inclusive.
   * Postcondition: After all methods have returned, the position of the X should be at the
   * entrance or exit of the maze.
   *
   * @param maze The 2d array of characters representing the maze
   * @param x The current x coordinate in the maze
   * @param y The current y coordinate in the maze
   * @param heading The current direction we are traveling
   * @param hand True for left hand approach, false for right hand approach.
   */
  public void traverseMaze(char[][] maze, int x, int y, Heading heading, boolean hand, int stage) {
    if (stage == 1) {
      char before = maze[y][x];
      maze[y][x] = 'X';
      printMaze(maze);
      maze[y][x] = before;
      System.out.println("\n------------------------\n");
    }
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // this means we have either gotten back to the start of the maze, or found the exit
    if (((x == this.endx && y == this.endy) || (x == this.startx && y == this.starty)) && started == true) {
      return;
    } else {
      /*
       * This entire process can be summed into a hierarchy. We will attempt to turn in the direction input by the
       * hand parameter. If we can not, then we try to move foward. If we cannot, then we try to move in the direction
       * opposite of the hand parameter. Only if all three of these fail, we will move back to where we came.
       */
      Heading desiredHeading;
      // Let's try to turn
      if (stage == 1) {
        if (hand == LEFT_HANDED) {
          desiredHeading = toTheLeft(heading);
        } else {
          desiredHeading = toTheRight(heading);
        }
      // Welp, we can't turn where we want, so let's go straight.
      } else if (stage == 2) {
        desiredHeading = heading;
      // Can't go straight either. Let's turn in the direction opposite of the hand parameter
      } else if (stage == 3 ){
        if (hand == LEFT_HANDED) {
          desiredHeading = toTheRight(heading);
        } else {
          desiredHeading = toTheLeft(heading);
        }
      // Okay, so we can't go foward, left, or right? Then let's go back the way we came, but with a different heading
      // than we started with.
      } else {
        desiredHeading = toTheLeft(toTheLeft(heading));
      }
      
      // tells us whether we should increment or decriment the index of the row or column we are interested in
      int move = desiredHeading.getSign();
      int desiredx, desiredy;
      
      /*
       * If we are going north or south, we must change the y-index. Other wise, we must change the x-index
       */
      if (desiredHeading == Heading.NORTH || desiredHeading == Heading.SOUTH) {
        desiredy = y + move;
        desiredx = x;
      } else {
        desiredx = x + move;
        desiredy = y;
      }
      
      /*
       * This simply checks if we are allowed to move in the direction that we want. This is 
       * determined by whether the index we want to travel in has a "#" or not. If it doesn't, then
       * we're good to move. Otherwise, we'll call this function again, but try to head in the next
       * desirable direction (indicated by the value of stage).
       */
      if (maze[desiredy][desiredx] != '#') {
        started = true;
        traverseMaze(maze, desiredx, desiredy, desiredHeading, hand, 1);
      } else {
        traverseMaze(maze, x, y, heading, hand, stage + 1);
      }
    }
  }
  
  /**
   * Returns the heading that is left of the input heading
   * @param heading The current heading
   * @return The heading to the left
   */
  private Heading toTheLeft(Heading heading) {
    switch (heading) {
      case NORTH:
        return Heading.WEST;
      case EAST:
        return Heading.NORTH;
      case SOUTH:
        return Heading.EAST;
      case WEST:
        return Heading.SOUTH;
      default:
          return Heading.EAST;
    }
  }
  
  private Heading toTheRight(Heading heading) {
    switch (heading) {
      case NORTH:
        return Heading.EAST;
      case EAST:
        return Heading.SOUTH;
      case SOUTH:
        return Heading.WEST;
      case WEST:
        return Heading.NORTH;
      default:
          return Heading.WEST;
    }
  }

  /**
   * Prints the specified 2D array
   *
   * Precondition: maze is not null
   *
   * @param maze The maze to print
   */
  public static void printMaze(char[][] maze) {
    for (int x = 0; x < maze.length; x++) {
      for (int y = 0; y < maze[0].length; y++) {
        System.out.print(maze[x][y] + "  ");
      }
      System.out.println();
    }
  }
}
