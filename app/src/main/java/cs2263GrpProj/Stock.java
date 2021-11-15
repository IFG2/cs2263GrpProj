package cs2263GrpProj;

public class Stock {
    /**
     * @author Keagan York
     */

    /**
     * Public variable instantiations
     */
    public String stockName;
    public int stockQuantity;
    public int stockValue;

    /**
     * Basic constructor
     */
    public Stock(){};

    /**
     * Complete constructor
     * @param name Name of the corporation in which this stock
     *             is the type of
     * @param quantity The amount of stock of this type owned
     *                 by the player
     */
    public Stock(String name, int quantity, int value){
        this.stockName = name;
        this.stockQuantity = quantity;
        this.stockValue = value;
    }

    /**
     *All public getters and setters.
     */
    public int getStockSize() { return stockQuantity; }

    public void setStockSize(int stockSize) { this.stockQuantity = stockSize; }

    public String getStockName() { return stockName; }

    public void setStockName(String stockName) { this.stockName = stockName; }

    public int getStockValue() { return stockValue; }

    public void setStockValue(int stockValue) { this.stockValue = stockValue; }
}
