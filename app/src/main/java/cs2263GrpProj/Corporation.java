package cs2263GrpProj;

public class Corporation {

    /**
     @author Keagan York
     */

    /**
     * public variable instantiations
     */
    public String corporationName;
    public int corporationSize;
    public boolean isSafe;
    public boolean isDefunct;

    /**
     * Basic constructor
     * @param name
     */
    public Corporation(String name){
        this.corporationName = name;
    }

    /**
     * Complete constructor
     * @param name
     * @param size
     * @param isSafe
     * @param isDefunct
     */
    public Corporation(String name, int size, boolean isSafe, boolean isDefunct){
        this.corporationName = name;
        this.corporationSize = size;
        this.isSafe = isSafe;
        this.isDefunct = isDefunct;
    }
    public int getCorporationSize() {
        return corporationSize;
    }

    /**
     *Getters and Setters for all public variables.
     */
    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationSize(int corporationSize) {
        this.corporationSize = corporationSize;
    }

    public void setDefunct(boolean defunct) {
        isDefunct = defunct;
    }

    public void setSafe(boolean safe) {
        isSafe = safe;
    }
}
