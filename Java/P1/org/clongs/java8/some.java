package org.clongs.java8;

public class DOB {
  int mm;
  int dd;
  int yyyy;

  public DOB ( int mm, int dd, int yyyy ){
    setDOB(mm,dd,yyyy);
  }

  public void setDOB( int mm, int dd, int yyyy )
  {
    this.mm = mm;
    this.dd = dd;
    this.yyyy = yyyy;
  }

  public void getDOB( int mm, int dd, int yyyy )
  {
    mm = this.mm;
    dd = this.dd;
    yyyy = this.yyyy;
  }

  public DOB getDOB(){
    DOB temp = new DOB(this.mm,this.dd,this.yyyy);
    return temp;
  }
}

public class Person {
  int Id;
  String fName;
  String lName;
  DOB dob;
}
