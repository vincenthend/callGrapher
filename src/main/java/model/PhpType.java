package model;

public class PhpType implements Comparable<PhpType>{
  String typeName;
  boolean isArray;

  @Override
  public int compareTo(PhpType o) {
    if(typeName == o.typeName && isArray == o.isArray) {
      return 0;
    }
    return 1;
  }
}
