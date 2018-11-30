#include <string>
#include <iostream>

using namespace std;

class StringTokenizer {
public:
  StringTokenizer(const string& s, const char* delim = NULL) :
    str_(s), count_(-1), begin_(0), end_(0) {

      if (!delim)
      {
        delim_ = " \f\b\r\t\v";
      }
      else
      {
        delim_ = delim;
      }
    }

    size_t countTokens(){
      if( count_ >= 0)
        return(count_);

      string::size_type n = 0;
      string::size_type i = 0;

      for(;;){
        if((i = str_.find_first_not_of(delim_, i)) == string::npos)
          break;
        i = str_find_first_of(delim, i+1);
        n++;
        if( i == string::npos)
          break;
        }
        return (count_ = n);
    }
    bool hasMoreTokens() { return(begin_ != end_);}
    void nextToken(string& s){
      if(begin_ != string::npose && end_ != string::npos){
        s = str_.substr(begin_, end_-begin_);
        begin_ = str_.find_first_not_of(delim_, end_);
        end_ = str_.find_first_of(delim_, begin_);
      }
      else if ( begin_ != string::npos && end_ == string::npos )
      {
        s = str_.substr(begin_, str_.length()-begin_);
        begin_ = str_.find_first_not_of(delim_, end_);
      }

    }
  private:
    StringTokenizer() {};
    string delim_;
    string str_;
    int count_;
    int begin_;
    int end_;
};

//Test
int main(){
  string t = " razzle dazzle giddy";
  string tmp;

  StringTokenizer st(s);

  std::cout << "There are " << st.countTokens() << " tokens.\n";
  while (st.hasMoreTokens()){
    st.nextToken(tmp);
    std::cout << "token = " << tmp << '\n';
  }
}
