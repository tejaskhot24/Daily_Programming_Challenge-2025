#include <iostream>
using namespace std;

long long gcd(long long a, long long b) {
    while (b != 0) {
        long long temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

long long lcm(long long a, long long b) {
    return (a / gcd(a, b)) * b; 
}

int main() {
    long long N, M;
    cout << "Enter N and M : ";
    cin >> N >> M;

    cout << "\nLeast Common Multiple is : " << lcm(N, M) << endl;

    return 0;
}
