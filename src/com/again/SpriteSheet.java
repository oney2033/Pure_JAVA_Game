package com.again;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	public final int SIZE;
	public int[] Pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("resa/textures/sheets/spritesheets.png",256);
	public static SpriteSheet spawn_level = new SpriteSheet("resa/textures/sheets/spawn_level.png",48);
	
	public SpriteSheet(String path, int size)
	{
		this.path = path;
		SIZE = size;
		Pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load()
	{
		try {
			BufferedImage image = ImageIO.read(new File(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, Pixels, 0, w);//将精灵表存储在pixels中
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
