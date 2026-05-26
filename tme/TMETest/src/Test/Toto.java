package Test;

public class Toto {

	@ExecuteOnBuilding(v=2)
	public void f() {
		System.out.println("f");
	}
	
	@ExecuteOnBuilding(v=3, nom="saly")
	public void g() {
		System.out.println("g");
	}
	
	public void h() {
		System.out.println("h");
	}
}
