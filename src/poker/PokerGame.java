package poker;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;

public class PokerGame {
	private final SecureRandom randomNumbers = new SecureRandom();
	private Player[] players;
	private final int NUMBER_OF_CARDS = BigInteger.valueOf(52).intValue();
	private final Card[] deckOfCards = new Card[NUMBER_OF_CARDS];
	private boolean isCreated;
	
	public PokerGame(Player[] players){
		this.players = players;
	}
	
	public PokerGame(){
	
	}
	
	public void createPokerGame() {
		isCreated = true;
		String[] face = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		for (int index = 0; index < deckOfCards.length; index++) {
			deckOfCards[index] = new Card(face[index % 13], suits[index /13]);
		}
	}
	
	public boolean isCreated() {
		return isCreated;
	}
	
	public Player[] getPlayer() {
		return players;
	}
	
	public void setPlayer(Player[] player) {
		this.players = player;
	}
	
	public Card[] getDeckOfCards() {
		return deckOfCards;
	}
	
	public void startGame() {
		if (!isCreated)
			throw new PokerGameException("Game Does Not Exist Please Create A Game");
		if ( players == null || players.length < 2)
			throw new PokerGameException("Players Does not Exist:: Game must have at least 2 players");
		
	}
	public void shuffle() {
		int numberOfTimesToShuffle = randomNumbers.nextInt(BigInteger.valueOf(10).intValue());
		System.out.println("number of times to shuffle is: "+numberOfTimesToShuffle);
		for (int index = 0; index < numberOfTimesToShuffle; index++) {
			int indexOfFirstCardToShuffle = randomNumbers.nextInt(BigInteger.valueOf(51).intValue());
			int indexOfSecondCardToShuffle = randomNumbers.nextInt(BigInteger.valueOf(51).intValue());
			Card emptyContainer = deckOfCards[indexOfFirstCardToShuffle];
			deckOfCards[indexOfFirstCardToShuffle] = deckOfCards[indexOfSecondCardToShuffle];
			deckOfCards[indexOfSecondCardToShuffle] = emptyContainer;
			System.out.println("index of first card to shuffle is: "+indexOfFirstCardToShuffle);
			System.out.println("index of second card to shuffle is: "+indexOfSecondCardToShuffle);
		}
	}
	
	public boolean isShuffled(Card[] deckOfCardsBeforeShuffling, Card[] deckOfCardsAfterShuffling){
		int counter = 0;
		boolean isShuffled = false;
		while (counter < deckOfCardsAfterShuffling.length){
			if (deckOfCardsBeforeShuffling[counter] != deckOfCardsAfterShuffling[counter]) {
				isShuffled = true;
				break;
			}
			counter++;
		}
		System.out.println("Before:: "+Arrays.toString(deckOfCardsBeforeShuffling));
		System.out.println("After:: "+Arrays.toString(deckOfCardsAfterShuffling));
		System.out.println("isShuffled:: "+isShuffled);
		return isShuffled;
	}
}

