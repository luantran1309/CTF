#include<iostream>
#include<string.h>
using namespace std;

void merge(int arr[], int p, int m, int r){
    int size1 = m - p + 1;
    int size2 = r - m;
    int a1[size1], a2[size2];
    for (int i = 0; i < size1; i++){
        a1[i] = arr[p + i];
    }
    for (int j = 0; j < size2; j++){
        a2[j] = arr[m + 1 + j];
    }
    int i = 0;
    int j = 0;
    int k = p;
    while (i < size1 && j < size2)
    {
        if(a1[i] <= a2[j]){
            arr[k] = a1[i];
            i++;
        }   
        else{
            arr[k] = a2[j];
            j++;
        }
        k++;
    }
    while (i < size1)
    {
        arr[k] = a1[i];
        k++;
        i++;
    }
    while (j < size2)
    {
        arr[k] = a2[j];
        k++;
        j++;
    }
}

void merge_sort(int arr[], int p, int r){
    if (p < r){
        int m = p + (r -p) /2;
        merge_sort(arr, p, m);
        merge_sort(arr, m+1, r);
        merge(arr, p, m, r);
    }
}
int check(int arr[], int decryption[], char flag[]){
    for(int i = 0; i < strlen(flag); i++){
        if(arr[decryption[i]] != flag[i]){
            return 0;
        }
    }
    return 1;
}
int main(){
    int decryption[] = {5, 9, 10, 11, 14, 7, 16, 3, 1, 11, 8, 1, 6, 4, 0, 11, 15, 17};
    cout << "This challenge created by Thorse!!!\n";
    cout << "Third chall :))\n";
    cout << "Input Flag: ";
    char flag[100];
    cin >> flag;
    int arr[100];
    for (int i = 0; i < strlen(flag); i++){
        arr[i] = flag[i];
    }
    merge_sort(arr, 0, strlen(flag) - 1);
    if (check(arr, decryption, flag) == 1){
        cout << "Congratulations :))\n";
    }
    else {
        cout << "Please try again :((\n";
    }
    system("pause");
}
