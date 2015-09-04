import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Lightning extends PApplet {

int startX = 250;
int startY = 0;
int endX = 250;
int endY = 0;
int cirX = -90;
float thickness = 2;
int fillOne = 0;
int fillTwo = 0;
int fillThree = 0;

public void setup()
{
 	size(500,500);
 	frameRate (8);
}

public void draw()
{
	background(0,0,0);
	strokeWeight(thickness);
	stroke((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	while(endY < 550)
	{

		endX = startX + (int)(Math.random()*18-9);
		endY = startY + (int)(Math.random()*9);
		line(startX, startY, endX, endY);
		startX = endX;
		startY = endY;
	}

	while(cirX < 500)
	{
		cirX = cirX + 75;
		noStroke();
		fill(fillOne, fillTwo, fillThree);
		ellipse(cirX,15,130,130);
	}
}

public void mousePressed()
{
	cirX = -90;
	fillOne = (int)(Math.random()*255);
	fillTwo = (int)(Math.random()*255);
	fillThree = (int)(Math.random()*255);
	startX = mouseX;
	startY = 0;
	endX = 250;
	endY = 0;
	thickness = thickness + 0.1f;
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Lightning" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
