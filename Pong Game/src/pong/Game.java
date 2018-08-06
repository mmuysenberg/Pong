/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import gameNet.GameInfo;

/**
 *
 * @author ijaaztello
 */
public class Game extends javax.swing.JFrame {
    MyUserInterface myUserInterface = new MyUserInterface();
    GameInfo myGameInfo;
    boolean ON = false;
    boolean clientServer = false;
    MyMain myMain;
    boolean serverSetupRun = false;
    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
	myMain = new MyMain();
	myUserInterface = new MyUserInterface();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                GameSetup = new javax.swing.JPanel();
                enterGame = new javax.swing.JButton();
                playerName = new javax.swing.JTextField();
                jLabel1 = new javax.swing.JLabel();
                jTabbedPane2 = new javax.swing.JTabbedPane();
                serverPanel = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                serverIpAddr = new javax.swing.JLabel();
                serverPort = new javax.swing.JLabel();
                serverSetup = new javax.swing.JButton();
                clientPanel = new javax.swing.JPanel();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                clientIpAddr = new javax.swing.JTextField();
                clientPort = new javax.swing.JTextField();
                clientSetup = new javax.swing.JButton();
                connectionStatus = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Pong Game");
                setBackground(new java.awt.Color(0, 0, 0));
                setFocusTraversalPolicyProvider(true);
                setName("Pong Game"); // NOI18N
                setResizable(false);
                setSize(new java.awt.Dimension(800, 400));
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosed(java.awt.event.WindowEvent evt) {
                                formWindowClosed(evt);
                        }
                });

                GameSetup.setBackground(new java.awt.Color(0, 0, 0));
                GameSetup.setForeground(new java.awt.Color(255, 255, 255));
                GameSetup.setToolTipText("");
                GameSetup.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                GameSetup.setPreferredSize(new java.awt.Dimension(800, 400));
                GameSetup.setRequestFocusEnabled(false);
                GameSetup.setSize(new java.awt.Dimension(800, 400));

                enterGame.setBackground(new java.awt.Color(102, 102, 102));
                enterGame.setFont(new java.awt.Font("Source Sans Pro", 0, 24)); // NOI18N
                enterGame.setForeground(new java.awt.Color(255, 255, 255));
                enterGame.setText("Enter Game");
                enterGame.setToolTipText("");
                enterGame.setBorderPainted(false);
                enterGame.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                enterGameActionPerformed(evt);
                        }
                });

                playerName.setBackground(new java.awt.Color(51, 51, 51));
                playerName.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                playerName.setForeground(new java.awt.Color(255, 255, 255));
                playerName.setText("Name");
                playerName.setToolTipText("");
                playerName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                playerName.setFocusTraversalKeysEnabled(false);
                playerName.setOpaque(true);
                playerName.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                playerNameActionPerformed(evt);
                        }
                });

                jLabel1.setBackground(new java.awt.Color(0, 0, 0));
                jLabel1.setFont(new java.awt.Font("Source Sans Pro", 0, 24)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setText("Player Name");
                jLabel1.setToolTipText("");

                jTabbedPane2.setBackground(new java.awt.Color(0, 0, 0));
                jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));
                jTabbedPane2.setToolTipText("");
                jTabbedPane2.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                jTabbedPane2StateChanged(evt);
                        }
                });
                jTabbedPane2.addComponentListener(new java.awt.event.ComponentAdapter() {
                        public void componentShown(java.awt.event.ComponentEvent evt) {
                                jTabbedPane2ComponentShown(evt);
                        }
                });

                serverPanel.setBackground(new java.awt.Color(0, 0, 0));
                serverPanel.setForeground(new java.awt.Color(255, 255, 255));
                serverPanel.setToolTipText("");
                serverPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
                        public void componentShown(java.awt.event.ComponentEvent evt) {
                                serverPanelComponentShown(evt);
                        }
                });

                jLabel3.setBackground(new java.awt.Color(0, 0, 0));
                jLabel3.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                jLabel3.setText("IP Address");
                jLabel3.setToolTipText("");

                jLabel4.setBackground(new java.awt.Color(0, 0, 0));
                jLabel4.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(255, 255, 255));
                jLabel4.setText("Port");
                jLabel4.setToolTipText("");

                jLabel5.setBackground(new java.awt.Color(0, 0, 0));
                jLabel5.setForeground(new java.awt.Color(255, 255, 255));
                jLabel5.setToolTipText("");

                serverIpAddr.setBackground(new java.awt.Color(0, 0, 0));
                serverIpAddr.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                serverIpAddr.setForeground(new java.awt.Color(255, 255, 255));
                serverIpAddr.setText("10.0.0.0");
                serverIpAddr.setToolTipText("");

                serverPort.setBackground(new java.awt.Color(0, 0, 0));
                serverPort.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                serverPort.setForeground(new java.awt.Color(255, 255, 255));
                serverPort.setText("54321");
                serverPort.setToolTipText("");

                serverSetup.setBackground(new java.awt.Color(102, 102, 102));
                serverSetup.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                serverSetup.setForeground(new java.awt.Color(255, 255, 255));
                serverSetup.setText("Setup Server");
                serverSetup.setToolTipText("");
                serverSetup.setBorderPainted(false);
                serverSetup.setContentAreaFilled(false);
                serverSetup.setOpaque(true);
                serverSetup.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                serverSetupActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout serverPanelLayout = new javax.swing.GroupLayout(serverPanel);
                serverPanel.setLayout(serverPanelLayout);
                serverPanelLayout.setHorizontalGroup(
                        serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serverPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(serverPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                .addComponent(jLabel5)
                                                .addGap(191, 191, 191))
                                        .addGroup(serverPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serverPanelLayout.createSequentialGroup()
                                                                .addComponent(serverSetup)
                                                                .addGap(52, 52, 52))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serverPanelLayout.createSequentialGroup()
                                                                .addGroup(serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(serverIpAddr, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(serverPort))
                                                                .addContainerGap())))))
                );
                serverPanelLayout.setVerticalGroup(
                        serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serverPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(serverIpAddr))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(serverPort))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(serverSetup)
                                .addGap(25, 25, 25))
                );

                jTabbedPane2.addTab("Server", serverPanel);

                clientPanel.setBackground(new java.awt.Color(0, 0, 0));
                clientPanel.setForeground(new java.awt.Color(255, 255, 255));
                clientPanel.setToolTipText("");
                clientPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
                        public void componentShown(java.awt.event.ComponentEvent evt) {
                                clientPanelComponentShown(evt);
                        }
                });

                jLabel8.setBackground(new java.awt.Color(0, 0, 0));
                jLabel8.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                jLabel8.setForeground(new java.awt.Color(255, 255, 255));
                jLabel8.setText("Port");
                jLabel8.setToolTipText("");

                jLabel9.setBackground(new java.awt.Color(0, 0, 0));
                jLabel9.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                jLabel9.setForeground(new java.awt.Color(255, 255, 255));
                jLabel9.setText("IP Address");
                jLabel9.setToolTipText("");

                jLabel10.setBackground(new java.awt.Color(0, 0, 0));
                jLabel10.setForeground(new java.awt.Color(255, 255, 255));
                jLabel10.setToolTipText("");

                clientIpAddr.setBackground(new java.awt.Color(51, 51, 51));
                clientIpAddr.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                clientIpAddr.setForeground(new java.awt.Color(255, 255, 255));
                clientIpAddr.setText("10.0.0.0");
                clientIpAddr.setToolTipText("");
                clientIpAddr.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                clientIpAddr.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                clientIpAddrActionPerformed(evt);
                        }
                });

                clientPort.setBackground(new java.awt.Color(51, 51, 51));
                clientPort.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                clientPort.setForeground(new java.awt.Color(255, 255, 255));
                clientPort.setText("54321");
                clientPort.setToolTipText("");
                clientPort.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                clientPortActionPerformed(evt);
                        }
                });

                clientSetup.setBackground(new java.awt.Color(102, 102, 102));
                clientSetup.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
                clientSetup.setForeground(new java.awt.Color(255, 255, 255));
                clientSetup.setText("Setup Client");
                clientSetup.setToolTipText("");
                clientSetup.setBorderPainted(false);
                clientSetup.setContentAreaFilled(false);
                clientSetup.setOpaque(true);
                clientSetup.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                clientSetupActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
                clientPanel.setLayout(clientPanelLayout);
                clientPanelLayout.setHorizontalGroup(
                        clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(clientPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(clientPanelLayout.createSequentialGroup()
                                                .addGap(137, 137, 137)
                                                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(clientPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(clientSetup))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(clientPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(clientIpAddr, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10)
                                                .addGap(143, 143, 143))
                                        .addGroup(clientPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                );
                clientPanelLayout.setVerticalGroup(
                        clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)
                                        .addComponent(clientIpAddr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(clientPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(clientSetup)
                                .addGap(23, 23, 23))
                );

                clientIpAddr.getAccessibleContext().setAccessibleName("");

                jTabbedPane2.addTab("Client", clientPanel);

                connectionStatus.setBackground(new java.awt.Color(0, 0, 0));
                connectionStatus.setFont(new java.awt.Font("Source Serif Pro", 0, 18)); // NOI18N
                connectionStatus.setForeground(new java.awt.Color(255, 255, 255));
                connectionStatus.setText("Waiting for Setup");
                connectionStatus.setToolTipText("");

                javax.swing.GroupLayout GameSetupLayout = new javax.swing.GroupLayout(GameSetup);
                GameSetup.setLayout(GameSetupLayout);
                GameSetupLayout.setHorizontalGroup(
                        GameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameSetupLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(GameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(GameSetupLayout.createSequentialGroup()
                                                .addGroup(GameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50))
                                        .addGroup(GameSetupLayout.createSequentialGroup()
                                                .addComponent(connectionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                                                .addComponent(enterGame)
                                                .addGap(80, 80, 80))))
                );
                GameSetupLayout.setVerticalGroup(
                        GameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(GameSetupLayout.createSequentialGroup()
                                .addContainerGap(83, Short.MAX_VALUE)
                                .addGroup(GameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GameSetupLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(27, 27, 27)
                                                .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(GameSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(connectionStatus)
                                        .addComponent(enterGame))
                                .addGap(50, 50, 50))
                );

                getContentPane().add(GameSetup, java.awt.BorderLayout.CENTER);
                GameSetup.getAccessibleContext().setAccessibleName("");

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
            System.out.println("Client is exitting game");
	    myUserInterface.exitProgram();
    }//GEN-LAST:event_formWindowClosed

    boolean serverSetup(boolean createServer) {
	String player = playerName.getText();
	String ipAddr;
	int port;

	if(clientServer) {
		ipAddr = clientIpAddr.getText();
		String portString = clientPort.getText();
		port = Integer.parseInt(portString);
		createServer = false;
	} else {
		player = playerName.getText();
		createServer = true;
		ipAddr = null;
		port = 0;
	}

	myGameInfo = new GameInfo(player, createServer, ipAddr, port);
//	StringSelection data = new StringSelection
//	         ("This is copied to the clipboard");
//	      Clipboard cb = Toolkit.getDefaultToolkit()
//	         .getSystemClipboard();
//	      cb.setContents(data, data);
//
//
//	      // This represents the paste (Ctrl+V) operation
//
//	      try {
//	         Transferable t = cb.getContents(null);
//	         if (t.isDataFlavorSupported(DataFlavor.stringFlavor))
//	            System.out.println(t.getTransferData(DataFlavor
//	               .stringFlavor));
//	      } catch (UnsupportedFlavorException | IOException ex) {
//	          System.out.println("");
//	      }
	try {
            myGameInfo = myMain.enterGame(myUserInterface, myGameInfo);
            serverIpAddr.setText(myGameInfo.getIpAddr());
            serverPort.setText(Integer.toString(myGameInfo.getPort()));
	} catch (Exception e) {
	    System.err.println("SOMETHING WENT WRONG: " + e);
	    return false;
	}
	return true;	
    }

    private void enterGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterGameActionPerformed
        // TODO add your handling code here:
	if(serverSetupRun){
            add(myUserInterface);
            GameSetup.setVisible(false);
	    setTitle(myGameInfo.getPlayerName() +" " +myGameInfo.getIpAddr() +":" + myGameInfo.getPort());
	}
    }//GEN-LAST:event_enterGameActionPerformed

    private void playerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerNameActionPerformed

        private void clientIpAddrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientIpAddrActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_clientIpAddrActionPerformed

        private void clientPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientPortActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_clientPortActionPerformed

        private void jTabbedPane2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane2ComponentShown
                // TODO add your handling code here:
		System.out.println(evt.paramString());
        }//GEN-LAST:event_jTabbedPane2ComponentShown

        private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
                // TODO add your handling code here:
        }//GEN-LAST:event_jTabbedPane2StateChanged

        private void serverPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_serverPanelComponentShown
                // TODO add your handling code here:
		clientServer = false;
        }//GEN-LAST:event_serverPanelComponentShown

        private void clientPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_clientPanelComponentShown
                // TODO add your handling code here:
		clientServer = true;
        }//GEN-LAST:event_clientPanelComponentShown

        private void serverSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverSetupActionPerformed
                // TODO add your handling code here:
		if(!serverSetupRun) {
			connectionStatus.setText("Successfull server creation");
			serverSetup(true);
			serverSetupRun = true;
		}
        }//GEN-LAST:event_serverSetupActionPerformed

        private void clientSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientSetupActionPerformed
                // TODO add your handling code here:
		if(!serverSetupRun && serverSetup(false)) {
			connectionStatus.setText("Successfull client connection");
			serverSetupRun = true;
		} else {
			connectionStatus.setText("Unsuccessfull client connection");
			serverSetupRun = false;
		}
        }//GEN-LAST:event_clientSetupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel GameSetup;
        private javax.swing.JTextField clientIpAddr;
        private javax.swing.JPanel clientPanel;
        private javax.swing.JTextField clientPort;
        private javax.swing.JButton clientSetup;
        private javax.swing.JLabel connectionStatus;
        private javax.swing.JButton enterGame;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JTabbedPane jTabbedPane2;
        private javax.swing.JTextField playerName;
        private javax.swing.JLabel serverIpAddr;
        private javax.swing.JPanel serverPanel;
        private javax.swing.JLabel serverPort;
        private javax.swing.JButton serverSetup;
        // End of variables declaration//GEN-END:variables
}
