#include<stdio.h>
int somaRussa(int a, int b){
	if(a == 1)return b;
	if(a == 0) return 0;
	if(a%2 == 1) return b + somaRussa((a/2), (b*2));
	return somaRussa((a/2), (b*2));
}

int main(){
	printf("%d\n", somaRussa(9, 82));

	return 0;
}