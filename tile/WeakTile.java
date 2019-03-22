package tile;
import animal.Animal;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : WeakTile.java
//  @ Date : 2019. 03. 20.
//  @ Author : 
//
//



public class WeakTile extends Tile {
	public int Count;

	public void Step() {
	}
	
	public Tile[] GetNeighbours() {
		return super.GetNeighbours();
	}
	
	public boolean Accept(Animal a) {
		if(super.getAnimal()==null)
			a.Move(this);
		
		else {
			super.getAnimal().HitBy(a);
		}
		
		return true;
	}
	
	public void Remove() {
	}
	
	public Animal getAnimal() {
		return super.getAnimal();
	}
	
	public void DecreaseCount() {
		Count--;
	}
	public void Add(Animal a) {
		DecreaseCount();
		if(Count==0)
			a.Die();
	}
}