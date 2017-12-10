package com.example.jake.cardcounting.service;

import android.util.Log;

/**
 * Created by jake on 12/8/17.
 */

public class CardCounter {

    private double twoThroughSix = 1;
    private double sevenThroughNine = 0;
    private double tenPlus = -1;
    private double ace = -1;
    private double runningTotal;
    private double numberOfDecks = 1;
    private double cardsTwoThroughSix = 20.0;
    private double cardsSevenThroughNine = 12.0;
    private double cardsTenPlus = 16.0;
    private double cardsAce = 4.0;
    private double totalCards = 52.0;
    private double cardsDrawn;
    private Boolean bet = false;

    public CardCounter() {
        super();
    }

    public double getTwoThroughSix() {
        return twoThroughSix;
    }

    public void setTwoThroughSix(double twoThroughSix) {
        this.twoThroughSix = twoThroughSix;
    }

    public double getSevenThroughNine() {
        return sevenThroughNine;
    }

    public void setSevenThroughNine(double sevenThroughNine) {
        this.sevenThroughNine = sevenThroughNine;
    }

    public double getTenPlus() {
        return tenPlus;
    }

    public void setTenPlus(double tenPlus) {
        this.tenPlus = tenPlus;
    }

    public double getAce() {
        return ace;
    }

    public void setAce(double ace) {
        this.ace = ace;
    }

    public double getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(double runningTotal) {
        this.runningTotal = runningTotal;
    }

    public double getNumberOfDecks() {
        return numberOfDecks;
    }

    public void setNumberOfDecks(double numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
        this.setNumberOfCards(numberOfDecks);
    }

    public double getCardsTwoThroughSix() {
        return cardsTwoThroughSix;
    }

    public void setCardsTwoThroughSix(double cardsTwoThroughSix) {
        this.cardsTwoThroughSix = cardsTwoThroughSix;
    }

    public double getCardsSevenThroughNine() {
        return cardsSevenThroughNine;
    }

    public void setCardsSevenThroughNine(double cardsSevenThroughNine) {
        this.cardsSevenThroughNine = cardsSevenThroughNine;
    }

    public double getCardsTenPlus() {
        return cardsTenPlus;
    }

    public void setCardsTenPlus(double cardsTenPlus) {
        this.cardsTenPlus = cardsTenPlus;
    }

    public double getCardsAce() {
        return cardsAce;
    }

    public void setCardsAce(double cardsAce) {
        this.cardsAce = cardsAce;
    }

    public double getTotalCards() {
        return totalCards;
    }

    public void setTotalCards(double totalCards) {
        this.totalCards = totalCards;
    }

    public double getCardsDrawn() {
        return cardsDrawn;
    }

    public void setCardsDrawn(double cardsDrawn) {
        this.cardsDrawn = cardsDrawn;
    }

    public Boolean getBet() {
        return this.bet;
    }

    private void setBet(Boolean bet) {
        this.bet = bet;
    }

    private double trueCount() {
       return this.getRunningTotal() / this.getNumberOfDecks();
    }

    private void setNumberOfCards(double numberOfDecks) {
        this.setCardsTwoThroughSix(this.cardsTwoThroughSix * numberOfDecks);
        this.setCardsSevenThroughNine(this.cardsSevenThroughNine * numberOfDecks);
        this.setCardsTenPlus(this.cardsTenPlus * numberOfDecks);
        this.setCardsAce(this.cardsAce * numberOfDecks);
        this.setTotalCards(this.totalCards * numberOfDecks);
    }

    public void drawTwoThroughSix() {
        this.runningTotal++;
        this.cardsTwoThroughSix--;
        this.totalCards--;
        this.cardsDrawn++;
        this.checkNumberOfDecks();
    }

    public void drawSevenThroughNine() {
        this.cardsSevenThroughNine--;
        this.totalCards--;
        this.cardsDrawn++;
        this.checkNumberOfDecks();
    }

    public void drawTenPlusOrAce() {
        this.cardsTenPlus--;
        this.totalCards--;
        this.runningTotal--;
        this.cardsDrawn++;
        this.checkNumberOfDecks();
    }

    public String mathematicalRunningTotal() {
        double twoSix = this.getCardsTwoThroughSix();
        double sevenNine = this.getCardsSevenThroughNine();
        double tenPlus = this.getCardsTenPlus();
        double ace = this.getCardsAce();
        Log.d("twoSix", "twoSix: " + Double.toString(twoSix));
        Log.d("sevenNine", "sevenNine: " + Double.toString(sevenNine));
        Log.d("tenPlus", "tenPlus: " + Double.toString(tenPlus));
        Log.d("ace", "ace: " + Double.toString(ace));
        Log.d("cardsDrawn", "cardsDrawn: " + Double.toString(this.getCardsDrawn()));
        Log.d("totalCards", "totalCards: " + Double.toString(this.getTotalCards()));
        double result = (twoSix + sevenNine + tenPlus + ace);
        return Double.toString(Math.round(result * 100d) / 100d);
    }

    public String betOrNot() {
        String result;
        if (this.trueCount() >= 1.0) {
            this.setBet(true);
            result = "Bet";
        } else {
            this.setBet(false);
            result = "Don't Bet";
        }
        return result;
    }

    public String getCharRunningTotal() {
        String rt = Double.toString(Math.round(this.trueCount()));
        Log.d("true count", "trueCount: " + this.trueCount());
        return rt;
    }

    public void newGame() {
        this.setRunningTotal(0);
    }

    private void checkNumberOfDecks() {
        if (this.cardsDrawn == 52) {
            this.numberOfDecks--;
            this.setCardsDrawn(0.0);
            Log.d("decks", "num of decks: " + this.numberOfDecks);
        }
    }
}
