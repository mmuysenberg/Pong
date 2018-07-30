package pong;

import gameNet.GameCreator;
import gameNet.GameInfo;
import gameNet.GamePlayer;
import gameNet.GameControl;
import gameNet.GameNet_CoreGame;
import gameNet.GameNet_UserInterface;
import java.io.IOException;

public class MyMain extends GameCreator{  
    GameInfo myGameInfo;
 
    @Override
  public GameNet_CoreGame createGame()
  {
	  return new MyGame();
  }

//    @Override
//  public void enterGame(GameNet_UserInterface yourUserInterface, GameInfo gameInfo)
//	{
//		String playerName = gameInfo.getPlayerName();
//		GamePlayer gamePlayer; 
//		GameControl gameControl = new GameControl(this);
//	    if (gameInfo.isCreateServer())
//	    {
//	    	gameControl.startServer(); // Start a Server GameControl
//	    }
//	    else
//	    {
//	    	String ipaddr = gameInfo.getIpAddr();
//	    	int port;
//	    	port = gameInfo.getPort();
//	    	gameControl.connect_to_server(ipaddr,port);
//	    }
//	    
//	 // Connect ourselves to the GameControl
//	    
//	    
//	    gamePlayer = new GamePlayer(playerName, gameControl, yourUserInterface);
//	    yourUserInterface.startUserInterface (gamePlayer);
//	     
//	}
 
}// end of class
