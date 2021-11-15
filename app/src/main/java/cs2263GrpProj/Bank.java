package cs2263GrpProj;

import java.sql.SQLOutput;

/**
 * @author Keagan York
 */
public class Bank {
    /**
     * private variable instantiation
     */
    private int totalStocks;

    /**
     * Method for retrieving stock count
     * @param stockName Name of the corporation the stock is the type of.
     * @param playerName Name of the player
     * @return total stocks of the specific type owned by a
     * specific player.
     */
    public int getNumberOfStock(String stockName, Player playerName){
        totalStocks = 0;
        for(Stock stock: playerName.stocks){
            if(stock.getStockName() == stockName){
                totalStocks++;
            }
        }
       return totalStocks;
    }

    /**
     * Method to add to a player's balance a specific passed amount.
     * @param player Player object
     * @param amount Total amount of to add to that player's balance.
     */
    public void payPlayer(Player player, int amount){
        player.balance += amount;
    }

    /**
     * Method to add to a player's balance the payout awarded for
     * selling stock.
     * @param player Player object
     * @param name name of the corporation the stock is the type of
     * @param multiplier the total amount of stocks that player owns
     *                   of the related type
     */
    public void payStockValue(Player player, Stock name, int multiplier){
        player.balance += name.getStockValue()*multiplier;
    }

    /**
     * Method to check whether two players are tied for shareholdings
     * within a corporation.
     * @param player1 Player object
     * @param player2 Player object
     * @return boolean of whether they are tied
     *
     */
    public boolean stockHolderIsTied(Player player1, Player player2){
        return false;
    }

    /**
     * Method to "sell" (remove the price of the stock and add it
     * to their list of owned stocks) to a player. If that player
     * cannot afford that stock it will print an error.
     * @param player Player object
     * @param stock Stock object
     */
    public void buyStock(Player player, Stock stock){
        if(player.balance-stock.stockValue < 0){
            System.out.println("player cannot afford this stock");
        }else {
            player.balance-=stock.stockValue;
            player.stocks.add(stock);
        }
    }

}
