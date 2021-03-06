package tile;
import animal.Animal;
import def.Logger;
import def.Steppable;

/**
 * Csempe �soszt�ly
 * 
 */
public class Tile implements Steppable {
		
	/**
	 * Szomsz�dos csemp�k t�mbje
	 */
	protected Tile[] neighbours;
	/**
	 * Csemp�n l�v� �llat
	 */
	protected Animal myAnimal;
	
	public Tile() {
		neighbours=null;
		myAnimal=null;
	}
	
	/**
	 * Csempe l�p
	 * 
	 * Alap�rtelmezetten nem csin�l semmit, a lesz�rmazottakban lesz haszna
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
	/**
	 * Szomsz�dos csemp�k lek�rdez�se
	 * 
	 * @return szomsz�dos csemp�k
	 */
	public Tile[] GetNeighbours() {
		Logger.get_static_logger().enter(this, "GetNeighbours", null);
		Logger.get_static_logger().exit(this, "GetNeighbours", null, "neighbours");
		return neighbours;
	}
	
	/**
	 * Szomsz�dos csemp�k be�ll�t�sa
	 * 
	 * @param t megadott csemp�k
	 */
	public void SetNeighbours(Tile[] t) {
		Logger.get_static_logger().enter(this, "SetNeighbours", t);
		
		neighbours=t;
		
		Logger.get_static_logger().exit(this, "SetNeighbours", t, "");
	}
	
	/**
	 * Csempe kezeli, ha r�l�pne egy �llat
	 * 
	 * @param a �rkez� �llat
	 * @return kuki
	 */
	public void Accept(Animal a) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {a});
		
		if(myAnimal==null)
			a.Move(this);
		else {
			myAnimal.HitBy(a);
		}

		Logger.get_static_logger().exit(this, "Accept", new Object[] {a}, "");
	}
	
	/**
	 * �llat csemp�re helyez�se
	 * 
	 * @param a �llat
	 */
	public void Add(Animal a) {
		Logger.get_static_logger().enter(this, "Add", new Object[] {a});
		
		a.SetTile(this);
		myAnimal=a;
		
		Logger.get_static_logger().exit(this, "Add", new Object[] {a}, "");
	}
	
	/**
	 * �llat elt�vol�t�sa a csemp�r�l
	 * 
	 */
	public void Remove() {
		Logger.get_static_logger().enter(this, "Remove", null);
		
		myAnimal=null;
		
		Logger.get_static_logger().exit(this, "Remove", null, "");
	}
	
	/**
	 * Csemp�n l�v� �llat lek�rdez�se
	 * 
	 * @return csemp�n l�v� �llat
	 */
	public Animal GetAnimal() {
		Logger.get_static_logger().enter(this, "getAnimal", null);
		Logger.get_static_logger().exit(this, "getAnimal", null, "myAnimal");
		
		return myAnimal;
	}
}
