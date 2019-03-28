package animal;
import def.Game;
import def.Logger;
import tile.Entry;
import tile.Tile;

/**
 * Or�ngut�n oszt�ly
 * 
 * J�t�kosok �ltal ir�ny�tott �llat 
 */
public class Orangutan extends Animal {
	/**
	 * J�t�kot reprezent�l� oszt�ly
	 */
	static Game game;
	
	/**
	 * A panda fog�st blokkol� sz�ml�l�
	 */
	private int grabBlock;
	
	/**
	 * Adott j�t�k be�ll�t�sa
	 * 
	 * @param g j�t�k
	 */
	public static void setGame(Game g) {

		game=g;
		
	}
		
	/**
	 * Or�ngut�n l�p
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		Tile[] neighbours=myTile.GetNeighbours();	
		//k�s�bb megcsin�ljuk, hogy a v�lasztottra l�pjen
		Tile t2=neighbours[0];
		t2.Accept(this);
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
	
	/**
	 * Or�ngut�n meghal, v�ge a j�t�knak
	 */
	public void Die() {
		Logger.get_static_logger().enter(this, "Die", null);

		game.end(this);
		
		Logger.get_static_logger().exit(this, "Die", null, "");
	}	
	
	/**
	 * Or�ngut�n �tk�zik egy pand�val
	 * 
	 * Felszabad�tja azt, helyet cser�lnek, majd a k�vet�ket be�ll�tja
	 */
	public void CollideWith(Panda p) {
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {p});
		
		p.Let();
		p.Swap(myTile, this);
		
		p.Grab(this.follower);
		this.follower=p;
		p.DisableSteps();

		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {p}, "");
	}
	
	/**
	 * Or�ngut�n kij�raton �thaladva be�ll�tja a bej�raton, hogy � ment �t rajta ut�na
	 */
	public void Exit() {
		Logger.get_static_logger().enter(this, "Exit", null);

		((Entry)myTile).setOrangutan(this);
		
		Logger.get_static_logger().exit(this, "Exit", null, "");
	}

	public void AddPoint() {
		game.addPoint(this);
	}
}
