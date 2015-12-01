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
  public boolean addTerriory(Territory t){
    t.changeOwner(name);
  }
  public String getColour(){
    return colour;
  }
  public boolean addUnit(int units){
    numUnits = numUnits + units;
  }
  public int attack(Territory attacker, Territory defender){
    /*results should be automatically calculated once attack is initiated
    should automatically resolve unit placement afterwards too
    */
  }
  public int defend(){
    //un-needed? attack should be able to resolve the unit numbers and territories owned for both players.
  }
  public int moveUnits(){}
}

class Map{
  private ArrayList<String> territory;
  private ArrayList<String> continents;
  private int unitPerContinents = 0;
  private boolean cards = false;
  private String leader;

  Map(){
    territories = new ArrayList<>(Arrays.asList("Ukraine","Ireland","Russia",......));
    continents = new ArrayList<>(Arrays.asList("Africa","Europe","Asia",......));
    leader = null;
  }

  public boolean containsTerritory(String cont, String terr){
    return (territory.contains(terr) && continents.contains(cont))
  }

  public Deck createDeck(){
	return Deck deck = new Deck()
  }
  public void assignTerritories(Player playerName){
	  territoriesOwned++; //Increase the number of territories a player has by 1.
  }

  public void getReinforcements(){
	  if(Player.has("Europe"))
            Player.numUnits=player.numUnits+5;
	  if(Player.has("Asia"))
            Player.numUnits=player.numUnits+7;
    if(Player.has("South America"))
            Player.numUnits=player.numUnits+2;
    if(Player.has("North America"))
            Player.numUnits=player.numUnits+5;
    if(Player.has("Africa"))
            Player.numUnits=player.numUnits+3;
    if(Player.has("Australia"))
            Player.numUnits=player.numUnits+2;
  }

  public boolean isPlaying(Player player){
    return player.territoriesOwned != 0;
  }

  public String getLeader(){
    Player leader;
    for(int i=0; i<numplayers();i++){
      if(leader.score < player[i].score)
        leader = player[i]
    }
    return leader.name;
  }
}

class Territory{
  private String contient;
  private String owner;
  private int numUnits = 0;
  private String name;
  private LinkedList<String> adjacentTerritory;//not most effiecent way to do this

  Territory(String cntnt, String ownr, int unts, String nme, LinkedList<String> adjTrrtry) {
    continent = cntnt;
    owner = ownr;
    numUnits = unts;
    name = nme;
    adjacentTerritory = adjTrrtry;
  }

  public String getContinent() {
    return continent;
  }
  public String changeOwner(String newOwner) {
    String tmp = owner;
    owner = newOwner;
    return tmp;
  }

  public boolean isAdjacent(String name) {
    return adjacentTerritory.contains(name);
  }

  public String getOwner() {
    return owner;
  }
}
