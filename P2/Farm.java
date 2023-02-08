package P2;
	import java.util.Arrays;
public class Farm {
	private double availableFood;
	private Animal[] animals;
	private int animalCounter;

	public Farm() {
		setAvailableFood(1000);
		animals = new Animal[100];
		add(new Chicken());
		add(new Cow());
		add(new Llama());
		add(new Llama());
	}
	public boolean add(Animal anim){
		for(int i = 0; i < animals.length; i++){
			if(animals[i] == null){
				animals[i] = anim;
				animalCounter = animalCounter + 1;
				return true;
			}
		}
		return false;
	}
	public boolean addClone (Animal anim) throws CloneNotSupportedException {
		return add((Animal)anim.clone());
	}
	public void makeNoise(){			// all animals make their sound (Moo, Cluck, etc)
		for(Animal animal: animals)
			animal.sound();
	}
	public void feedAnimals(){ 			// restore energy of all animals and deduct amount eaten from availableFood
		for(Animal animal : animals)
			if(availableFood >= Math.min(animal.getMealAmount(), (100-animal.getEnergy()))) 
			// no penalty if student uses:  if(availableFood >= animal.getMealAmount())
				availableFood -= animal.eat();
			else
				System.out.println("Not enough food for your animals! You need to collect more food items.");
	}
	public double getAvailableFood() {
		return availableFood;
	}
	public void setAvailableFood(double availableFood) {
		if(availableFood>=0 && availableFood<=1000)
			this.availableFood = availableFood;
	}
	public Animal[] getAnimals() {
		int animalCounter = 0;
		for(int i = 0; i < animals.length; i++){
			if(animals[i] != null){
				animalCounter = animalCounter + 1;
			}
			else{}
		}
		Animal[] realAnimals = new Animal[animalCounter];
		for(int i = 0; i < animalCounter; i++){
			realAnimals[i] = animals[i];
		}
		return realAnimals;
	}
	public void animSort(){
		if(animalCounter < animals.length){
			Animal[] temp = getAnimals();
			Arrays.sort(temp);
			System.arraycopy(temp, 0, animals, 0, animalCounter);
		}
		else{
			Arrays.sort(animals);
		}
	}
	public void printAnimals(){
		for(int i = 0; i < animalCounter; i++){
			String s = animals[i].toString();
			System.out.println(s);
		}

	}
	public void getNumChicken(){
		int chickenCounter = 0;
		for(int i = 0; i < animalCounter; i++){
			if(animals[i] instanceof Chicken){
				chickenCounter = chickenCounter + 1;
			}
		}
		System.out.println("Chickens: " + chickenCounter);
	}
	public void getNumCow(){
		int cowCounter = 0;
		for(int i = 0; i < animalCounter; i++){
			if(animals[i] instanceof Cow){
				cowCounter = cowCounter + 1;
			}
		}
		System.out.println("Cows: " + cowCounter);
	}
	public void getNumLlama(){
		int llamaCounter = 0;
		for(int i = 0; i < animalCounter; i++){
			if(animals[i] instanceof Llama){
				llamaCounter = llamaCounter + 1;
			}
		}
		System.out.println("Llamas: " + llamaCounter);
	}
	public void printSummary(){
		System.out.println("Animal Count: " + animalCounter);
		getNumChicken();
		getNumCow();
		getNumLlama();
		System.out.println("Food: " + getAvailableFood());
	}
}
