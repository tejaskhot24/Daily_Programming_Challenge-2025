#include <iostream>
#include <vector>
using namespace std;

int trapRainWater(vector<int>& height) {
    int n = height.size();
    if (n < 3) return 0; 

    int left = 0, right = n - 1;  
    int leftMax = 0, rightMax = 0;
    int water = 0;

    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) {
                leftMax = height[left];   
            } else {
                water += leftMax - height[left]; 
            }
            left++;
        } else {
            if (height[right] >= rightMax) {
                rightMax = height[right]; 
            } else {
                water += rightMax - height[right]; 
            }
            right--;
        }
    }
    return water;
}

int main() {
    int n;
    cout << "Enter number of bars: ";
    cin >> n;
	  cout<<endl;
	
    vector<int> height(n);
    for (int i = 0; i < n; i++) {
    	cout << "Enter " << i+1 << " bar heights: ";
        cin >> height[i];
    }

    cout << "\nTotal trapped water = " << trapRainWater(height) << endl;
    return 0;
}
