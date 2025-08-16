#include <iostream>
using namespace std;

int main() {
    int n = 5;
    int arr[] = {1, 2, 4, 5};

    int x1 = 0, x2 = 0;

    for(int i = 1; i <= n; i++) {
        x1 ^= i;
    }

    for(int i = 0; i < n-1; i++) {
        x2 ^= arr[i];
    }

    int missing = x1 ^ x2;
    cout << "Missing number: " << missing << endl;

    return 0;
}
