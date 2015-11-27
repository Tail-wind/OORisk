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
    return unitType;
  }
  public String getTerrioty(){
    return territory;
  }
  public String getOwner(){
    return owner;
  }
  public void setOwner(Player p){
    this.owner=p.getName();
  }
  public void setOwner(String s){
    this.owner=s;
  }
}

class Deck{
  private int size;
  private RiskCard[] cards;
  private RiskCard[] discardPile;

  public Deck(String filename){
    /*reads JSON array from file provided in filename,
    Initializes the cards and discardPile lists
    Initializes the individual cards and places them into the card list.*/
    LinkedList cards = new LinkedList();
    LinkedList discardPile = new LinkedList();
  }

  public RiskCard draw(){
    //returns a random card from the cards array
    return cards.remove(randomWithRange(0,cards.size()-1));
  }
  public void shuffle(){
    //takes all of the cards in the discardPile, adds them to the cards array, and randomizes the order
    int j = discardPiles.size();
    for(int i = 0; i < j; i++){
      cards.add(discardPile.remove());
    }
    LinkedList temp = new LinkedList();
    j = cards.size();
    for(int i = 0; i < j; i++){
      temp.add(cards.remove(randomWithRange(0,cards.size()-1)));
    }
    cards = temp;
  }
  public void discard(RiskCard c){
    //takes a card object owned by a player and moves it to the discard pile
    c.setOwner(null);
    discardPile.add(c);
    //should auto set card owner to null
  }
  private int randomWithRange(int min, int max)
  {
     int range = (max - min) + 1;
     return (int)(Math.random() * range) + min;
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
