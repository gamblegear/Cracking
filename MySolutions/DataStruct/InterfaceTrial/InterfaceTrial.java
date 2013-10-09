public class InterfaceTrial {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.shout();
		System.out.println(dog.count());
		
		cat.shout();
		System.out.println(cat.count());
	}
}

interface Animal {
	// Yes, it is by default final
	int num = 5;
	
	public void shout();
	public int count();
}

class Dog implements Animal {
	public void shout() {
		System.out.println("WangWang");
	}
	
	public int count() {
		return num;
	}
}

class Cat implements Animal {
	public void shout() {
		System.out.println("MeoMeo");
	}
	
	public int count() {
		return num;
	}
}
