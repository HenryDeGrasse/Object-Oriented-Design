import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * A class to test the marble solitaire in a text view.
 */
public class MarbleSolitaireTextViewTest {

  private MarbleSolitaireView ex2;
  private MarbleSolitaireView ex4;
  private EnglishSolitaireModel ex5;
  private Appendable a1;

  @Before
  public void setUp() throws Exception {
    a1 = new StringBuilder();
    EnglishSolitaireModel ex1 = new EnglishSolitaireModel(3);
    ex2 = new MarbleSolitaireTextView(ex1, a1);
    EnglishSolitaireModel ex3 = new EnglishSolitaireModel(5);
    ex4 = new MarbleSolitaireTextView(ex3, a1);
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

  @Test
  public void testRenderBoard() throws IOException {
    ex2.renderBoard();
    assertEquals(
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O O O _ O O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O"
                    + "\n", a1.toString());
  }

  @Test
  public void testRenderBigBoard() throws IOException {
    ex4.renderBoard();
    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O"
            + "\n", a1.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    ex2.renderBoard();
    ex2.renderMessage("Score: 32");
    assertEquals(
             "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O O O _ O O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O\n"
                    + "Score: 32", a1.toString());
  }


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidToString() {
    MarbleSolitaireView ex6 = new MarbleSolitaireTextView(ex5);
    ex6.toString();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullRenderBoard() throws IllegalArgumentException, IOException {
    MarbleSolitaireView ex6 = new MarbleSolitaireTextView(ex5);
    ex6.renderBoard();
  }

  @Test(expected = IOException.class)
  public void testNullRenderMessage() throws IOException {
    String empty = null;
    ex2.renderMessage(empty);
  }
}