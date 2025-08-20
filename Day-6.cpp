#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

void findZeroSumSubarrays(int arr[], int n) {
    unordered_map<int, vector<int>> mp;
    int sum = 0;
    bool found = false;

    for (int i = 0; i < n; i++) {
        sum += arr[i];
      
        if (sum == 0) {
            cout << "(0, " << i << ")\n";
            found = true;
        }

        if (mp.find(sum) != mp.end()) {
            for (int idx : mp[sum]) {
                cout << "(" << idx + 1 << ", " << i << ")\n";
                found = true;
            }
        }

        mp[sum].push_back(i);
    }

    if (!found) {
        cout << "No subarray with sum 0 found.\n";
    }
}

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;

    int arr[100];
    cout << "Enter elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cout << "Zero-sum subarrays (start, end):\n";
    findZeroSumSubarrays(arr, n);

    return 0;
}
