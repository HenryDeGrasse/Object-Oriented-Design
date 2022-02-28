package cs3500.marblesolitaire.view;

import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * A class to test the marble solitaire in a text view.
 */
public class MarbleSolitaireTextViewTest {

  private MarbleSolitaireView ex2;
  private MarbleSolitaireView ex4;
  private EnglishSolitaireModel ex5;

  @Before
  public void setUp() throws Exception {
    EnglishSolitaireModel ex1 = new EnglishSolitaireModel(3);
    ex2 = new MarbleSolitaireTextView(ex1);
    EnglishSolitaireModel ex3 = new EnglishSolitaireModel(5);
    ex4 = new MarbleSolitaireTextView(ex3);
  }

  @Test
  public void testToString() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", ex2.toString());

    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", ex4.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidToString() {
    MarbleSolitaireView ex6 = new MarbleSolitaireTextView(ex5);
  }
}
