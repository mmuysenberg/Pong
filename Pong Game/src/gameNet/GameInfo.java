package gameNet;

public class GameInfo {
    String playerName;
    boolean server;
    String ipAddr;
    int port;

    public String getPlayerName() {
	return playerName;
    }

    public boolean isServer() {
	return server;
    }

    public String getIpAddr() {
	return ipAddr;
    }

    public int getPort() {
	return port;
    }
    public GameInfo(String playerName, boolean createServer, String ipAddr, int port) {
	super();
	this.playerName = playerName;
	this.server = createServer;
	this.ipAddr = ipAddr;
	this.port = port;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "GameInfo [playerName=" + playerName + ", createServer=" + server + ", ipAddr=" + ipAddr
		+ ", port=" + port + "]";
    }

}
