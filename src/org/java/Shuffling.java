package org.java;

import java.util.Random;

public class Shuffling {

	public enum Type {
		SPADE(4),
		HEARTS(3),
		DIAMOND(2),
		COL(1);

		private int value;

		private Type(int val) {
			this.value = val;
		}

		public int getValue() {
			return this.value;
		}
	};

	public enum Suit {
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		JACK(11),
		QUEEN(12),
		KING(13),
		ACE(14);

		private int value;

		private Suit(int val) {
			this.value = val;
		}

		public int getValue() {
			return this.value;
		}
	}

	public class Deck {

		Card[] cards = new Card[52];

		public Deck() {
			for(int i=1, index=0; i<=4; ++i) {
				for( int j=2; j<=14; ++j) {
					cards[index++] = new Card(i,j);
				}
			}
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<52; ++i) {
				sb.append("Type: " + cards[i].type.getValue() + ", Suit: " + cards[i].suit.getValue() + ";\n");
			}
			return sb.toString();
		}

		public void shuffle() {
			for (int i=0; i<51; ++i) {
				Random rand = new Random();
				int temp = rand.nextInt(51-i)+i;
				Card t = cards[i];
				cards[i] = cards[temp];
				cards[temp] = t;
			}
		}

	}

	public class Card implements Comparable<Card> {

		@Override
		public int compareTo(Card arg0) {
			Card otherCard = arg0;
			return this.type.getValue() + this.suit.getValue() - otherCard.type.getValue() - otherCard.suit.getValue();
		}

		public Type type;
		public Suit suit;
		public Card(int type, int suit) {
			switch(type) {
			case 1: this.type = Type.COL;
			break;
			case 2: this.type = Type.DIAMOND;
			break;
			case 3: this.type = Type.HEARTS;
			break;
			case 4: this.type = Type.SPADE;
			break;
			}
			switch(suit) {
			case 2: this.suit = Suit.TWO;
			break;
			case 3: this.suit = Suit.THREE;
			break;
			case 4: this.suit = Suit.FOUR;
			break;
			case 5: this.suit = Suit.FIVE;
			break;
			case 6: this.suit = Suit.SIX;
			break;
			case 7: this.suit = Suit.SEVEN;
			break;
			case 8: this.suit = Suit.EIGHT;
			break;
			case 9: this.suit = Suit.NINE;
			break;
			case 10: this.suit = Suit.TEN;
			break;
			case 11: this.suit = Suit.JACK;
			break;
			case 12: this.suit = Suit.QUEEN;
			break;
			case 13: this.suit = Suit.KING;
			break;
			case 14: this.suit = Suit.ACE;
			break;
			}
		}
	}

	public static void main(String[] args) {
		Shuffling shf = new Shuffling();
		Deck deck = shf.new Deck();
		deck.shuffle();
		System.out.println(deck.toString());
	}

}
