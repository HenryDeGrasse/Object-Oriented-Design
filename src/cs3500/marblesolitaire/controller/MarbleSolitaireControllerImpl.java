package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * A class that implements a marble controller.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  MarbleSolitaireModel model;
  MarbleSolitaireView view;
  Readable in;

  /**
   * A Constructor that creates a controller.
   *
   * @param model - The model the controller controls.
   * @param view  - The view of the model.
   * @param in    - The input of the controller.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable in) {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("One of the given fields is null.");
    }

    this.model = model;
    this.view = view;
    this.in = in;

  }

  /**
   * Plays the game of marble solitaire.
   *
   * @throws IllegalArgumentException - If the input or output has an illegal input.
   */
  @Override
  public void playGame() throws IllegalArgumentException, IllegalStateException {
    Scanner scan = new Scanner(this.in);
    int[] inputs = new int[4];
    int l = 0;

    //Start game
    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }
    try {
      this.view.renderBoard();
      this.view.renderMessage("Score: " + this.model.getScore() + "\n");
    } catch (IOException i) {
      throw new IllegalStateException("Cannot transmit output");
    }

    //Run code while game is not over
    while (!this.model.isGameOver()) {

      //Until there are four good inputs for positions
      while (l < 4) {
        String temp;

        try {
          temp = scan.next();
        } catch (NoSuchElementException i) {
          throw new IllegalStateException("Ran out of inputs");
        }

        try {
          if (temp.toUpperCase().equals("Q")) {

            try {
              this.view.renderMessage("Game quit!\n");
              this.view.renderMessage("State of game when quit:\n");
              this.view.renderBoard();
              this.view.renderMessage("Score: " + this.model.getScore() + "\n");
              //Stops running the play game method
              return;
            } catch (IOException i) {
              throw new IllegalStateException("Cannot transmit output");
            }

            //if the given number is positive
          } else if (Integer.parseInt(temp) > 0) {
            inputs[l] = Integer.parseInt(temp) - 1;
            l++;
          } else {
            try {
              this.view.renderMessage("Please enter a valid input. (Positive int or Q)\n");
            } catch (IOException i) {
              throw new IllegalStateException("Ran into an error, cannot output.");
            }
          }
        } catch (NumberFormatException nfe) {
          try {
            this.view.renderMessage("Please enter a valid input. (Positive int or Q)\n");
          } catch (IOException i) {
            throw new IllegalStateException("Ran into an error, cannot output.");
          }
        }
      }
      try {
        try {
          model.move(inputs[0], inputs[1], inputs[2], inputs[3]);
          this.view.renderMessage("\n");
        } catch (IOException i) {
          throw new IllegalStateException("Ran into an error, cannot output.");
        }

      } catch (IllegalArgumentException i) {
        try {
          this.view.renderMessage("Invalid move. Please play again. Move must" +
                  " travel vertically or horizontally, "
                  + "must be exactly two spaces apart, must have an empty " +
                  "space in the TO position, "
                  + "a marble in the FROM position, and a marble in BETWEEN the two.\n\n");
        } catch (IOException o) {
          throw new IllegalStateException("Ran into an error, cannot output.");
        }
      }
      try {
        this.view.renderBoard();
        this.view.renderMessage("Score: " + model.getScore() + "\n");
      } catch (IOException i) {
        throw new IllegalStateException("Ran into an error, cannot output.");
      }
      l = 0;
    }

    scan.close();
    if (model.isGameOver()) {
      try {
        this.view.renderMessage("Game over!\n");
        this.view.renderBoard();
        this.view.renderMessage("Score: " + model.getScore() + "\n");
        return;
      } catch (IOException i) {
        throw new IllegalStateException("Ran into an error, cannot output.");
      }

    }
  }
}