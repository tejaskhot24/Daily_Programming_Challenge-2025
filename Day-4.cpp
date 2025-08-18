#include <iostream>
using namespace std;

int nextGap(int gap) {
    if (gap <= 1){
    	return 0;
	} 
    return (gap / 2) + (gap % 2); 
}

void mergeArrays(int arr1[], int m, int arr2[], int n) {
    int gap = m + n;   
    gap = nextGap(gap);

    while (gap > 0) {
        int i = 0, j = gap;

        while (j < (m + n)) {
            int a, b;
            if (i < m){
            	a = arr1[i];
			      }
		
            else{
            	a = arr2[i - m];
			      }
            if (j < m){
            	b = arr1[j];
			      } 
            else{
            	b = arr2[j - m];
			      } 


            if (a > b) {
                if (i < m && j < m) {
                    swap(arr1[i], arr1[j]);
                } else if (i < m && j >= m) {
                    swap(arr1[i], arr2[j - m]);
                } else {
                    swap(arr2[i - m], arr2[j - m]);
                }
            }

            i++;
            j++;
        }

        gap = nextGap(gap);
    }
}

int main() {
    int m, n;
    cout << "Enter size of arr1: ";
    cin >> m;
    cout << "Enter size of arr2: ";
    cin >> n;

    int arr1[m], arr2[n];

    cout << "Enter " << m << " sorted elements for arr1: ";
    for (int i = 0; i < m; i++){
    	cin >> arr1[i];
	} 

    cout << "Enter " << n << " sorted elements for arr2: ";
    for (int j = 0; j < n; j++){
    	 cin >> arr2[j];
	}

    mergeArrays(arr1, m, arr2, n);

    cout << "\narr1 = ";
    for (int i = 0; i < m; i++){
    	cout << arr1[i] << " ";
	} 

    cout << "\narr2 = ";
    for (int j = 0; j < n; j++){
    	cout << arr2[j] << " ";
	}

    cout << endl;
    return 0;
}
