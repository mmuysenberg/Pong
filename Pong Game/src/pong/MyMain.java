package pong;

import gameNet.GameCreator;
import gameNet.GameInfo;
import gameNet.GameNet_CoreGame;
import gameNet.GameNet_UserInterface;

public class MyMain extends GameCreator{   
 
  public GameNet_CoreGame createGame()
  {
	  return new MyGame();
  }
 
  public static void main(String[] args) 
  {   
  	MyMain myMain = new MyMain();
  	GameInfo gameInfo = new GameInfo("Muhammad Tello", true, null, 0);
  	GameNet_UserInterface myUserInterface = new MyUserInterface();
   
  	myMain.enterGame(myUserInterface, gameInfo); 
  }// end of main
}// end of class
