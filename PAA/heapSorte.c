//Algoritmo Heapsort
#include <stdio.h>

void troca(int v[], int a, int b){
	int aux = v[a];
	v[a] = v[b];
	v[b] = aux;
}

void transformaHeap(int v[], int m){
	int k, f;
	for(k = 1; k < m; k++){
		f = k+1;
		while(f > 1 && v[f/2] < v[f]){
			troca(v, f/2, f);
			f/=2;
		}
	}
}

void sacode(int v[], int m){
	 while(m >= 1){
	 	transformaHeap(v,m);
	 	troca(v,1,m);
	 	m--;
	 }
}
void printS(int v[], int n){
    for(int i = 1; i < n; i++){
    	if(2*i <= n)
    		printf(" %d =  %d\n",v[i], v[2*i]);
    	if(2*i+1<=n)
    		printf(" %d =  %d\n",v[i], v[2*i+1]);
    }
}

int main(){
	printf(">>> ");
	int n;
	scanf("%d",&n);
	int v[n+1];
	for (int i = 1; i <= n; i++){
		scanf("%d",&v[i]);
	}

	sacode(v,n);
	printf("vetor ordenado>>> [");
	for (int i = 1; i <= n; i++){
		printf(" %d ",v[i]);
	}
	printf("]\n");
	return 0;
}