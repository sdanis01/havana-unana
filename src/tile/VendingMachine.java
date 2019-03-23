package tile;
import animal.Animal;
import def.Logger;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : VendingMachine.java
//  @ Date : 2019. 03. 20.
//  @ Author : 
//
//




public class VendingMachine extends Tile {
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", new Object[] {});
		for(Tile n: neighbours) {
			Animal a=n.getAnimal();
			a.ReactToBeep();
		}
		Logger.get_static_logger().exit(this, "Step", new Object[] {}, "");
	}
	
	public boolean Accept(Animal a) {
		return true; //hogy ne dobjon errort
	}
}
