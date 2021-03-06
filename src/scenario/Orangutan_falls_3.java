package scenario;

import animal.Orangutan;
import def.Game;
import def.Logger;
import tile.Tile;
import tile.WeakTile;

public class Orangutan_falls_3 implements Scenario{

	Orangutan o;
	Tile t1;
	WeakTile wt;
	Game g;
	
	@Override
	public void execute() {
		init();
		run();
	}
	
	private void init() {
		Logger l=Logger.get_static_logger();
		Logger.breakLine();
		
		o=new Orangutan();
		t1=new Tile();
		wt=new WeakTile();
		g=new Game();
		
		//Tile.setGame(g);
		Orangutan.setGame(g);
		
		l.Add(o, "o");
		l.Add(t1, "t1");
		l.Add(wt, "wt");
		l.Add(g, "g");
		
		t1.Add(o);
		wt.SetNeighbours(new Tile[] {t1});
		t1.SetNeighbours(new Tile[] {wt});
		
		wt.set_count(1);
		
		Logger.breakLine();
	}
	
	private void run() {
		o.Move(wt);
	}
	

	
}
