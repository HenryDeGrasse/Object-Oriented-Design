package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Class for a certain type of marble solitaire.
 * It is a different variation of marble solitaire
 * where the overall shape is a cross.
 */
public class EnglishSolitaireModel implements MarbleSolitaireModel {

  int armThickness;
  int validArmRoom;
  SlotState[][] board;
  int center;

  /**
   * constructor to create an english solitaire model.
   *
   * @param armThickness - The thickness of the arms of the board.
   * @param sRow         - The row position of the empty slot.
   * @param sCol         - the column position of the empty slot.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {
    if (armThickness % 2 == 0 || armThickness < 0) {
      throw new IllegalArgumentException("Invalid arm thickness");
    }
    this.armThickness = armThickness;
    this.validArmRoom = armThickness / 2;
    this.center = (this.armThickness * 3) / 2 - (3 / 2);
    if (!validPosition(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    } else {

      this.board = new SlotState[this.getBoardSize()][this.getBoardSize()];
      for (int row = 0; row < this.getBoardSize(); row++) {
        for (int col = 0; col < this.getBoardSize(); col++) {
          if (!validPosition(row, col)) {
            board[row][col] = SlotState.Invalid;
          } else if (col == sCol && row == sRow) {
            board[row][col] = SlotState.Empty;
          } else {
            board[row][col] = SlotState.Marble;
          }
        }
      }
    }

  }

  /**
   * Constructor with one argument putting the empty slot in
   * the center.
   * @param armThickness - Thickness of the arms of the board.
   */
  public EnglishSolitaireModel(int armThickness) {
    this(armThickness, (armThickness * 3) / 2 - (3 / 2), (armThickness * 3) / 2 - (3 / 2));
  }

  /**
   * Constructor with two arguments putting the armthickness at 3
   * and the empty location at sRow, sCol.
   * @param sRow - Row of the empty slot.
   * @param sCol - Column of the empty slot.
   */
  public EnglishSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Default constructor creating a board with arm thickness 3
   * and the empty location in the center.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Checks if a given position is valid both on the board and
   * whether the location is withing the cross or not.
   * @param row - row of the given position.
   * @param col - column of the given position.
   * @return - if the position is valid or not.
   */
  private boolean validPosition(int row, int col) {
    return (col >= 0 && row >= 0 && col < this.center - this.validArmRoom &&
            row >= this.center - this.validArmRoom &&
            row <= this.center + this.validArmRoom)
            || (col >= this.center - this.validArmRoom &&
            col <= this.center + this.validArmRoom)
            || (col > this.center + this.validArmRoom &&
            row >= this.center - this.validArmRoom &&
            row <= this.center + this.validArmRoom);
  }

