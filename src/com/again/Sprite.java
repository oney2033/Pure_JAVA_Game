package com.again;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] Pixels;
	private int width, height;
	protected SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16,0,5,SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16,1,0,SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16,2,0,SpriteSheet.tiles);
	public static Sprite voidTile = new Sprite(16,0x1B87E0);
	
	//Spawn Level Sprites here
	public static Sprite spawn_grass = new Sprite(16,0,0,SpriteSheet.spawn_level);
	public static Sprite spawn_hedge = new Sprite(16,1,0,SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16,2,0,SpriteSheet.spawn_level);
	public static Sprite spawn_wall1 = new Sprite(16,0,1,SpriteSheet.spawn_level);
	public static Sprite spawn_wall2 = new Sprite(16,0,2,SpriteSheet.spawn_level);
	public static Sprite spawn_floor = new Sprite(16,1,1,SpriteSheet.spawn_level);
	
	
	//Player Sprites here
	
	public static Sprite player_forward = new Sprite(32,0,5,SpriteSheet.tiles);
	public static Sprite player_back = new Sprite(32,2,5,SpriteSheet.tiles);
	//public static Sprite player_left = new Sprite(32,3,5,SpriteSheet.tiles);
	public static Sprite player_side = new Sprite(32,1,5,SpriteSheet.tiles);
	
	public static Sprite player_forward_1 = new Sprite(32,0,6,SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(32,0,7,SpriteSheet.tiles);
	
	public static Sprite player_side_1 = new Sprite(32,1,6,SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite(32,1,7,SpriteSheet.tiles);
	
	public static Sprite player_back_1 = new Sprite(32,2,6,SpriteSheet.tiles);
	public static Sprite player_back_2 = new Sprite(32,2,7,SpriteSheet.tiles);
	
	public static Sprite dummy = new Sprite(32,0,0,SpriteSheet.dummy_down);
	
	//projectile Sprites here:
	public static Sprite projectile_wizard = new Sprite(16,0,0,SpriteSheet.projectile_wisard);
	
	//Particles
	public static Sprite particle_normal = new Sprite(3,0xffff00ff);
	public static Sprite square = new Sprite(2,0xff0000);
	
	protected Sprite(SpriteSheet sheet,int width, int height)
	{
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
	}
	
	public Sprite(int[] pixels, int width, int height) 
	{
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.Pixels = pixels;
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet)
	{
		SIZE = size;
		this.width = size;
		this.height = size;
		Pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int width, int height, int colour)
	{
		SIZE = -1;
		this.width = width;
		this.height = height;
		Pixels = new int[width * height];
		setColour(colour);
	}
	
	public Sprite(int size, int colour)
	{
		this.width = size;
		this.height = size;
		SIZE = size;
		Pixels = new int[SIZE * SIZE];
		setColour(colour);
	}
	

	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setColour(int colour)
	{
		for(int i = 0; i < width * height; i++)
		{
			Pixels[i] = colour;
		}
	}
	
	private void load()
	{
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				Pixels[x + y * width] = sheet.Pixels[(x + this.x) + (y + this.y) * sheet.WIDTH];
			}
		}
	}
}
