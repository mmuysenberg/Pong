package gameNet;

public class GameInfo {
    String playerName;
    boolean createServer;
    String ipAddr;
    int port;
    public GameInfo(String playerName, boolean createServer, String ipAddr, int port) {
	super();
	this.playerName = playerName;
	this.createServer = createServer;
	this.ipAddr = ipAddr;
	this.port = port;
    }
    
}
