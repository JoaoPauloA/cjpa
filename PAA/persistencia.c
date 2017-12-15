#include<stdio.h>
#include<stdlib.h>

int *startVet(int n)
{
    int * array = (int *) calloc (n+1, sizeof (int));
    int i = 0,count = 0;
    for(i; i< n; i++)
        scanf("%d",&array[i]);
    array[n] = '\0';
    return array;
}

int *intercala(int *x, int *y, int c)
{
    int w[c+1], i = 0, j = 0, k =0, cont = 0;
    while(x[i]!='\0' && y[j] != '\0')
    {
        if(x[i]< y[j])
            w[k++] = x[i++];
        else if(x[i] == y[j])
        {
            w[k++] = x[i++];
            cont++;
        }
        else
            w[k++] = y[j++];
    }
    while(x[i]!='\0') w[k++] = x[i++];
    while(y[j]!='\0') w[k++] = y[j++];

    w[k] = '\0';

    int * array = (int *) calloc ((c-cont)+1, sizeof (int));

    array[0] = w[0];
    k = 1;
    int contadora = 0, indice;
    while(w[k]!='\0')
    {
        if(w[k] > array[contadora])
        {
            array[contadora+1] = w[k];
            contadora++;
        }
        k++;
    }
    array[k] = '\0';
    return array;

}
int *mergeSort(int *v, int a,int b)
{
    printf("a = %d e b = %d\n", a,b);
    int q;
    if(a < b)
    {
        q = ((b+a)/2);
        int *x, *y, *c;
        x = mergeSort(v, a, q);
        y = mergeSort(v, q+1, b);
        int contadora = a+b+1;
        c = intercala(x, y, contadora);
        free(x);
        free(y);
        return c;
    }
    int * array = (int *) calloc ((a+b+1), sizeof (int));
    array[0] = v[a];
    array[1] = '\0';
    return array;
}


int main()
{
    int * a, *v, size;
    printf("digite o tamanho do vetor: ");
    scanf("%d",&size);
    printf("vetor \n");
    a = startVet(size);

    v = mergeSort(a,0,size-1);


    int i = 0;
    printf("\n main\n");
    while(v[i]!='\0')
    {
        printf("%d",v[i++]);
        if(v[i]!='\0')
            printf("-");
    }
    free(a);

    return;
}
