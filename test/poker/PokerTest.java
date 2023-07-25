package poker;


import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

public class PokerTest {
	PokerGame naijaWhot;
	Player mark;
	Player bolaji;
	@BeforeEach void startAllTestWith(){
		mark = new Player("Mark");
		bolaji = new Player("Bolaji");
		naijaWhot = new PokerGame();
	}
	
	
	@Nested class PokerGameTest{

		@Test void testThatPokerGameCanBeCreated(){
			naijaWhot.createPokerGame();
			assertTrue(naijaWhot.isCreated());
			assertThat(naijaWhot.isCreated()).isTrue();
		}
		
		@Test void testThatGameExistsBeforeGameStarts(){
			assertThatThrownBy(naijaWhot::startGame)
					.isInstanceOf(PokerGameException.class)
					.hasMessageContaining("Game Does Not Exist Please Create A Game");
		}
		
		@Test void testThatGameMustHavePlayerBeforeGameStarts(){
			naijaWhot.createPokerGame();
			assertThrowsExactly(PokerGameException.class, naijaWhot::startGame,
					"Players Does not Exist:: Game must have at least 2 players");
		}
		
		@Test void testThatGameMustHaveADeckOf52CardsBeforeGameStarts(){
			naijaWhot.createPokerGame();
			Player[] players = new Player[]{mark, bolaji};
			naijaWhot.setPlayer(players);
			assertThat(naijaWhot.getDeckOfCards().length).isEqualTo(52);
		}
		
		@Disabled
		@Test void testThatPokerGameCardsCanBeShuffled(){
			naijaWhot.createPokerGame();
			Card[] deckOfCardsBeforeShuffling = naijaWhot.getDeckOfCards();
			naijaWhot.shuffle();
			assertThat(naijaWhot.isShuffled(deckOfCardsBeforeShuffling)).isTrue();
		}
		
		@Test void testThatCardCanBeDealtToPlayers(){
		
		}
		
	}
	
	@Nested class deckOfCardTest{
		
		@Test void testThatEachCardHasAFaceAndASuit(){
			naijaWhot.createPokerGame();
			assertThat(naijaWhot.getDeckOfCards().length).isEqualTo(52);
			for (int index = 0; index < naijaWhot.getDeckOfCards().length; index++) {
				assertThat(naijaWhot.getDeckOfCards()[index].getFace()).isNotNull();
				assertThat(naijaWhot.getDeckOfCards()[index].getSuit()).isNotNull();
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
