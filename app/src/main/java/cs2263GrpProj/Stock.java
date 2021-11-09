package cs2263GrpProj;

public class Stock {
    /**
     * @author Keagan York
     */

    /**
     * Public variable instantiations
     */
    public String stockName;
    public int stockSize;

    /**
     * Basic constructor
     */
    public Stock(){};

    /**
     * Complete constructor
     * @param name
     * @param size
     */
    public Stock(String name, int size){
        this.stockName = name;
        this.stockSize = size;
    }

    /**
     *All public getters and setters.
     */
    public int getStockSize() {
        return stockSize;
    }

    public void setStockSize(int stockSize) {
        this.stockSize = stockSize;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
}