  /**
   *  checks if a move is valid, a move is valid if:
   *  - The from and to positions are valid (within
   *  the borders of the board.)
   *  - The given "from" position must be a marble
   *  and the "to" position must be empty.
   *  - And the two positions must be exactly
   *  two positions away.
   *  - The slot between the two positions must also
   *  contain a marble.
   *  If these conditions are not met, then the move
   *  is not possible.
   *
   *
   * @param fromRow - the row that the possible move is coming from.
   * @param fromCol - the column that the possible move is coming from.
   * @param toRow - the row that the possible move is going to.
   * @param toCol - the column that the possible move is going to.
   * @return - whether the move is valid or not.
   */
  private boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (!validPosition(fromRow, fromCol) ||
            !validPosition(toRow, toCol)) {
      return false;

    } else if (!(this.getSlotAt(fromRow, fromCol).equals(SlotState.Marble)) ||
            !(this.getSlotAt(toRow, toCol).equals(SlotState.Empty))) {
      return false;

    } else if ((fromCol == toCol && Math.abs(toRow - fromRow) != 2) ||
            (fromRow == toRow && Math.abs(toCol - fromCol) != 2) ||
            (fromRow != toRow && fromCol != toCol)) {
      return false;
    } else if ((fromCol == toCol && Math.abs(toRow - fromRow) == 2) &&
            ((fromRow > toRow
                    && this.getSlotAt(fromRow - 1, fromCol).equals(SlotState.Marble)) ||
                    (toRow > fromRow
                            && this.getSlotAt(toRow - 1, fromCol).equals(SlotState.Marble)))) {
      return true;
    } else {
      return (fromRow == toRow && Math.abs(toCol - fromCol) == 2) &&
              ((fromCol > toCol && this.getSlotAt(fromRow, fromCol - 1).equals(SlotState.Marble)) ||
                      (toCol > fromCol
                              && this.getSlotAt(fromRow, toCol - 1).equals(SlotState.Marble)));
    }
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid (within
   * the borders of the board.) The given "from" position must be a marble
   * the "to" position must be empty. And the two positions must be exactly
   * two positions away. The slot between the two positions must also
   * contain a marble. If these conditions are not met, then the move
   * is not possible.
   * If these conditions are met,
   * The from location and middle location become empty
   * and the to location becomes a marble.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (validMove(fromRow, fromCol, toRow, toCol)) {
      if (fromCol == toCol && fromRow > toRow) {
        this.board[toRow][toCol] = SlotState.Marble;
        this.board[fromRow][fromCol] = SlotState.Empty;
        this.board[fromRow - 1][toCol] = SlotState.Empty;

      } else if (fromCol == toCol && toRow > fromRow) {
        this.board[toRow][toCol] = SlotState.Marble;
        this.board[fromRow][fromCol] = SlotState.Empty;
        this.board[toRow - 1][toCol] = SlotState.Empty;

      } else if (fromRow == toRow && fromCol > toCol) {
        this.board[toRow][toCol] = SlotState.Marble;
        this.board[fromRow][fromCol] = SlotState.Empty;
        this.board[toRow][fromCol - 1] = SlotState.Empty;

      } else if (fromRow == toRow && toCol > fromCol) {
        this.board[toRow][toCol] = SlotState.Marble;
        this.board[fromRow][fromCol] = SlotState.Empty;
        this.board[toRow][toCol - 1] = SlotState.Empty;
      }
    } else {
      throw new IllegalArgumentException("The given move is invalid.");
    }
  }


  /**
   * Checks if the game is over,
   * The game is over if there are no more possible moves on the board.
   * @return - boolean, if the game is over.
   */
  @Override
  public boolean isGameOver() {
    for (int row = 0; row < this.getBoardSize(); row++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
        if (row + 2 < this.getBoardSize()) {
          if (validMove(row, col, row + 2, col)) {
            return false;
          }
        }
        if (row > 2) {
          if (validMove(row, col, row - 2, col)) {
            return false;
          }
        }
        if (col + 2 < this.getBoardSize()) {
          if (validMove(row, col, row, col + 2)) {
            return false;
          }
        }
        if (col > 2) {
          if (validMove(row, col, row, col - 2)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * calculates the size of the longest row or column of the board.
   * @return - integer of the size.
   */
  @Override
  public int getBoardSize() {
    return this.armThickness + (2 * (this.armThickness - 1));
  }

  /**
   * Returns the type of piece at a slot.
   * @param row the row of the position sought, starting at 0.
   * @param col the column of the position sought, starting at 0.
   * @return - SlotState, either empty, marble or invalid.
   * @throws IllegalArgumentException if the given slot is off the board.
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row >= 0 && row < this.getBoardSize() && col >= 0 && col < this.getBoardSize()) {
      return board[row][col];
    } else {
      throw new IllegalArgumentException("Invalid given slot.");
    }
  }

  /**
   * finds the score of the game.
   * The score is determined by the amount of marbles left on the board.
   * @return int of the amount of marbles left.
   */
  @Override
  public int getScore() {
    int sum = 0;
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (this.getSlotAt(j, i).equals(SlotState.Marble)) {
          sum += 1;
        }
      }
    }
    return sum;
  }
}
