package poker;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PokerGame {
	private final SecureRandom randomNumbers = new SecureRandom();
	private Player[] players;
	private final int NUMBER_OF_CARDS = BigInteger.valueOf(52).intValue();
	private Card[] deckOfCards = new Card[NUMBER_OF_CARDS];
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
		int numberOfTimesToShuffle = randomNumbers.nextInt(BigInteger.valueOf(51).intValue());
		for (int index = 0; index < numberOfTimesToShuffle; index++) {
			int indexOfFirstCardToShuffle = randomNumbers.nextInt(BigInteger.valueOf(51).intValue());
			int indexOfSecondCardToShuffle = randomNumbers.nextInt(BigInteger.valueOf(51).intValue());
			Card emptyContainer = deckOfCards[indexOfFirstCardToShuffle];
			deckOfCards[indexOfFirstCardToShuffle] = deckOfCards[indexOfSecondCardToShuffle];
			deckOfCards[indexOfSecondCardToShuffle] = emptyContainer;
		}
	}
	
	public boolean isShuffled(Card[] deckOfCardsBeforeShuffling){
		int counter = 0;
		boolean isShuffled = false;
		while (counter < deckOfCards.length){
			if (!(deckOfCardsBeforeShuffling[counter].equals(deckOfCards[counter]))) {
				isShuffled = true;
				break;
			}
			counter++;
		}
		System.out.println("counter was later "+counter);
		return isShuffled;
	}
	
	public void dealCard() {
		for (Player player : players) {
			player.setCards(fiveRandomCards());
		}
	}
	
	private Card[] fiveRandomCards() {
		Card[] generatedCards = new Card[BigInteger.valueOf(5).intValue()];
		for (int index = 0; index < generatedCards.length; index++) {
			int randomDeckIndex = randomNumbers.nextInt(BigInteger.valueOf(51).intValue());
			Card randomCard = deckOfCards[randomDeckIndex];
			generatedCards[index] = randomCard;
			Stream<Card> filtered = Arrays.stream(deckOfCards).filter(card -> card != randomCard);
			reassignDeckToFilteredCards(filtered);
		}
		return generatedCards;
	}
	
	private void reassignDeckToFilteredCards(Stream<Card> filtered) {
		int lengthOfFilteredCards = (int) filtered.count();
		Object[] filteredToArray = filtered.toArray();
		Card[] newDeck = new Card[lengthOfFilteredCards];
		for (int index = 0; index < newDeck.length; index++) {
			newDeck[index] = (Card) filteredToArray[index];
		}
		deckOfCards = newDeck;
	}
}

