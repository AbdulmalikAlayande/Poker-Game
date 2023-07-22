package poker;
/*   FACEs = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
 "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" */
/*SUITS = "Hearts", "Diamonds", "Clubs", "Spades"*/
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class PokerTest {
	
	@Nested class PokerGameTest{
		
		@Test void testThatPokerGameCanBeCreated(){
			PokerGame naijaWhot = new PokerGame();
			naijaWhot.createPokerGame();
			assertTrue(naijaWhot.isCreated());
			assertThat(naijaWhot.isCreated()).isTrue();
		}
		
		@Test void testThatGameExistsBeforeGameStarts(){
			PokerGame naijaWhot = new PokerGame();
			assertThatThrownBy(()-> naijaWhot.startGame())
					.isInstanceOf(PokerGameException.class)
					.hasMessageContaining("Game Does Not Exist Please Create A Game");
		}
		
		@Test void testThatGameMustHavePlayerBeforeGameStarts(){
			PokerGame naijaWhot = new PokerGame();
			naijaWhot.createPokerGame();
			assertThrowsExactly(PokerGameException.class, ()->naijaWhot.startGame(),
					"Players Does not Exist:: Game must have at least 2 players");
		}
		
		@Test void testThatGameMustHaveADeckOf52CardsBeforeGameStarts(){
			PokerGame naijaWhot = new PokerGame();
			naijaWhot.createPokerGame();
			Player mark = new Player("Mark");
			Player bolaji = new Player("Bolaji");
			Player[] players = new Player[]{mark, bolaji};
			naijaWhot.setPlayer(players);
			assertThatThrownBy(() -> naijaWhot.startGame())
					.isExactlyInstanceOf(PokerGameException.class)
					.hasMessageContaining("Game Does Not Have Any Card:: " +
							                      "Game should have a deck of 52 cards");
		}
		
		@Test void testThatPokerGameCardsCanBeShuffled(){
			
		}
		
		@Test void testThatCardCanBeDealtToPlayers(){
		
		}
		
//		@Test void
	}
	
	@Nested class deckOfCardTest{
		
		@Test void testThatDeckOfCardHas52Cards(){
		
		}
		
		@Test void testThatEachCardHasAFaceAndASuit(){
		
		}
		
		@DisplayName("Each Face has equal number of suits")
		@Test void testThatCardFacesAndSuitsAreSharedAccordingly(){
		
		}
	}
	
	@Nested class PokerGamePlayerTest{
		
		@Test void testThatPlayerExists(){
			Player player = new Player();
			assertNotNull(player);
			assertThat(player).isNotNull();
			assertThat(player).isInstanceOf(Player.class);
		}
		
		@Test void testThatPlayerNamesCanBeSet(){
			Player player = new Player();
			player.setPlayerName("Bj");
			assertEquals("Bj", player.getPlayerName());
		}
	}
}
