//Source: O'reilly C++ cookbooks
#include <string>
#include <iostream>

using namespace std;

//The generic appraoch for trimming single
//character from a string
template<typename T>
void rtrim(basic_string<T>& s, T c)
{
	if (s.empty())
		return;

	typename basic_string<T>::iterator p;
	for ( p = s.end(); p != s.begin() && *--p == c);

	if ( *p != c)
		p++;

	s.erase(p, s.end());
}

template<typename T>
void leftTrim(basic_string<T>& s, T c)
{
	if (s.empty())
		return;

	typename basic_string<T>::iterator p;
	for ( p = s.begin(); p != s.end() && *++p == c);

	if ( *p != c)
		p--;

	s.erase(p, s.begin());
}
int main()
{
	string s = "Great!!!!";
	wstring ws = L"Super!!!!"

	rtrim(s, '!');
	rtrim(ws, L'!');

	std::cout << s << std::endl;
	wcout << ws << L'\n';
}
