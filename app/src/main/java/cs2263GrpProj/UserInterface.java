/**
 * Copyright 2021 IFG2
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cs2263GrpProj;

//Imports
import javafx.application.Application;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.geometry.*;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class UserInterface {

  /**
   * Creates the main menu scene.
   * 
   * @param stage Takes in a stage object to create and display the buying stock
   *              scene.
   * @author Kaiden Evans
   */
  public void mainMenu(Stage stage) throws Exception {
    Handler gameHandler = new Handler();
    gameHandler.startGame(2);
    stage.setTitle("Main Menu");
    Label numOfPlayers = new Label("Please input the number of players.");
    TextField numPlayerInput = new TextField();
    Button startGame = new Button("Start Game");
    Button loadGame = new Button("Load Game");
    Button exitGame = new Button("Exit Game");
    startGame.setMinWidth(100);
    loadGame.setMinWidth(100);
    exitGame.setMinWidth(100);

    VBox topHalf = new VBox(numOfPlayers, numPlayerInput, startGame, loadGame, exitGame);
    topHalf.setSpacing(10);
    topHalf.setPrefHeight(70);
    VBox bottomHalf = new VBox(startGame, loadGame, exitGame);
    bottomHalf.setSpacing(10);
    bottomHalf.setPrefWidth(100);
    bottomHalf.setPadding(new Insets(60));
    BorderPane fullLayout = new BorderPane();
    fullLayout.setTop(topHalf);
    fullLayout.setCenter(bottomHalf);
    Scene mainMenu = new Scene(fullLayout, 225, 250);
    stage.setScene(mainMenu);
    stage.show();

    startGame.setOnAction(value -> {
      boardScene(stage, gameHandler);
    });

    loadGame.setOnAction(value -> {
      //gameHandler.loadGame();
    });

    exitGame.setOnAction(value -> {
      stage.close();
    });
  }

  public void exitMenu(Stage stage, Handler gameHandler) {
    stage.setTitle("Exit Menu");
    Label exitMessage = new Label("Are you sure you want to exit?" + "\r\n" + "Unsaved progress will be lost.");
    exitMessage.setPadding(new Insets(10));
    Button cancelExit = new Button("Cancel");
    Button exit = new Button("Exit");
    cancelExit.setMinWidth(75);
    exit.setMinWidth(75);

    VBox topHalf = new VBox(exitMessage);
    topHalf.setSpacing(10);
    topHalf.setPrefHeight(40);
    HBox bottomHalf = new HBox(cancelExit, exit);
    bottomHalf.setSpacing(10);
    bottomHalf.setPrefWidth(100);
    bottomHalf.setPadding(new Insets(20));
    BorderPane fullLayout = new BorderPane();
    fullLayout.setTop(topHalf);
    fullLayout.setCenter(bottomHalf);
    Scene exitMenu = new Scene(fullLayout, 225, 115);
    stage.setScene(exitMenu);
    stage.show();

    cancelExit.setOnAction(value -> {
      boardScene(stage, gameHandler);
    });

    exit.setOnAction(value -> {
      stage.close();
    });
  }

  /**
   * Creates the exit menu scene.
   * 
   * @param stage Takes in a stage object to create and display the buying stock
   *              scene.
   * @author Kaiden Evans
   */
  public void boardScene(Stage stage, Handler gameHandler) {
    stage.setTitle("Acquire");
    MenuBar menuBar = new MenuBar();
    Menu fileMenu = new Menu("File");
    MenuItem saveOption = new MenuItem("Save");
    MenuItem loadOption = new MenuItem("Load");
    MenuItem exitOption = new MenuItem("Exit");

    fileMenu.getItems().add(saveOption);
    fileMenu.getItems().add(loadOption);
    fileMenu.getItems().add(exitOption);
    menuBar.getMenus().add(fileMenu);

    Button startTurn = new Button("Start Turn");
    Button endTurn = new Button("End Turn");
    Button drawTile = new Button("Draw Tile");
    Button buyStock = new Button("Buy Stock");
    startTurn.setMinWidth(75);
    endTurn.setMinWidth(75);
    drawTile.setMinWidth(75);
    buyStock.setMinWidth(75);

    VBox menuBarContainer = new VBox(menuBar);
    menuBarContainer.setSpacing(10);
    menuBarContainer.setPrefHeight(40);

    Label playerInfo = new Label("Player Information");
    Label player1 = new Label("Player 1" + "\r\n" + "Tiles: " + "\r\n" + "Balance: " + "\r\n" + "Stocks: ");
    Label player2 = new Label("Player 2" + "\r\n" + "Tiles: " + "\r\n" + "Balance: " + "\r\n" + "Stocks: ");
    playerInfo.setFont(Font.font("Arial", FontWeight.BOLD, 24));
    player1.setFont(Font.font("Arial", 16));
    player1.setPadding(new Insets(10));
    player2.setFont(Font.font("Arial", 16));
    player2.setPadding(new Insets(10));

    GridPane gameBoard = new GridPane();
    gameBoard.setPrefSize(9, 12);
    gameBoard.setVgap(5);
    gameBoard.setHgap(5);
    for (int i = 0; i < 12; i++) {
      for (Character j = 'A'; j < 'J'; j++) {
        Button boardBtn = new Button((i + 1) + "" + j);
        boardBtn.setMinSize(50, 50);
        gameBoard.add(boardBtn, j, i, 1, 1);
      }
    }

    Label corpInfo = new Label("Corporation Information");
    Label corp1 = new Label("Corporation 1" + "\r\n" + "Stock Price: " + "\r\n" + "Stocks Available: ");
    Label corp2 = new Label("Corporation 2" + "\r\n" + "Stock Price: " + "\r\n" + "Stocks Available: ");
    Label corp3 = new Label("Corporation 3" + "\r\n" + "Stock Price: " + "\r\n" + "Stocks Available: ");
    Label corp4 = new Label("Corporation 4" + "\r\n" + "Stock Price: " + "\r\n" + "Stocks Available: ");
    Label corp5 = new Label("Corporation 5" + "\r\n" + "Stock Price: " + "\r\n" + "Stocks Available: ");
    Label corp6 = new Label("Corporation 6" + "\r\n" + "Stock Price: " + "\r\n" + "Stocks Available: ");
    Label corp7 = new Label("Corporation 7" + "\r\n" + "Stock Price: " + "\r\n" + "Stocks Available: ");
    corpInfo.setFont(Font.font("Arial", FontWeight.BOLD, 24));
    corp1.setFont(Font.font("Arial", 16));
    corp2.setFont(Font.font("Arial", 16));
    corp3.setFont(Font.font("Arial", 16));
    corp4.setFont(Font.font("Arial", 16));
    corp5.setFont(Font.font("Arial", 16));
    corp6.setFont(Font.font("Arial", 16));
    corp7.setFont(Font.font("Arial", 16));

    HBox buttonContainer = new HBox(startTurn, endTurn, drawTile, buyStock);
    buttonContainer.setSpacing(10);
    buttonContainer.setPrefWidth(100);
    buttonContainer.setPadding(new Insets(20));

    BorderPane fullLayout = new BorderPane();
    VBox leftSideContainer = new VBox(20, playerInfo, player1, player2);
    VBox rightSideContainer = new VBox(20, corpInfo, corp1, corp2, corp3, corp4, corp5, corp6, corp7, buttonContainer);
    fullLayout.setTop(menuBarContainer);
    fullLayout.setLeft(leftSideContainer);
    fullLayout.setCenter(gameBoard);
    fullLayout.setRight(rightSideContainer);
    Scene acquireBoardScene = new Scene(fullLayout, 1500, 750);
    stage.setScene(acquireBoardScene);
    stage.show();

    startTurn.setOnAction(value -> {
      //gameHandler.players.get(0);
    });

    endTurn.setOnAction(value -> {
      //gameHandler.players.get(1);
    });

    drawTile.setOnAction(value -> {
      // gameHandler.requestTile();
    });

    buyStock.setOnAction(value -> {
      buyScene(stage, gameHandler);
    });

    saveOption.setOnAction(value -> {
      // gameHandler.saveGame();
    });

    loadOption.setOnAction(value -> {
      // gameHandler.loadGame();
    });

    exitOption.setOnAction(value -> {
      exitMenu(stage, gameHandler);
    });
  }

  /**
   * Creates the buy stock scene.
   * 
   * @param stage Takes in a stage object to create and display the buying stock
   *              scene.
   * @author Kaiden Evans
   */
  public void buyScene(Stage stage, Handler gameHandler) {
    stage.setTitle("Buying Stock");

    Label stocksAvailableLabel = new Label("Stocks Available");
    stocksAvailableLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
    ListView stocksAvailable = new ListView();
    stocksAvailable.getItems().add("Corporation 1");
    stocksAvailable.getItems().add("Corporation 2");
    stocksAvailable.getItems().add("Corporation 3");
    stocksAvailable.getItems().add("Corporation 4");
    stocksAvailable.getItems().add("Corporation 5");
    stocksAvailable.getItems().add("Corporation 6");
    stocksAvailable.getItems().add("Corporation 7");
    stocksAvailable.setMaxWidth(150);
    stocksAvailable.setPrefHeight(165);

    Label stocksLabel = new Label("Number of Stocks");
    stocksLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

    ComboBox numOfStocksToPurchase = new ComboBox();
    numOfStocksToPurchase.getItems().add("1");
    numOfStocksToPurchase.getItems().add("2");
    numOfStocksToPurchase.getItems().add("3");
    numOfStocksToPurchase.getSelectionModel().selectFirst();

    Button buyStock = new Button("Buy");
    Button cancelPurchase = new Button("Cancel");
    buyStock.setMinWidth(75);
    cancelPurchase.setMinWidth(75);

    VBox container = new VBox(stocksAvailableLabel, stocksAvailable, stocksLabel, numOfStocksToPurchase, buyStock,
        cancelPurchase);
    container.setPadding(new Insets(25));
    container.setSpacing(10);
    BorderPane buyingStockLayout = new BorderPane();
    buyingStockLayout.setCenter(container);
    Scene buyStockScene = new Scene(buyingStockLayout, 300, 400);
    stage.setScene(buyStockScene);
    stage.show();

    buyStock.setOnAction(value -> {
      buyScene(stage, gameHandler);

    });

    cancelPurchase.setOnAction(value -> {
      boardScene(stage, gameHandler);
    });
  }

  /**
   * Creates the sell stock scene.
   * 
   * @param stage Takes in a stage object to create and display the selling stock
   *              scene.
   * @author Kaiden Evans
   */
  public void sellScene(Stage stage, Handler gameHandler) {
    stage.setTitle("Selling Stock");

    Label stocksAvailableLabel = new Label("Stocks Available");
    stocksAvailableLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
    ListView stocksAvailable = new ListView();
    stocksAvailable.getItems().add("Corporation 1");
    stocksAvailable.getItems().add("Corporation 2");
    stocksAvailable.getItems().add("Corporation 3");
    stocksAvailable.getItems().add("Corporation 4");
    stocksAvailable.getItems().add("Corporation 5");
    stocksAvailable.getItems().add("Corporation 6");
    stocksAvailable.getItems().add("Corporation 7");
    stocksAvailable.setMaxWidth(150);
    stocksAvailable.setPrefHeight(165);

    Label stocksLabel = new Label("Number of Stocks");
    stocksLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

    ComboBox numOfStocksToPurchase = new ComboBox();
    numOfStocksToPurchase.getItems().add("1");
    numOfStocksToPurchase.getItems().add("2");
    numOfStocksToPurchase.getItems().add("3");
    numOfStocksToPurchase.getSelectionModel().selectFirst();

    Button sellStock = new Button("Sell");
    Button cancelTransaction = new Button("Cancel");
    sellStock.setMinWidth(75);
    cancelTransaction.setMinWidth(75);

    VBox container = new VBox(stocksAvailableLabel, stocksAvailable, stocksLabel, numOfStocksToPurchase, sellStock,
        cancelTransaction);
    container.setPadding(new Insets(25));
    container.setSpacing(10);
    BorderPane sellingStockLayout = new BorderPane();
    sellingStockLayout.setCenter(container);
    Scene sellStockScene = new Scene(sellingStockLayout, 300, 400);
    stage.setScene(sellStockScene);
    stage.show();

    sellStock.setOnAction(value -> {
      sellScene(stage, gameHandler);
    });

    cancelTransaction.setOnAction(value -> {
      mergeScene(stage, gameHandler);
    });
  }

  /**
   * Creates the trade stock scene.
   * 
   * @param stage Takes in a stage object to create and display the trading stock
   *              scene.
   * @author Kaiden Evans
   */
  public void tradeScene(Stage stage, Handler gameHandler) {
    stage.setTitle("Trading Stock");

    Button tradeStock = new Button("Trade");
    Button cancelTrade = new Button("Cancel");
    tradeStock.setMinWidth(75);
    cancelTrade.setMinWidth(75);

    Label playerStocksAvailableLabel = new Label("Player Stocks Available");
    playerStocksAvailableLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    ListView playerStocksAvailable = new ListView();
    playerStocksAvailable.getItems().add("Corporation 1");
    playerStocksAvailable.getItems().add("Corporation 2");
    playerStocksAvailable.getItems().add("Corporation 3");
    playerStocksAvailable.getItems().add("Corporation 4");
    playerStocksAvailable.getItems().add("Corporation 5");
    playerStocksAvailable.getItems().add("Corporation 6");
    playerStocksAvailable.getItems().add("Corporation 7");
    playerStocksAvailable.setMaxWidth(150);
    playerStocksAvailable.setPrefHeight(165);

    Label stocksLabel = new Label("Number of Stocks");
    stocksLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

    ComboBox numOfStocksToPurchase = new ComboBox();
    numOfStocksToPurchase.getItems().add("1");
    numOfStocksToPurchase.getItems().add("2");
    numOfStocksToPurchase.getItems().add("3");
    numOfStocksToPurchase.getSelectionModel().selectFirst();

    Label corpStocksAvailableLabel = new Label("Corporation Stocks Available");
    corpStocksAvailableLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    ListView corpStocksAvailable = new ListView();
    corpStocksAvailable.getItems().add("Corporation 1");
    corpStocksAvailable.getItems().add("Corporation 2");
    corpStocksAvailable.getItems().add("Corporation 3");
    corpStocksAvailable.getItems().add("Corporation 4");
    corpStocksAvailable.getItems().add("Corporation 5");
    corpStocksAvailable.getItems().add("Corporation 6");
    corpStocksAvailable.getItems().add("Corporation 7");
    corpStocksAvailable.setMaxWidth(150);
    corpStocksAvailable.setPrefHeight(165);

    VBox corpInfoContainer = new VBox(corpStocksAvailableLabel, corpStocksAvailable);
    corpInfoContainer.setPadding(new Insets(25));
    corpInfoContainer.setSpacing(10);

    VBox playerInfoContainer = new VBox(playerStocksAvailableLabel, playerStocksAvailable, stocksLabel,
        numOfStocksToPurchase, tradeStock, cancelTrade);
    playerInfoContainer.setPadding(new Insets(25));
    playerInfoContainer.setSpacing(10);

    HBox fullContainer = new HBox(playerInfoContainer, corpInfoContainer);
    BorderPane tradeStockLayout = new BorderPane();
    tradeStockLayout.setCenter(fullContainer);
    Scene tradeStockScene = new Scene(tradeStockLayout, 625, 400);
    stage.setScene(tradeStockScene);
    stage.show();

    tradeStock.setOnAction(value -> {

    });

    cancelTrade.setOnAction(value -> {
      mergeScene(stage, gameHandler);
    });
  }

  /**
   * Creates the merge scene.
   * 
   * @param stage Takes in a stage object to create and display the merge scene.
   * @author Kaiden Evans
   */
  public void mergeScene(Stage stage, Handler gameHandler) {
    stage.setTitle("Corporation Merge");

    Button mergeSell = new Button("Sell");
    Button mergeTrade = new Button("Trade");
    Button mergeHold = new Button("Hold");
    Button endMerge = new Button("Finish Merge");
    mergeSell.setMinWidth(75);
    mergeTrade.setMinWidth(75);
    mergeHold.setMinWidth(75);
    endMerge.setMinWidth(75);

    Label player1MergeInfo = new Label("Player 1" + "\r\n" + "Stocks: ");
    player1MergeInfo.setFont(Font.font("Arial", 16));
    Label player2MergeInfo = new Label("Player 2" + "\r\n" + "Stocks: ");
    player2MergeInfo.setFont(Font.font("Arial", 16));

    VBox playerInfoContainer = new VBox(player1MergeInfo, player2MergeInfo);
    playerInfoContainer.setSpacing(100);
    playerInfoContainer.setPadding(new Insets(10));

    HBox mergeButtonContainer = new HBox(mergeSell, mergeTrade, mergeHold, endMerge);
    mergeButtonContainer.setPadding(new Insets(30));

    BorderPane mergeLayout = new BorderPane();
    mergeLayout.setCenter(playerInfoContainer);
    mergeLayout.setBottom(mergeButtonContainer);
    Scene mergeScene = new Scene(mergeLayout, 400, 375);
    stage.setScene(mergeScene);
    stage.show();

    mergeSell.setOnAction(value -> {
      sellScene(stage, gameHandler);
    });

    mergeTrade.setOnAction(value -> {
      tradeScene(stage, gameHandler);
    });

    mergeHold.setOnAction(value -> {

    });

    endMerge.setOnAction(value -> {
      boardScene(stage, gameHandler);
    });

  }
}