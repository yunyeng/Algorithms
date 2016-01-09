/*
CS204 Project One
The Logo language, which is particularly popular among personal computer users, made the concept of turtle graphics famous. Imagine a mechanical turtle that walks around the room under the control of a C program. The turtle holds a pen in one of two positions, up or down. While the pen is down, the turtle traces out shapes as it moves; while the pen is up, the turtle moves about freely without writing anything. In this problem you’ll simulate the operation of the turtle and create a computerized sketchpad as well.
Use a 50-by-50 array floor which is initialized to zeros. Read commands from an array that contains them. Keep track of the current position of the turtle at all times and whether the pen is currently up or down. Assume that the turtle always starts at position 0, 0 of the floor with its pen up. The set of turtle commands your program must process are shown in the figure below. Suppose that the turtle is somewhere near the center of the floor. The following “program” would draw and print a 12-by-12 square:
2 5,12 3 5,12 3 5,12 3 5,12 1
6
9
As the turtle moves with the pen down, set the appropriate elements of array floor to 1s. When the 6 command (print) is given, wherever there is a 1 in the array, display an asterisk, or some other character you choose. Wherever there is a zero, display a blank. Write a program to implement the turtle graphics capabilities discussed here. Write several turtle graphics programs to draw interesting shapes. Add other commands to increase the power of your turtle graphics language.
Command Meaning
1 Pen up
2 Pen down
3 Turn right
4 Turn left
5 10 Move forward 10 spaces (or a number other than 10) 
6 Print the 50-by-50 array
9 End of data (sentinel)
*/

#include <stdio.h>

int map[50][50];
int pen = 0; // 0 is up, 1 is down
int command;
int direction = 0; // 0 = up, 1 = right, 2 = down, 3 = left


void forward(int x){
	if(pen == 1){
		for(int i=0; i<x; i++){
			if(direction == 0){
				map[][]
			} else if(direction == 1){
				
			} else if(direction == 2){
				
			} else if(direction == 3){
				
			}
		}
	} else {
		if(direction == 0){
			
		} else if(direction == 1){
				
		} else if(direction == 2){
					
		} else if(direction == 3){
					
		}
	}
}

void printArray(){
	for(int i=0; i<50; i++){
		for(int j=0; j<50; j++){
			if(map[i][j] == 1){
				printf("*");
			} else if (map[i][j] == 0) {
				printf("  ");
			} else if(map[i][j] == 2) {
				printf("T");
			}
		}
		printf("\n");
	}
}

int main(int argc, char *argv[]) {
	for(int i=0; i<50; i++) for(int j=0; j<50; j++) map[i][j] = 0;
	map[0][0] = 2; // Turtle starts at 0 0
	int position[2];
	position[0] = 0;
	position[1] = 0;
	printf("Enter the command.\n");
	scanf("%d", &command);
	while(command != 9){
		switch(command){
			case 1:
				pen = 0;
				break;
			case 2:
				pen = 1;
				break;
			case 3:
				direction++;
				direction = direction % 4;
				break;
			case 4:
				direction--;
				direction = direction % 4;
				if(direction < 0) direction = direction * -1;
				break;
			case 5:
				forward(10);
				break;
			case 6:
				printArray();
				break;
		}
	}
	
}