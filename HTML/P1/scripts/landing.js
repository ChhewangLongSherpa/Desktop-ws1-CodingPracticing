function print_year()
{
  document.write(year);
}

var lhs = "sob";
var rhs = "gmail.com";

function print_mail_to_link()
{
  document.write("<a class=\"quote\" href=\"mailto");
  document.write(":"+lhs+"@")
  document.write(rhs + "\">"+lhs+"@"+rhs+"<\/a>");
}
