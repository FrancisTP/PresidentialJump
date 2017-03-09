package com.francistp.game.framework.math;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;

public class Circle {
	public final Vector2 center = new Vector2();
	public float radius;
	public float x, y;
	
	public Circle (float x, float y, float radius){
		this.center.set(x, y);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void drawShape(SpriteBatcher batcher){
		batcher.drawSprite(x, y, radius * 2, radius * 2, Assets.circle);
	}
}
