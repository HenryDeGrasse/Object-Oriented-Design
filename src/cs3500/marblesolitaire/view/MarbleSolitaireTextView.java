package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Class for showing marble solitaire in a text form.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  protected MarbleSolitaireModelState state;
  protected Appendable object;


  /**
   * Constuctor that takes two parameters: a state, and an appendable object.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state, Appendable object) {
    if (state == null || object == null)  {
      throw new IllegalArgumentException("One of the given states is null.");
    } else {
      this.state = state;
      this.object = object;
    }
  }

  /**
   * Constructor for creating a marble text view given a board state.
   *  The board cannot be null and if it is it will throw an
   *  Illegal argument exception
   * @param state - state of the given board
   */

  // TODO: Gotta do something with System.out
  public MarbleSolitaireTextView(MarbleSolitaireModelState state) {
    if (state == null) {
      throw new IllegalArgumentException("The given model state is null.");
    } else {
      this.state = state;
      this.object = System.out;
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

  /**
   * Renders the board and prints it out.
   * @throws IOException - If the board does not work
   */
  @Override
  public void renderBoard() throws IllegalArgumentException, IOException {
    for (int row = 0; row < this.state.getBoardSize(); row++) {
      for (int col = 0; col < this.state.getBoardSize(); col++) {
        if (this.state.getSlotAt(row, col).equals(MarbleSolitaireModelState.SlotState.Marble)) {
          if (col == 0) {
            this.object.append("O");
          } else {
            this.object.append(" O");
          }
        } else if (this.state.getSlotAt(row, col)
                .equals(MarbleSolitaireModelState.SlotState.Empty)) {
          if (col == 0) {
            this.object.append("_");
          } else {
            this.object.append(" _");
          }
        } else if (this.state.getSlotAt(row, col)
                .equals(MarbleSolitaireModelState.SlotState.Invalid)) {
          if (col < this.state.getBoardSize() / 2) {
            if (col == 0) {
              this.object.append(" ");
            } else {
              this.object.append("  ");
            }
          }
        }
      }
      if (row != this.state.getBoardSize() - 1) {
        this.object.append("\n");
      }
    }
    this.object.append("\n");
  }

  /**
   * Renders a message at the bottom of the Board.
   * @param message the message to be transmitted
   * @throws IOException - Throws exception if the message is null.
   */
  @Override
  public void renderMessage(String message) throws IOException {
    if (message == null) {
      throw new IOException("Message cannot be null.");
    } else {
      this.object.append(message);
    }
  }

}
