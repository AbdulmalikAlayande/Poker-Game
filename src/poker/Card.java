package poker;

import java.util.Objects;

public class Card {
	private String face;
	private String suit;
	
	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}
	
	public String getFace() {
		return face;
	}
	
	public void setFace(String face) {
		this.face = face;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public boolean equals(Object object){
		if (object.getClass() != this.getClass()) return false;
		Card card = (Card) object;
		return Objects.equals(card.face, this.face) && Objects.equals(card.suit, this.suit);
	}
}
