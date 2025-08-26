#include <iostream>
#include <stack>
#include <string>
using namespace std;

bool isValid(string s) {
    if (s.size() % 2 != 0){
        return false;
    } 

    stack<char> st;

    for (char ch : s) {
        if (ch == '(' || ch == '{' || ch == '[') {
            st.push(ch);
        } else {
            if (st.empty()){
                return false;
            } 

            char top = st.top();
            st.pop();

            if ((ch == ')' && top != '(') ||
                (ch == '}' && top != '{') ||
                (ch == ']' && top != '[')) {
                return false;
            }
        }
    }

    return st.empty();
}

int main() {
    cout << boolalpha; 
    cout << isValid("()") << endl;       
    cout << isValid("([)]") << endl;     
    cout << isValid("[{()}]") << endl;  
    cout << isValid("") << endl;         
    cout << isValid("{[}") << endl;      
    return 0;
}
