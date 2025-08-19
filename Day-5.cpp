#include <iostream>
#include <vector>
#include <algorithm> 
using namespace std;

vector<int> findLeaders(int arr[], int n) {
    vector<int> leaders;
    int maxFromRight = arr[n - 1];

    leaders.push_back(maxFromRight);

    for (int i = n - 2; i >= 0; i--) {
        if (arr[i] >= maxFromRight) {
            leaders.push_back(arr[i]);
            maxFromRight = arr[i];
        }
    }

    reverse(leaders.begin(), leaders.end());
    return leaders;
}

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;

    int arr[100]; 
    cout << "Enter " << n << " elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    vector<int> leaders = findLeaders(arr, n);

    cout << "Leaders: ";
    for (int i = 0; i < leaders.size(); i++) {
        cout << leaders[i] << " ";
    }
    cout << endl;
    
    return 0;
}
