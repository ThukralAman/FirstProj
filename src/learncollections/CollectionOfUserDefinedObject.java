package learncollections;

import java.util.HashMap;

class Person {
	int id;
	String name;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

public class CollectionOfUserDefinedObject {
	
	public static void main(String[] args) {
		HashMap<Person, String> hashMap = new HashMap<Person, String>();
		Person p1 = new Person(1, "Bob");
		Person p2 = new Person(2, "David");
		Person p3 = new Person(3, "John");
		Person p4 = new Person(2, "David");
		
		hashMap.put(p1, "Bob 1 number hai");
		hashMap.put(p2, "David 2 number hai");
		hashMap.put(p3, "John 3 number hai");
		hashMap.put(p4, "David fir se hai");
		
		for(Person obj: hashMap.keySet()) {
			System.out.println("(key = " + obj.id + " name = " + obj.name + " keyVal = )" + hashMap.get(obj));
		}
		
	}

}
