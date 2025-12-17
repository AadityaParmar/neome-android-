// neome.ai API - do not change
//

package com.neome.api.meta.base;

public class AnyKey implements Comparable<AnyKey>
{
  public String key;

  @Override
  public final int compareTo(AnyKey o)
  {
    return key.compareTo(o.key);
  }

  public final String getString()
  {
    return key;
  }

  @Override
  public final int hashCode()
  {
    return key.hashCode();
  }

  @Override
  public final boolean equals(Object o)
  {
    if(this == o)
    {
      return true;
    }
    if(o == null || getClass() != o.getClass())
    {
      return false;
    }
    AnyKey anyKey = (AnyKey) o;
    return key.equals(anyKey.key);
  }

  @Override
  public final String toString()
  {
    return key;
  }
}