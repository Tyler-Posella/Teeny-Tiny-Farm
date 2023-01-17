public class Animal {
    private String name;
    private double energy;
    private boolean alive;
    private double mealAmount;
    private double posX;
    private double posY;
    private double speedX;
    private double speedY;
    public Animal(){
        this.energy = 100;
        this.speedX = 1;
        this.speedY = 1;
    }
    public String toString(){
        String returnString = (getName() + " " + getAlive() + " at (" + getPosX() + ", " + getPosY() + ") Energy: " + getEnergy());
        return returnString;
    }
    public void speak(String animalMessage){
        System.out.print(getName() + ": " + animalMessage);
    }
    public void sound(){
        if(getAlive() == true){
            System.out.print("Unkown sound");
        }
        else{}
    }
    public double eat(){
        double startingEnergy = getEnergy();
        double foodConsumed = 0;
        if(getEnergy() < 0){
            System.out.print(getName() + " is dead!");
        }
        if(getEnergy() == 100){
            System.out.print(getName() + " is full!");
        }
        if(getEnergy() < 100 && getEnergy() > 0) {
            if ((getEnergy() + mealAmount) > 100) {
                foodConsumed = 100 - getEnergy();
                setEnergy(100);
                System.out.print(getName() + " ate " + foodConsumed + " units of food. It is now full!");
            } else {
                foodConsumed = mealAmount;
                setEnergy((getEnergy() + mealAmount));
                System.out.print(getName() + " ate " + foodConsumed + " units of food. Its energy is now " + getEnergy() + ".");
            }
        }
        //Need to include deduction of foodConsumed from the total food we have on the farm
        return foodConsumed;
    }
    public void move(){
        if(getAlive() == true){
            setPosX((this.posX) + getSpeedX());
            setPosY((this.posY) + getSpeedY());
        }
        else{
            System.out.print(getName() + " can't move. It is dead!");
        }
    }
    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public double getEnergy(){
        return energy;
    }
    public void setEnergy(double newEnergy){
        this.energy = newEnergy;
        if(getEnergy() > 100){
            setEnergy(100);
        }
        if(getEnergy() < 0) {
            setEnergy(0);
        }
        if(17 < getEnergy() && 50 > getEnergy()){
            System.out.print(getName() + "is hungry!");
        }
        if(getEnergy() <= 17){
            System.out.print(getName() + "is starving!");
        }
    }
    public boolean getAlive(){
        if(this.energy < 0){
            return false;
        }
        else {
            return true;
        }
    }
    public double getMealAmount(){
        return mealAmount;
    }
    public void setMealAmount(double newMealAmount){
        this.mealAmount = newMealAmount;
    }
    public double getPosX(){
        return posX;
    }
    public void setPosX(double newPosX){
        this.posX = newPosX;
    }
    public double getPosY(){
        return posY;
    }
    public void setPosY(double newPosY){
        this.posY = newPosY;
    }
    public double getSpeedX(){
        return speedX;
    }
    public void setSpeedX(double newSpeedX){
        this.speedX = newSpeedX;
    }
    public double getSpeedY(){
        return speedY;
    }
    public void setSpeedY(double newSpeedY){
        this.speedY = newSpeedY;
    }
}
