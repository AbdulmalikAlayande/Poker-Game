package poker;

public class Player {
	
	private String playerName;
	private Card[] cards;
	public Player(){
	}
	public Player(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	
	public Card[] getCards() {
		return cards;
	}
	
	@Override
	public String toString() {
		return "Player{" + "playerName='" + playerName + '\'' +
				            '}';
	}
}
