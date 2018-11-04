#include <iostream>
#include <limits>

using namespace std;

template<typename T>
void showMinMax() {
	cout << "min: " << numeric_limits<T>::min() << endl;
	cout << "max: " << numeric_limits<T>::max() << endl;
}