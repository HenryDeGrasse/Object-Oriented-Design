package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Class for showing marble solitaire in a text form.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  MarbleSolitaireModelState state;

  /**
   * Constructor for creating a marble text view given a board state.
   *  The board cannot be null and if it is it will throw an
   *  Illegal argument exception
   * @param state - state of the given board
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state) {

    if (state == null) {
      throw new IllegalArgumentException("The given model state is null.");
    } else {
      this.state = state;
    }
  }


  /**
   * Formats the board in a string format where there are
   * no more spaces after the last item on each row.
   * @return - String in a formatted form.
   */
  @Override
  public String toString() {
    String board = "";
    for (int row = 0; row < this.state.getBoardSize(); row++) {
      for (int col = 0; col < this.state.getBoardSize(); col++) {
        if (this.state.getSlotAt(row, col).equals(MarbleSolitaireModelState.SlotState.Marble)) {
          if (col == 0) {
            board += "O";
          } else {
            board += " O";
          }
        } else if (this.state.getSlotAt(row, col)
                .equals(MarbleSolitaireModelState.SlotState.Empty)) {
          if (col == 0) {
            board += "_";
          } else {
            board += " _";
          }
        } else if (this.state.getSlotAt(row, col)
                .equals(MarbleSolitaireModelState.SlotState.Invalid)) {
          if (col < this.state.getBoardSize() / 2) {
            if (col == 0) {
              board += " ";
            } else {
              board += "  ";
            }
          }
        }
      }
      if (row != this.state.getBoardSize() - 1) {
        board += "\n";
      }
    }
    return board;
  }
}
