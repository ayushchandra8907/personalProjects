#include <iostream>
#include <cmath>
#include <vector>


bool isPrime(long n){
    for(int i = 2; i<sqrt(n); i++){
        if(n%i == 0){
            return false;
        }
    }

    return true;
}

vector<int> primeFactorize(long n){
    vector<int> factors;

    if(n % 2 == 0){
        factors.push_back(2);
    }

    for(long i = 3; i<=n; i+=2){
        if(n%i == 0){
            if(isPrime(i)){
                factors.push_back(i);
            }
        }
    }

    return factors;
}

int main() {
    long num = 600851475143;

    for (int i: primeFactorize(num)) {
        cout << i << "  ";
    }
  
}