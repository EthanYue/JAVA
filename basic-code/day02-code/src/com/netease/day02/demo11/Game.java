package com.netease.day02.demo11;

import com.netease.util.printUtils;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    public static void main(String[] args) {
        Cards cards = new Cards();
        ArrayList<Card> poker = cards.getCards();
        System.out.print(poker);

        System.out.println();
        printUtils.print("=", 50);

        cards.shuffle();
        poker = cards.getCards();
        System.out.println(poker);

        Player A = new Player("A");
        A.setCards(cards.send(0));
        System.out.println(A);
        A.sortCards();
        System.out.println(A);

        Player B = new Player("B");
        B.setCards(cards.send(1));
        System.out.println(B);
        B.sortCards();
        System.out.println(B);

        Player C = new Player("C");
        C.setCards(cards.send(2));
        System.out.println(C);
        C.sortCards();
        System.out.println(C);

        TableCards tableCards = new TableCards();
        tableCards.setCards(cards.lastCards());
        System.out.println(tableCards);
    }
}


class Player {
    String name;
    ArrayList<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String toString() {
        return this.name + ": " + cards;
    }

    public void sortCards() {
        Collections.sort(cards);
    }
}


class TableCards {
    String name = "tableCards";
    ArrayList<Card> cards = new ArrayList<>();

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public String toString() {
        return this.name + ": " + cards;
    }

}


class Card implements Comparable<Card>{
    String color;
    int number;

    public Card(String color, int number) {
        this.color = color;
        this.number = number;
    }

    public String toString() {
        return this.color + this.number;
    }

    @Override
    public int compareTo(Card o) {
        return o.number - this.number;
    }
}


class Joker extends Card {
    public Joker(String color) {
        super(color, 14);
    }
}


class Cards {
    String[] colors;
    int[] numbers;
    ArrayList<Card> cards = new ArrayList<>();

    public Cards() {
        String[] colors = {"Spade", "Cube", "Heart", "Diamond"};
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        this.colors = colors;
        this.numbers = numbers;
        for (int i = 0; i < colors.length; i++) {
            for (int i1 = 0; i1 < numbers.length; i1++) {
                Card card = new Card(colors[i], numbers[i1]);
                this.cards.add(card);
            }
        }
        this.cards.add(new Joker("RedJoker"));
        this.cards.add(new Joker("BlackJoker"));
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public ArrayList<Card> send(int player) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < this.cards.size(); i++) {
            if (i < 51 && i % 3 == player) cards.add(this.cards.get(i));
        }
        return cards;
    }

    public ArrayList<Card> lastCards() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(this.cards.get(51));
        cards.add(this.cards.get(52));
        cards.add(this.cards.get(53));
        return cards;
    }
}

