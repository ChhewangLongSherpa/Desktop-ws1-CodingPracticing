#include <string>
#include <vector>
#include <functional>
#include <iostream>

using namespace std;

template<typename T>
void split(const basic_string<T>& s, T c, vector<basic_string<T> >& v){
  basic_string<T>::size_type i = 0;
  basic_string<T>::size_type j = s.find(c);

  while ( j != basic_string<T>::npos){
    v.push_back(s.substr(i, j-i));
    i = ++j;
    j = s.find(c,j);

    if ( j == basic_string<T>::npos)
      v.push_back(s.substr(i, s.length()));
  }
}
