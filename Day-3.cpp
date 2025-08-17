#include <iostream>
using namespace std;

int findDuplicate(int arr[], int n) {
    int s = arr[0]; 
    int f = arr[0]; 

    do {
        s = arr[s];
        f = arr[arr[f]];
    } while (s != f);

    s = arr[0];
    while (s != f) {
        s = arr[s];
        f = arr[f];
    }

    return s; 
}

int main() {
    int n;
    cout << "Enter n (array will have n+1 elements): ";
    cin >> n;

    int arr[n + 1];
    cout << "Enter " << n + 1 << " elements (values between 1 and " << n << "):\n";
    for (int i = 0; i < n + 1; i++) {
    	cout<< "Enter " << i+1 << "th element :";
        cin >> arr[i];
    }
	cout<<"\n";
    cout << "Duplicate number: " << findDuplicate(arr, n + 1) << endl;

    return 0;
}
