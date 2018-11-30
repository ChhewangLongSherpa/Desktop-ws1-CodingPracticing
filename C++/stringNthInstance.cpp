//Source: O'reilly C++ cookbooks
#include <string>
#include <iostream>

using namespace std;

int nthSubstr( int n, const string& s, const string& p ){
  string::size_type i = s.find(p);

  int j;
  for ( j = 1; j < n && i != string::npos; ++j){
    i = s.find( p, i+1 );
  }
  if( j == n )
    return(i);
  else
    return(-1);
}

template<typename T>
int nthSubstr( int n, const basic_string<T>& s, const basic_string<T>& p,
  bool repeats = false){
   string::size_type i = s.find(p);
   string::size_type adv = (repeats) ? 1 : p.length();

   int j;
   for ( j =1; j < n && i != basic_string<T>::npos; ++j){
     i = s.find( p, i+adv );
   }

  if( j == n )
    return(i);
  else
    return(-1);
}

int main(){
  string s = " the wind, the sea, the sky, the trees";
  string p = "the";

  std::cout << nthSubstr( 1,s,p ) << '\n';
  std::cout << nthSubstr( 2,s,p ) << '\n';
  std::cout << nthSubstr( 5,s,p ) << '\n';
}
