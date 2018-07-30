package gameNet;

public class GameInfo {
    String playerName;
    boolean createServer;
    boolean isValid = true;

	public String getPlayerName() {
		return playerName;
	}

	public boolean isCreateServer() {
		return createServer;
	}
	public boolean isValidServer() {
		return isValid;
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
    public GameInfo(String playerName, boolean createServer, String ipAddr, int port, boolean isValid) {
	super();
	this.playerName = playerName;
	this.createServer = createServer;
	this.ipAddr = ipAddr;
	this.port = port;
	this.isValid = isValid;
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
