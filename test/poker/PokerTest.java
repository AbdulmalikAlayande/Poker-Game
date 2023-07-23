package poker;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;
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
			assertThat(naijaWhot.getDeckOfCards().length).isEqualTo(52);
		}
		
		@Test void testThatPokerGameCardsCanBeShuffled(){
		
		}
		
		@Test void testThatCardCanBeDealtToPlayers(){
		
		}
		
	}
	
	@Nested class deckOfCardTest{
		
		@Test void testThatEachCardHasAFaceAndASuit(){
			PokerGame pokerGame = new PokerGame();
			pokerGame.createPokerGame();
			assertThat(pokerGame.getDeckOfCards().length).isEqualTo(52);
			for (int index = 0; index < pokerGame.getDeckOfCards().length; index++) {
				assertThat(pokerGame.getDeckOfCards()[index].getFace()).isNotNull();
				assertThat(pokerGame.getDeckOfCards()[index].getSuit()).isNotNull();
			}
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
