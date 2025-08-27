#include <iostream>
#include <string>
using namespace std;

int expandFromCenter(const string &s, int left, int right) {
    while (left >= 0 && right < s.length() && s[left] == s[right]) {
        left--;
        right++;
    }
    return right - left - 1;
}

string longestPalindrome(string s) {
    if (s.length() <= 1){
    	 return s; 
	  }  
    
    int start = 0, maxLen = 1; 
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandFromCenter(s, i, i);
        int len2 = expandFromCenter(s, i, i + 1);
        
        int currLen = max(len1, len2);
        
        if (currLen > maxLen) {
            maxLen = currLen;
            start = i - (currLen - 1) / 2;
        }
    }
    return s.substr(start, maxLen);
}


int main() {
    string s;
    cout << "Enter string: ";
    cin >> s;
    
    string result = longestPalindrome(s);
    cout << "Longest Palindromic Substring: " << result << endl;
    
    return 0;
}
