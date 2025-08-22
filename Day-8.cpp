#include <iostream>
#include <string>
#include <sstream>
#include <vector>
using namespace std;

string reverseWords(const string &s) {
    vector<string> words;
    string word;
    istringstream stream(s);

    while (stream >> word) {
        words.push_back(word);
    }

    if (words.empty()) return "";

    string result = words.back();
    for (int i = words.size() - 2; i >= 0; --i) {
        result += " " + words[i];
    }

    return result;
}

int main() {
    string s;
	  cout<<"Enter the string/words : ";
    getline(cin, s);


    cout << "\nReverse String/words :" << reverseWords(s) << endl;

    return 0;
}
