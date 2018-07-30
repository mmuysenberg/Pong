package gameNet;

public class GameInfo {
    String playerName;
    boolean createServer;

	public String getPlayerName() {
		return playerName;
	}

	public boolean isCreateServer() {
		return createServer;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public int getPort() {
		return port;
	}
    String ipAddr;
    int port;
    public GameInfo(String playerName, boolean createServer, String ipAddr, int port) {
	super();
	this.playerName = playerName;
	this.createServer = createServer;
	this.ipAddr = ipAddr;
	this.port = port;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "GameInfo [playerName=" + playerName + ", createServer=" + createServer + ", ipAddr=" + ipAddr
		+ ", port=" + port + "]";
    }
    
}
