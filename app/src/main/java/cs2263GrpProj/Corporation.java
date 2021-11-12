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


    /**
     * Basic constructor
     * @param name
     */
    public Corporation(String name){
        this.corporationName = name;
    }

    /**
     * Complete constructor
     * @param name Name of the corporation
     * @param size Size (amount of tiles it controls) of the
     *             corporation
     */
    public Corporation(String name, int size){
        this.corporationName = name;
        this.corporationSize = size;

    }

    public boolean isSafe(){
        if(corporationSize >=11 ){
            return true;
        }else{return false;}
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

    public int getCorporationSize() {
        return corporationSize;
    }

}
