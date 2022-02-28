import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import java.io.IOException;
import java.io.StringReader;

/**
 * A class to test the controller implementation.
 */
public class MarbleSolitaireControllerImplTest {

  private Appendable a1;
  private MarbleSolitaireView view;
  private MarbleSolitaireModel model;
  private MarbleSolitaireView viewBig;
  private MarbleSolitaireModel modelBig;

  @Before
  public void setup() {
    a1 = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, a1);
    modelBig = new EnglishSolitaireModel(5);
    viewBig = new MarbleSolitaireTextView(modelBig, a1);
  }

  @Test
  public void testGameOver() throws IOException {
    Readable r1 = new StringReader("6 4 4 4   3 4 5 4    1 4 3 4   4 6 4 4   4 3 4 5   4 1 4 3");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals(
            "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O _ O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 30\n"
            + "\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 29\n"
            + "\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 28\n"
            + "\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O _ _ O _ O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 27\n"
            + "\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "_ _ O _ O _ O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 26\n"
            + "Game over!\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "_ _ O _ O _ O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 26"
            + "\n", a1.toString());

  }


  @Test
  public void testQuitQ() throws IOException {
    Readable r1 = new StringReader("6 4 4 4 Q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31"
            + "\n", a1.toString());
  }

  @Test
  public void testQuitq() throws IOException {
    Readable r1 = new StringReader("6 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31"
            + "\n", a1.toString());
  }


  @Test
  public void testMoveLeft() throws IOException {
    Readable r1 = new StringReader("4 6 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31"
            + "\n", a1.toString());

  }

  @Test
  public void testMoveRight() throws IOException {
    Readable r1 = new StringReader("4 2 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31"
            + "\n", a1.toString());

  }

  @Test
  public void testMoveRightLarge() throws IOException {
    Readable r1 = new StringReader("7 13 9 13   7 5 7 7 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(modelBig,viewBig, r1);
    controller.playGame();
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
            + "        O O O O O\n"
            + "Score: 104\n"
            + "Invalid move. Please play again. Move must travel vertically or "
            + "horizontally, must be exactly two spaces apart, must have an empty "
            + "space in the TO position, a marble in the FROM position, "
            + "and a marble in BETWEEN the two.\n"
            + "\n"
            + "        O O O O O\n"
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
            + "        O O O O O\n"
            + "Score: 104\n"
            + "\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O _ _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "Score: 103\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O _ _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "Score: 103"
            + "\n", a1.toString());

  }


  @Test
  public void testMoveDown() throws IOException {
    Readable r1 = new StringReader("2 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "\n"
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31"
            + "\n", a1.toString());

  }


  @Test
  public void testMoveUp() throws IOException {
    Readable r1 = new StringReader("6 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31"
            + "\n", a1.toString());

  }


  @Test
  public void testEndGameDifferentWay() throws IOException {
    Readable r1 = new StringReader("2 4 4 4   5 4 3 4   7 4 5 4   4 6 4 4   4 3 4 5   4 1 4 3");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "\n"
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "\n"
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O _ O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 30\n"
            + "\n"
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "Score: 29\n"
            + "\n"
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "Score: 28\n"
            + "\n"
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O _ _ O _ O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "Score: 27\n"
            + "\n"
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "_ _ O _ O _ O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "Score: 26\n"
            + "Game over!\n"
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "_ _ O _ O _ O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "Score: 26"
            + "\n", a1.toString());
  }

  //Test null cases.
  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() throws IOException {
    Readable r1 = new StringReader("2 4 4 4 q");
    MarbleSolitaireModel model = null;
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
  }

  //A few tests different errors, or bad inputs.

  @Test(expected = IllegalStateException.class)
  public void testNegativeNumberInput() throws IOException {
    Readable r1 = new StringReader("-5");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testEmptySpace() throws IOException {
    Readable r1 = new StringReader("");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testSingleLetter() throws IOException {
    Readable r1 = new StringReader("A");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testBadInput() throws IOException {
    Readable r1 = new StringReader("hello");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testNoMoreInputs() throws IOException {
    Readable r1 = new StringReader("6 4 4 8");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
  }

  @Test
  public void testFewMovesThenQuit() throws IOException {
    Readable r1 = new StringReader("6 4 4 4   3 4 5 4    1 4 3 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O _ O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 30\n"
            + "\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 29\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O _ O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 29"
            + "\n", a1.toString());
  }

  @Test
  public void testGoodInputMixedWithBad() throws IOException {
    Readable r1 = new StringReader("6 -8 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Please enter a valid input. (Positive int or Q)\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31"
            + "\n", a1.toString());

  }

  @Test
  public void testSidewaysInputMixedWithBad() throws IOException {
    Readable r1 = new StringReader("4 6 ood 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Please enter a valid input. (Positive int or Q)\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31"
            + "\n", a1.toString());
  }

  @Test
  public void testAnotherDirectionMixedWithBadInput() throws IOException {
    Readable r1 = new StringReader("2 4 4 ofkwjWQq 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Please enter a valid input. (Positive int or Q)\n"
            + "\n"
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31"
            + "\n", a1.toString());
  }

  @Test
  public void testVerticalBadStartingInput() throws IOException {
    Readable r1 = new StringReader("-2 6 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Please enter a valid input. (Positive int or Q)\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31"
            + "\n", a1.toString());

  }

  @Test
  public void testSidewaysBadStartingInput() throws IOException {
    Readable r1 = new StringReader("4 e 6 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model,view, r1);
    controller.playGame();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Please enter a valid input. (Positive int or Q)\n"
            + "\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31"
            + "\n", a1.toString());

  }

}
