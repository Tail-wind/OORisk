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

class Buffer{
	private boolean roomAvailable = true;
	private boolean dataAvailable = false;
	private int occupied = 0;
	private int size;
	private int nextIn = 0;
	private int nextOut = 0;
	private String[] buffer;

	public Buffer(int size){
		this.size = size;
		buffer = new String[size];
	}

	public synchronized void add(String data) throws InterruptedException{
		while(!roomAvailable)
			wait();
		buffer[nextIn] = data;
		nextIn = (nextIn + 1)%size;
		dataAvailable = true;
		occupied++;
		if(occupied == size)
			roomAvailable = false;
		notifyAll();
	}

	public synchronized String remove() throws InterruptedException{
		while(!dataAvailable)
			wait();
		String data = buffer[nextOut];
		nextOut = (nextOut + 1)%size;
		roomAvailable = true;
		occupied--;
		if(occupied == 0)
			dataAvailable = false;
		notifyAll();
		return data;
	}
}


class ClientReader implements Runnable{
	private Socket socket = null;
	private Buffer buffer;
	private Vector<String> usernames;
	PrintWriter out;
	BufferedReader in;

	public ClientReader(Socket socket, Buffer buffer, Vector<String> usernames){ //this is a producer
		this.socket = socket;
		this.buffer = buffer;
		this.usernames = usernames;
		try{
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}catch(IOException b){
			System.out.println("Error creating printwriter or bufferedreader");
		}
	}

	public void run(){
		try{
			String user = in.readLine();
			usernames.add(user);
			System.out.println(user + " has connected.");
			String inputLine;
			buffer.add(user + " Connected");
			socket.setKeepAlive(true);
			socket.setSoTimeout(60000);
			//add the next input to the buffer
			while ((inputLine = in.readLine()) != null) {
				buffer.add(user + ": " + inputLine);
				if (out.checkError()){
					buffer.add(user + " has disconnected...");
					System.out.println("ClientReader shuting down");
					return;//Shut down this thread, remove the socket and username
				}
			}
		}catch(IOException c){
			System.out.println("ClientReader shuting down");
			return;
		}catch(InterruptedException e) {
			System.out.println("Error running ClientReader");
		}
	}
}

class ClientWriter implements Runnable{
	private Buffer buffer;
	private Vector<Socket> clients;
	private Vector<String> usernames;

	public ClientWriter(Buffer b, Vector<Socket> c, Vector<String> u){
		this.buffer = b;
		this.clients = c;
		this.usernames = u;
	}

	public void run(){
		try{
			while(true)
			{
				//if there is a message
				//extract message
				//for each socket, make a printwriter to send the message
				String message = buffer.remove();
				for(int i = 0; i < clients.size(); i++){
					Socket temp = clients.elementAt(i);
					PrintWriter out = new PrintWriter(temp.getOutputStream(), true);
					out.println(message);
				}
				System.out.println(message); //serverside record
			}
		}catch(InterruptedException c){
			System.out.println("ClientWriter shuting down");
			return;
		}catch(IOException e) {
			System.out.println("Error running ClientWriter");
		}
	}
}

public class ChatServer
{
	public static void main(String [] args)
	{
		int port = 7777;

		Buffer buffer = new Buffer(10);
		Vector<Socket> clients = new Vector<Socket>();
		Vector<String> user = new Vector<String>();
		Vector<Thread> readers = new Vector<Thread>();

		Thread writer = new Thread(new ClientWriter(buffer, clients, user));
		writer.start();
		try{
			ServerSocket server = new ServerSocket(port, 0, InetAddress.getByName(null));//currently set to localhost
			while(true) //accept new connections, make a producer thread for them, remember their socket for consumer
			{
				Socket clientSocket = server.accept();
				if(clientSocket!=null){
					//only add temp to the array if there is a socket to connect
					Thread temp = new Thread(new ClientReader(clientSocket, buffer, user));
					temp.start();
					readers.add(temp);
					clients.add(clientSocket);
				}
				for(int i = 0; i < clients.size(); i++){
					//check to see if there are any closed clients
					Socket checkOpen = clients.elementAt(i);
					PrintWriter out = new PrintWriter(checkOpen.getOutputStream(), true);
					//checking read/write streams is the most reliable way of checking connection state
					if(out.checkError()){
						checkOpen.close();
						clients.remove(i);
						user.remove(i);
						(readers.elementAt(i)).interrupt();
						(readers.elementAt(i)).join();
						readers.remove(i);
					}
				}
				if(clients.size() == 0){
					writer.interrupt();
					writer.join();
				}
			}
		}catch(IOException b){
			System.out.println("Error in main");
		}catch(InterruptedException a){
			System.out.println("Interrupt caught in main");
		}
		System.out.println("Goodbye");
	}
}
