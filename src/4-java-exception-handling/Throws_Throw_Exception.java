import java.util.concurrent.TimeUnit;

public class Throws_Throw_Exception {
    public static void main(String[] args) {
        Cooking idli = new Cooking("Idli", 2, 50);
        Cooking dosa = new Cooking("Masla Dosa", 5, 80);

        try {
            idli.cook(20, 50);
        }
        catch (Exception e) {
            System.out.println("Cooking Failed: "+e.getMessage());
        }
        finally{
            System.out.println("Cooking Over");
        }

        // next cooking
        try {
            dosa.cook(1, 50);
        }
        catch (Exception e) {
            System.out.println("Cooking Failed: "+e.getMessage());
        }
        finally{
            System.out.println("Cooking Over");
        }


        
    }
}


class Cooking{

    private int salt_limit;
    private int temperature_limit;
    private String dish_name;

    Cooking(String dish_name, int salt_limit, int temperature_limit){
        this.salt_limit = salt_limit;
        this.temperature_limit = temperature_limit;
        this.dish_name = dish_name;
    }

    public void cook(int salt, int temperature) throws BurntFoodException, VerySaltyException{
        System.out.print("Cooking Started");
        try{
            Thread.sleep(100);
            System.out.print(" . ");
            Thread.sleep(100);
            System.out.print(" . ");
            Thread.sleep(100);
            System.out.print(" . ");
        }
        catch(Exception e){
            System.out.println(". . .");
        }
        finally{
            System.out.println("");
        }
        if(temperature > this.temperature_limit){
            throw new BurntFoodException();
        }
        
        if(salt> this.salt_limit){
            throw new VerySaltyException();
        }
        
        System.out.println("You have successfully cooked: " + this.dish_name);
        
    }

}

class BurntFoodException extends Exception{
    BurntFoodException(){
        super("Food has been Burnt");
    }
}

class VerySaltyException extends Exception{
    VerySaltyException(){
        super("Way Too Salty");
    }
}
