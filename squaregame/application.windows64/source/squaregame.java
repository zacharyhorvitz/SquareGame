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

public class squaregame extends PApplet {

rectangle player = new rectangle(140,200, 15, 15, 0);
int health = 0;

rectangle[] rectangles = new rectangle[100000];
float shift;
int i = 1;
public void setup()
{
  size(300,300);
  rectangles[1] = new rectangle(70, -300 ,20,1000, 0);
}
public void draw()
{
 

  
  background(100);
  fill(0);
   rect(0,0,40,300);
    rect(260,0,40,300);
   
  for(int w = i; w > 0; w--)
  {
 rectangles[w].ylocation =  rectangles[w].ylocation + 3 + i/100;
  rect(140 + rectangles[w].xlocation + rectangles[w].shift,rectangles[w].ylocation , rectangles[w].size,rectangles[w].size1);
   rect(150 - rectangles[w].xlocation + rectangles[w].shift, rectangles[w].ylocation , rectangles[w].size,rectangles[w].size1);
   if(player.xlocation > rectangles[w].xlocation && player.xlocation < rectangles[w].xlocation + rectangles[w].size1 && player.ylocation > rectangles[w].ylocation && player.ylocation < rectangles[w].ylocation + rectangles[w].size1)
   {
     if(health < 15)
     {
     health++;
     }
  }
  }
   if(rectangles[i].ylocation >= 0)
   {
          i++;
          int length = 40; //int(random(200) + 10);
     rectangles[i] = new rectangle(60 + PApplet.parseInt(random(30)-15), - 10 - length ,20, length, PApplet.parseInt(random(58) - 29) );
     
   }


 fill(200);
 rect(player.xlocation, player.ylocation, player.size, player.size);
 fill(0);
  rect(player.xlocation, player.ylocation, player.size, health);
}
public void keyPressed()
{
  if(key == 'a')
  {
    player.xlocation = player.xlocation - 6;
    
  }
  else if(key == 'd')
  {
      player.xlocation = player.xlocation + 6;
  }
}


class rectangle
{
  int xlocation;
  int ylocation;
  int size;
  int size1;
  int shift;

  rectangle(int x, int y, int s, int s1, int move)
  {
    xlocation = x;
    ylocation = y;
   size = s;
   size1 = s1;
   shift = move;
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "squaregame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
