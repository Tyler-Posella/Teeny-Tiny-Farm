package P2;
//Make sense to be abstract because you don't want to create an animal. What exactly is an animal? You just want to create specific species of animals.
//Making it abstract stops us from creating animal objects but allows us to still inherit the methods and attributes
abstract public class Animal implements Comparable<Animal>, Cloneable {
	private String name;
	private double energy, mealAmount, x, y, speedX=1, speedY=1;
	private boolean alive;	
	public Animal() {
		setEnergy(100);
	}
	public void speak(String msg){
		if (isAlive()) System.out.println(getName() + " says: " + msg);
	}
	public double eat(){
		if (isAlive()) {
			//get amount needed and round to 2 decimals
			double amount = Math.round((100-getEnergy())*100)/100.0;
			if (amount >= mealAmount) {
				System.out.println(getName() + " ate " + mealAmount + " units");
				setEnergy(getEnergy() + mealAmount);
				return mealAmount;
			} else if (amount > 0) {
				System.out.println(getName() + " ate " + amount + " units. Now it is full!");
				setEnergy(100);
				return amount;
			} else {
				System.out.println(getName() + " didn't eat. It is full!");
				return 0;
			}
		} else {
			System.out.println(getName() + " is dead!");
			return 0;
		}
	}
	public void move() {
		if(isAlive()){
			x += speedX;
			y += speedY;
			setEnergy(getEnergy() - 0.1);
		}else
			System.out.println(getName() + "can't move. It is dead!");
	}
	//We want to make this abstract because we want to make a different sound in each subclass of animal
	//We also want to apply polymorphism, so we want to include it in the superclass as an abstract method and force an implementation in each subclass of animal
	//Including it in the parent as an abstract method since it makes the compiler force us to override it. So we don't forget to implement it in our subclasses in the same way
	public abstract void sound();
	//setters, getters, toString
	public String getName() {
		return name;
	}
	public double getEnergy() {
		return energy;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEnergy(double energy) {
		if(energy>0 && energy <=100) 
			this.energy = energy;
		if(this.energy <= 17 ) 
			System.out.println(getName() + " says: I'm STARVING");
		else if(this.energy <= 50) 
			System.out.println(getName() + " says: I'm hungry");
		this.alive = (energy > 0); 	
	}
	public double getMealAmount() {
		return mealAmount;
	}
	public void setMealAmount(double mealAmount) {
		if(mealAmount>0 && mealAmount<100) this.mealAmount = mealAmount;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getSpeedX() {
		return speedX;
	}
	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}
	public double getSpeedY() {
		return speedY;
	}
	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}
	public boolean isAlive() {
		return alive;
	}
	public String toString(){
		//return String.format("Alive:%b Name:%-10sEnergy:%-7.1fLocation:(%-2.1f,%-2.1f)", isAlive(), name, energy,x,y); 
		return String.format("%-8s: %-5s at (%-2.1f,%-2.1f) Energy=%-7.1f", name, isAlive()?"alive":"dead",x,y,energy); 
	}
	public int compareTo(Animal a){
		if(this.getEnergy() > a.getEnergy()) {
			return 1;
		}
		else if(this.getEnergy() < a.getEnergy()) {
			return -1;
		}
		else{
			return 0;
		}
	}
	public Animal clone() throws CloneNotSupportedException {
			Animal clone = (Animal) super.clone();
			return clone;
	}
}