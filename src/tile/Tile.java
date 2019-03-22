package tile;
import animal.Animal;
import def.Logger;
import def.Steppable;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Tile.java
//  @ Date : 2019. 03. 20.
//  @ Author : 
//
//




public class Tile implements Steppable {
	private Tile[] neighbours;
	private Animal myAnimal;
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
	public Tile[] GetNeighbours() {
		Logger.get_static_logger().enter(this, "GetNeighbours", null);
		Logger.get_static_logger().exit(this, "GetNeighbours", null, "neighbours");
		return neighbours;
	}
	
	public void SetNeighbours(Tile[] t) {
		Logger.get_static_logger().enter(this, "SetNeighbours", t);
		neighbours=t;
		Logger.get_static_logger().exit(this, "SetNeighbours", t, "");
	}
	
	public boolean Accept(Animal a) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {a});
		if(myAnimal==null)
			a.Move(this);
		
		else {
			myAnimal.HitBy(a);
		}
		
		Logger.get_static_logger().exit(this, "Accept", null, "true");
		
		return true;
	}
	
	public void Add(Animal a) {
		Logger.get_static_logger().enter(this, "Add", new Object[] {a});
		
		a.SetTile(this);
		myAnimal=a;
		
		Logger.get_static_logger().exit(this, "Add", new Object[] {a}, "");
	}
	
	public void Remove() {
		Logger.get_static_logger().enter(this, "Remove", null);
		
		myAnimal=null;
		
		Logger.get_static_logger().exit(this, "Remove", null, "");
	}
	
	public Animal getAnimal() {
		Logger.get_static_logger().enter(this, "getAnimal", null);
		Logger.get_static_logger().exit(this, "getAnimal", null, "myAnimal");
		return myAnimal;
	}
}