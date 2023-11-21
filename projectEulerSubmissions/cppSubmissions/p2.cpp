#include <iostream>
#include <cmath>


using namespace std;


//method for getting fibonaci numebr
int fib(int n){
    if (n <= 2){
        return n;
    } else {
        return fib(n-1) + fib(n-2);
    }
}

int main() {
    int x = 2;
    int sum = 0;

    while(fib(x) < 4*pow(10, 6)){
        sum += fib(x);
        x += 3;
    }

    cout << sum;
}


