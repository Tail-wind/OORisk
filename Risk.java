class Risk {
  public static void main (String [] args){
    //main instance intialise all objects
  }
}

class RiskCard{
  private String unitType;
  private String territory;
  private String owner;

  public RiskCard(String unitType, String territory){
    this.unitType=unitType;
    this.territory=territory;
    owner=null;
  }

  public String getUnit(){
    //returns the unit type of this card instance
  }
  public String getTerrioty(){
    //returns the territory on this card instance
  }
  public String getOwner(){
    //gets the current owner of this card
  }
  public String setOwner(){
    //used to reset the owner to null when the card is discarded
  }
}

class Deck{
  private RiskCard[] cards = new RiskCard[42];
  private RiskCard[] discardPile = new RiskCard[42];

  public RiskCard draw(){
    //returns a random card from the cards array
  }
  public void shuffle(){
    //takes all of the cards in the discardPile, adds them to the cards array, and randomizes the order
  }
  public void discard(){
    //takes a card object owned by a player and moves it to the discard pile
  }
}

class Player{
  private int colour;
  private int numUnits = 0;
  private int territoryOwned = 0;
  private String name;
  private ArrayList riskCard = new ArrayList();

  public String getName(){
    return name;
  }
  public boolean addCard(Deck d){
    riskCard.add(d.draw());
  }
  public boolean addTerriory(){}
  public String getColour(){
    return colour;
  }
  public boolean addUnit(int units){
    numUnits = numUnits + units;
  }
  public int attack(Territory attacker, Territory defender){
    /*needs attacker input on how many units to use
    results should be automatically calculated once attack is initiated
    should automatically resolve unit placement afterwards too
    */
  }
  public int defend(){
    //un-needed? attack should be able to resolve the unit numbers and territories owned for both players.
  }
  public int moveUnits(){}
}

class Map{
  private String territory;
  private String continents;
  private int unitPerContinents = 0;
  private boolean cards = false;
  private String leader;

  public boolean containsTerritory(){}
  public Deck createDeck(){}
  public void assignTerritories(){}
  public int getReinforcments(){}
  public boolean checkPlaying(){}
  public String getLeader(){}
}

class Territory{
  private String contient;
  private String owner;
  private int numUnits = 0;
  private String name;
  private String[] adjacentTerritory = new String[10];//not most effiecent way to do this

  public String getContinent(){}
  public String changeOwner(){}
  public boolean isAsjacent(){}
  public String getOwner(){}
}
