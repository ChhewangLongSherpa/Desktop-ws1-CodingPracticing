//Padding string

#include <string>
#include <iostream>
#include <iomanip>

using namespace std;

template<typename T>
void pad(basic_string<T>& s, 
				typename basic_string<T>:: size_type n, T c){
	if ( n > s.length() )
		s.append(n - s.length(), c);
}

void padLeft( int x, std::string &s){
	std::stringstream << std::setw(x) << s << std::endl;
}

void padLeft( std::string &str, const size_t num, const char paddingChar = ' '){
	if ( num > str.size() )
		str.insert(0,num - str.size(), paddingChar );
}

int main( int argc, char **argv)
{
	std::string str = "abcd"
	padLeft(str, 10);
	std::cout << str << std::endl;
	
	wstring ws = L"Acknowledgements";
	pad(ws,20,L'*');
	wcout << ws << std::endl
	return 0;
}