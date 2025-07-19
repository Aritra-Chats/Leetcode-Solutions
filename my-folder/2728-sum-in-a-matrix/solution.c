#include<stdio.h>
#include<stdlib.h>

int compareDesc(const void *a, const void *b) {
    return *(int *)b - *(int *)a;
}

int matrixSum(int** nums, int numsSize, int* numsColSize) {
    /*bool b_toContinue = false;
    for(int i=0; i < numsSize; i++) {
        if(numsColSize[i] == 0) b_toContinue = false;
        else {
            b_toContinue = true;
            break;
        }
    }
    if(!b_toContinue) return 0;
    int HighestReturnedElement = -999;
    int **aux = (int **)malloc(numsSize * sizeof(int *));
    for(int i = 0; i < numsSize; i++) aux[i] = (int *)malloc((numsColSize[i]-1) * sizeof(int));
    for(int i = 0; i < numsSize; i++) {
        int HighestEleminRow = -999;
        int index=0;
        for(int j=0; j < numsColSize[i]; j++) {
            if(nums[i][j] > HighestEleminRow) {
                HighestEleminRow = nums[i][j];
                index=j;
            }
        }
        for(int j=0; j < index; j++) aux[i][j] = nums[i][j];
        for(int j=index; j < numsColSize[i]-1; j++) aux[i][j] = nums[i][j+1];
        if(HighestEleminRow > HighestReturnedElement) HighestReturnedElement = HighestEleminRow;
        numsColSize[i] -= 1;
    }
    int sum = 0; 
    sum += matrixSum(aux, numsSize, numsColSize) + HighestReturnedElement;
    return sum;*/

    int maxColSize = 0;
    for(int i = 0; i < numsSize; i++) {
        if(numsColSize[i] > maxColSize) maxColSize = numsColSize[i];
        qsort(nums[i], numsColSize[i], sizeof(int), compareDesc); 
    }

    int sum=0;
    for(int col = 0; col < maxColSize; col++) {
        int MaxInCol = 0;
        for(int row = 0; row < numsSize; row++) {
            if(col < numsColSize[row]) {
                if(nums[row][col] > MaxInCol) MaxInCol = nums[row][col];
            }
        }
        sum+=MaxInCol;
    }
    return sum;
}
