package poker;

import java.math.BigInteger;

public class PokerGame {
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
}
