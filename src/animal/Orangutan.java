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
	 * A panda fog�st blokkol� sz�ml�l�
	 */
	private int grabBlock;
	
	/**
	 * A k�vetkez� l�p�s ir�nya
	 */
	private int dir;
	
	/**
	 * Konstruktor
	 */
	public Orangutan() {
		grabBlock=0;
		dir=0;
	}
	
		
	/**
	 * Or�ngut�n l�p
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		if(grabBlock!=0) grabBlock--;
		
		Tile[] neighbours=myTile.GetNeighbours();	
		Tile t2=neighbours[dir];
		t2.Accept(this);
		
		dir=0;
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
	
	/**
	 * Or�ngut�n meghal, v�ge a j�t�knak
	 */
	public void Die() {
		Logger.get_static_logger().enter(this, "Die", null);

		//l�that�s�g
		Game.End(this);
		
		Logger.get_static_logger().exit(this, "Die", null, "");
	}	
	
	/**
	 * Or�ngut�n �tk�zik egy pand�val
	 * 
	 * Felszabad�tja azt, helyet cser�lnek, majd a k�vet�ket be�ll�tja
	 */
	public void CollideWith(Panda p) {
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {p});
		
		if(grabBlock == 0) {
			p.Let();
			p.Swap(myTile, this);
			
			p.Grab(this.follower);
			this.follower=p;
			p.DisableSteps();
			p.SetLeader(this);
		}

		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {p}, "");
	}
	
	/**
	 * Or�ngut�n �tk�zik egy m�sik or�ngut�nnal
	 * 
	 * Felszabad�tja azt, helyet cser�lnek, majd a k�vet�ket be�ll�tja
	 */
	public void CollideWith(Orangutan o) {
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {o});
		
		if(follower == null && grabBlock ==0) {
			this.Grab(o.Steal());
			o.Swap(myTile, this);
		}

		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {o}, "");
	}
	
	/**
	 * Ellopj�k t�le a k�vet�j�t
	 */
	public Panda Steal() {
		Panda ret=follower;
		follower=null;
		grabBlock=3;
		return ret;
	} 
	
	/**
	 * �nk�nt engedi el a h�zott pand�t
	 */
	public void Release() {
		if (follower!=null)
			follower.Let();
	}
	
	/**
	 * Egy m�sik �llat nekiment a pand�nak, aki visszajelez, hogy �tk�z�tt egy pand�val
	 */
	public void HitBy(Animal a) {
		Logger.get_static_logger().enter(this, "HitBy", new Object[] {a});
		
		a.CollideWith(this);
		
		Logger.get_static_logger().exit(this, "HitBy", new Object[] {a}, "");
	}
	
	/**
	 * Or�ngut�n kij�raton �thaladva be�ll�tja a bej�raton, hogy � ment �t rajta ut�na, �s nullra �ll�tja a followert
	 */
	public void Exit() {
		Logger.get_static_logger().enter(this, "Exit", null);

		((Entry)myTile).SetOrangutan(this);
		follower=null;
		
		Logger.get_static_logger().exit(this, "Exit", null, "");
	}

	/**
	 * Pontot az az or�ngut�nnak
	 */
	public void AddPoint() {
		Game.AddPoint(this);
	}
	
	//egy set dir a teszt miatt
	//lehet incdir hivogatni is
	public void SetDir(int d) {
		dir=d;
	}
	
	/**
	 * Ir�ny n�vel�se
	 */
	public void IncDir() {
		dir++;
		if (dir==myTile.GetNeighbours().length)
			dir=0;
	}
}
