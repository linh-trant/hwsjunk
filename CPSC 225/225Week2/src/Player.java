import java.util.ArrayList;

public class Player {
	private ArrayList<Card> hand = new ArrayList<Card>();	
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public Card getCard(int a) {
		return hand.get(a);
	}

	public Player() {
		for (int i = 0 ; i < 5; i++) {
			this.draw();
		}
	}
	
	public void draw() {
		int value = (int)(Math.random()*13);
		int color = (int)(Math.random()*5);
		while (value == 11) value = (int)(Math.random()*13);
		
		if (color == Card.BLACK) {
			value = -1;
		}
		
		if (color == Card.BLACK) value = -1;
		Card card = new Card();
		card.value = value;
		card.color = color;
		
		hand.add(card);
	}
	
	public void addCard(Card c) {
		hand.add(c);
	}	
}
