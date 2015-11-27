class Risk {
  public static void main (String [] args){
    //main instance intialise all objects
  }
}

class RiskCard{
  public String unitType;
  public String territory;
  public String owner;

  public String getUnit(){}
  public String getTerrioty(){}
  public String getOwner(){}
}

class Deck{
  RiskCard[] cards = new RiskCard[50];
  RiskCard[] discardPile = new RiskCard[50];

  public RiskCard draw(){}
  public void shuffle(){}
  public void discard(){}
}

class Player{
  public int coulour;
  public int numUnits = 0;
  public int territoryOwned = 0;
  public String name;
  RiskCard[] riskCard = new RiskCard[10];

  public String getName(){}
  public boolean addCard(){}
  public boolean addTerriory(){}
  public String getColour(){}
  public boolean addUnit(){}
  public int attack(){}
  public int defend(){}
  public int moveUnits(){}
}

class Map{
  public String territory;
  public String continents;
  public int unitPerContinents = 0;
  public boolean cards = false;
  public String leader;

  public boolean containsTerritory(){}
  public Deck createDeck(){}
  public void assignTerritories(){}
  public int getReinforcments(){}
  public boolean checkPlaying(){}
  public String getLeader(){}
}

class Territory{
  public String contient;
  public String owner;
  public int numUnits = 0;
  public String name;
  String[] adjacentTerritory = new String[10];//not most effiecent way to do this

  public String getContinent(){}
  public String changeOwner(){}
  public boolean isAsjacent(){}
  public String getOwner(){}
}
