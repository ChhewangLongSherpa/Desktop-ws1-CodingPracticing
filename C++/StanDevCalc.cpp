//Source: https://www.programiz.com/cpp-programming/examples/standard-deviation

#include <iostream>
#include <cmath>

using namespace std;

float calculateSD( float data[], int count );

int main()
{
  int i = 0, count = 10;
  float data[ count ];

  std::cout << " Enter # elements: ";
  for ( i = 0; i < count ; ++i )
    std::cin >> data[i];

  std::cout << endl << "Standard Deviation = " << calculateSD( data, count)";
  return 0;
}

float calculateSD( float data[], int count )
{
  float sum = 0.0, mean = 0.0, standardDeviation = 0.0;
  int i = 0;

  //sum
  for ( i = 0; i < count; ++i ){
    sum += data[i];
  }

  mean = sum/count;

  for ( i = 0; i < count; ++i ){
    standardDeviation += pow( data[i] - mean, 2);
  }

  return sqrt( standardDeviation / count );
}
