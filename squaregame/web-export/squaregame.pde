rectangle player = new rectangle(140,200, 15, 15, 0);
int health = 0;

rectangle[] rectangles = new rectangle[100000];
float shift;
int i = 1;
void setup()
{
  size(300,300);
  rectangles[1] = new rectangle(70, -300 ,20,1000, 0);
}
void draw()
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
     rectangles[i] = new rectangle(60 + int(random(30)-15), - 10 - length ,20, length, int(random(58) - 29) );
     
   }


 fill(200);
 rect(player.xlocation, player.ylocation, player.size, player.size);
 fill(0);
  rect(player.xlocation, player.ylocation, player.size, health);
}
void keyPressed()
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

