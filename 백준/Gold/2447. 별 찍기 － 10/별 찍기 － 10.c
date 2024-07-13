#include<stdio.h>

int star(int x, int y, int size)
{
	if ((x / size) % 3 == 1 && (y / size) % 3 == 1)  //x와 y가 둘다 1일 경우만 
	{
		printf(" ");
	}
	else
	{
		if (size < 3)
		{
			printf("*");
		}
		else
			star(x, y, size / 3);
	}
}
int main(void)
{
	int size;
	scanf("%d", &size);
	for (int x = 0; x < size; x++)
	{
		for (int y= 0; y < size; y++)
		{
			star(x, y, size);
		}
		printf("\n");
	}
}