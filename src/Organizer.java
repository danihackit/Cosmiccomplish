/*
 
 

   ____                         _                
  / __ \_________ _____ _____  (_)___  ___  _____
 / / / / ___/ __ `/ __ `/ __ \/ /_  / / _ \/ ___/
/ /_/ / /  / /_/ / /_/ / / / / / / /_/  __/ /    
\____/_/   \__, /\__,_/_/ /_/_/ /___/\___/_/     
          /____/                                                            


                       
 ______         __      
/_  __/__ ____ / /__ ___
 / / / _ `(_-</  '_/(_-<
/_/  \_,_/___/_/\_\/___/

    

  _____                 ____       __  ___         
 / ___/__ ___ _  ___   / __ \__ __/ /_/ (_)__  ___ 
/ (_ / _ `/  ' \/ -_) / /_/ / // / __/ / / _ \/ -_)
\___/\_,_/_/_/_/\__/  \____/\_,_/\__/_/_/_//_/\__/ 

Game Features:

- Home Screen
	- About Screen
	- Startup Screen/First Time Education

- Task list

- Planet Timer

- Minigames
	- Spaceball

- Astronaut Task Animations

- Save Files

   ___             _         __    ___                _                        __    
  / _ \_______    (_)__ ____/ /_  / _ \___ ___ ___ __(_)______ __ _  ___ ___  / /____
 / ___/ __/ _ \  / / -_) __/ __/ / , _/ -_) _ `/ // / / __/ -_)  ' \/ -_) _ \/ __(_-<
/_/  /_/  \___/_/ /\__/\__/\__/ /_/|_|\__/\_, /\_,_/_/_/  \__/_/_/_/\__/_//_/\__/___/
             |___/                         /_/                                       
x You must make the aliens shoot randomly.
x You lose when the alien shoots your ship
x You lose when the aliens take over your ship
x You win when you get rid of all the aliens
x You must have a win screen that tells how long it took you to win ( time)
x You must have a lose screen
x Your aliens must move across the screen and down
x Your ship must move with either keyboard or mouse.
x You must have a way for the ship to shoot- either mouse pressed or a key
x You  must have sound in at least 3 of the following places:
	x When the ship shoots
	- When the shot collides with an alien
	- When an alien shot collides with a ship
	x When the alien shoots
	x When you win
	x When you lose
x You must have two cheat codes
 

Rubric:

x Working game = 10 points

x Cheat Codes = 10 points (5 points each)

x Collision = 10 points

x Sound = 25 points

x Interface (either mouse or keyboard)= 10 points

x Graphics = 15 points

x Win/Lose/timer = 20 points 

10+10+10+15

My Score: 100%


if(!activeAlienShips.isEmpty()) {
			for(int j=0; j<activeAlienShips.size(); j++) {
				g2d.drawImage(activeAlienShips.get(j).getImg().getImage(),activeAlienShips.get(j).getX(), activeAlienShips.get(j).getY(), activeAlienShips.get(j).getW(), activeAlienShips.get(j).getH(), this);
				
				for(int k = 0; k<activePlayerProjectiles.size();k++) {
					if(((activeAlienShips.get(j).getY() <= activePlayerProjectiles.get(k).getY() + activePlayerProjectiles.get(k).getH() && activePlayerProjectiles.get(k).getY() <= activeAlienShips.get(j).getY() + activeAlienShips.get(j).getH()) && (activeAlienShips.get(j).getX() <= activePlayerProjectiles.get(k).getX() + activePlayerProjectiles.get(k).getW() && activePlayerProjectiles.get(k).getX() <= activeAlienShips.get(j).getX() + activeAlienShips.get(j).getW())) && activePlayerProjectiles.get(k).getYm()> 0){
						activePlayerProjectiles.remove(k);
						activeAlienShips.remove(j);
						
						//Object 1 = Projectile -> activePlayerProjectiles.get(k).get
						//Object 2 = Alienship -> activeAlienShips.get(j).get
					} 
				}
			}
		}

Collision code:
if(((object2Y <= object1Y + object1H && object1Y <= object2Y + object2H) && (object2X <= object1X + object1W && object1X <= object2X + object2W)) && moving object's y Movement > 0){





*/
public class Organizer {

}
