#include<stdio.h>
#include<string.h>
#include<stdlib.h>
char my_key[58] = "3jnlnFtKOpqi56XT7IB0a5VYXXyndTv_mpfX9Cou43M=";
int hide[58] = {85, 7, 183, 91, 409, 675, 845, 1071, 1357, 1891, 1288, 2651, 2971, 2581, 4261, 5071, 5685, 6673, 6440, 8763, 10013, 11621, 12835, 12871, 14610, 18073, 20428, 22399, 24931, 25685, 30564, 33439, 36596, 37089, 40842, 44027, 49246, 54291, 59190, 63511, 68013, 73657, 75400, 83799, 89357, 96037, 98776, 109439, 116195, 122499, 130130, 138511, 146268, 150541, 159279, 168159, 177433};

void flag(char str[100]){
    printf("Please, decrypt file!!!. Input is guide");
    exit(0);
}


int main(){
    printf("Welcome to this challenge by Thorse\n");
    char u_inp[100];
    int check[58];
    printf("Input: ");
    scanf("%s", u_inp);
    for (int i = 0; i < strlen(u_inp); i++){
        int temp = (u_inp[i] * i + i * i* i);
        check[i] = temp ^ u_inp[i];
    }    
    for (int i = 0; i < strlen(u_inp); i++){
        if (check[i] != hide[i]){
            goto label0;
        }
    }
    flag(u_inp);
    label0:
        printf("Bad Input!!! Fighting");
        return 0;
    system("pause");
}
