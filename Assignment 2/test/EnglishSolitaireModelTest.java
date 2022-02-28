import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * class that allows you to test the english solitaire model.
 */
public class EnglishSolitaireModelTest {

  private EnglishSolitaireModel ex;
  private EnglishSolitaireModel ex0;
  private EnglishSolitaireModel ex1;
  private EnglishSolitaireModel ex2;
  private EnglishSolitaireModel ex3;
  private EnglishSolitaireModel ex8;
  private EnglishSolitaireModel ex9;

  @Before
  public void setUp() throws Exception {

    ex = new EnglishSolitaireModel();
    ex1 = new EnglishSolitaireModel(3);
    ex0 = new EnglishSolitaireModel(3);
    ex0.move(5, 3, 3, 3);
    ex2 = new EnglishSolitaireModel(5);
    ex3 = new EnglishSolitaireModel(7);
    ex8 = new EnglishSolitaireModel(3,2);
    ex9 = new EnglishSolitaireModel(3,2,4);

  }

  @Test
  public void testConstructor() {
    //testing constructor with none constructors
    MarbleSolitaireTextView ex20 = new MarbleSolitaireTextView(ex);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", ex20.toString());


    //Testing constructor with two arguments
    MarbleSolitaireTextView ex21 = new MarbleSolitaireTextView(ex8);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", ex21.toString());

    //Tests constructor with one argument
    MarbleSolitaireTextView ex12 = new MarbleSolitaireTextView(ex1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", ex12.toString());

    //Tests constructor with three arguments
    MarbleSolitaireTextView ex13 = new MarbleSolitaireTextView(ex9);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", ex13.toString());
  }

  @Test
  public void move() {
    ex1.move(5, 3, 3, 3);
    MarbleSolitaireTextView ex10 = new MarbleSolitaireTextView(ex1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O", ex10.toString());

    ex1.move(4, 1, 4, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "    O _ O\n" +
            "    O O O", ex10.toString());

    ex1.move(2, 2, 4, 2);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O _ O O O O\n" +
            "O O _ O O O O\n" +
            "O _ O O O O O\n" +
            "    O _ O\n" +
            "    O O O", ex10.toString());


    ex1.move(2, 4, 2, 2);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O _ _ O O\n" +
            "O O _ O O O O\n" +
            "O _ O O O O O\n" +
            "    O _ O\n" +
            "    O O O", ex10.toString());


    ex3.move(11,9,9,9);
    MarbleSolitaireTextView ex11 = new MarbleSolitaireTextView(ex3);
    assertEquals("            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O", ex11.toString());
  }

  @Test
  public void isGameOver() {
    assertEquals(false, this.ex1.isGameOver());
    ex1.move(5, 3, 3, 3);
    ex1.move(4, 5, 4, 3);
    ex1.move(3, 3, 5, 3);
    ex1.move(6, 4, 4, 4);
    ex1.move(6, 2, 6, 4);
    ex1.move(4, 2, 6, 2);
    ex1.move(4, 0, 4, 2);
    ex1.move(2, 0, 4, 0);
    ex1.move(3, 1, 3, 3);
    assertEquals(false, this.ex1.isGameOver());
    ex1.move(3, 4, 3, 2);
    ex1.move(3, 6, 3, 4);
    ex1.move(2, 2, 2, 0);
    ex1.move(3, 2, 5, 2);
    ex1.move(6, 2, 4, 2);
    ex1.move(3, 4, 5, 4);
    ex1.move(6, 4, 4, 4);
    ex1.move(1, 3, 3, 3);
    ex1.move(0, 2, 2, 2);
    ex1.move(0, 4, 0, 2);
    ex1.move(2, 4, 0, 4);
    ex1.move(2, 6, 2, 4);
    assertEquals(true, this.ex1.isGameOver());
  }

  @Test
  public void getBoardSize() {
    assertEquals(7, ex1.getBoardSize());
    assertEquals(13, ex2.getBoardSize());
    assertEquals(19, ex3.getBoardSize());
  }

  @Test
  public void getSlotAt() {
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Marble, ex1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, ex1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, ex1.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, ex2.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, ex2.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, ex2.getSlotAt(4, 10));

  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalStuff() {

    //Illegal get slot
    //Negative slots
    ex1.getSlotAt(-2, 1);
    ex1.getSlotAt(-2, -2);
    ex1.getSlotAt(2, -2);
    //Slots too far off board
    ex1.getSlotAt(8, -2);
    ex1.getSlotAt(8, 16);
    ex1.getSlotAt(2, 100);

    //Illegal constructors
    //1 argument
    ex0 = new EnglishSolitaireModel(2);
    ex0 = new EnglishSolitaireModel(-2);
    //2 argumeents
    ex0 = new EnglishSolitaireModel(-2, -10);
    ex0 = new EnglishSolitaireModel(-2, 10);
    //3 arguments
    ex0 = new EnglishSolitaireModel(3, 0, 0);
    ex0 = new EnglishSolitaireModel(-2, 1, 1);

    //Illegal Moves:

    //Invalid Slots
    ex1.move(0, 1, 0, 0);
    ex1.move(0,0,0,2);
    ex1.move(0,2,0,0);
    //Move from a place that doesn't exist
    ex1.move(-6,3,-4,3);
    //Only One space away
    ex1.move(3, 3, 3, 2);
    //Marble to marble over marble
    ex1.move(4, 2, 2, 2);
    //Empty to marble
    ex1.move(3,3,1,3);
    //Marble to marble over empty
    ex1.move(3, 2, 3, 4);
    //Diagonal Jump
    ex1.move(1, 2, 3, 4);
    ex1.move(5,5,3,3);
    //Invalid whole board
    ex0.move(6, 3, 4, 3);
    //jump further than two spaces
    ex1.move(3, 5, 3, 1);
    //Move from marble to invalid position
    ex1.move(1,2,-1,2);
    //marble to empty over empty
    ex0.move(6,3,4,3);
  }


  @Test
  public void getScore() {
    assertEquals(32, ex1.getScore());
    ex1.move(5,3,3,3);
    assertEquals(31, ex1.getScore());

    assertEquals(104, ex2.getScore());
    assertEquals(216, ex3.getScore());
  }
}