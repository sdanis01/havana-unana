package animal;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : HungryPanda.java
//  @ Date : 2019. 03. 20.
//  @ Author : 
//
//

import def.Logger;

public class HungryPanda extends Panda {
	public void ReactToBeep() {
		Logger.get_static_logger().enter(this, "ReactToBeep", new Object[] {});
		
		myTile.Add(this);
		
		Logger.get_static_logger().exit(this, "ReactToBeep", new Object[] {},"");
	}
}
