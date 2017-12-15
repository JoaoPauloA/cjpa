#include <stdio.h>

int m[100][100];

// troca sem repetir moedas // problema da mochila

int bottonUp(int *v,int capacidade,int n){
    int r[capacidade];
    for(int i=0; i<=n; i++) m[i][0]=0;
    for(int i=0; i<=capacidade; i++) m[0][i]=0;

    for(int i=1; i<=n; i++) //Vetor das moedas
        for(int j=1; j<=capacidade; j++){ //Vetor do que trocar
            if(v[i]<=j){
                m[i][j] = v[i] + m[i-1][j-v[i]];
                r[j] = v[i];
            }
            else
                m[i][j] = m[i-1][j];
        }
/*
    for(int i=0; i<=n; i++){
        for(int j=0; j<=capacidade; j++)
            printf("%d ",m[i][j]);
        printf("\n");
    }
*/
    if(m[n][capacidade] == capacidade)
        print(r,capacidade);

    return m[n][capacidade];
}

void print(int *r,int valor){
    while(valor>0){
        printf("%d ",r[valor]);
        valor-=r[valor];
    }
    printf("\n");
}

void main(){
    int vet[]= {-1,1,3,5,4,6};
    printf("%d\n",bottonUp(vet,9,5));
}
