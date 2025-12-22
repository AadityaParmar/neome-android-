// neome.ai API - do not change
//

package com.neome.java.api.meta.base;

public abstract class AnyValue implements Comparable<AnyValue>
{
  public String value;

  @Override
  public int hashCode()
  {
    return value == null
      ? 0
      : value.hashCode();
  }

  @Override
  public final String toString()
  {
    return value;
  }

  @Override
  public boolean equals(Object o)
  {
    if(this == o)
    {
      return true;
    }

    if(o == null || getClass() != o.getClass())
    {
      return false;
    }

    AnyValue that = (AnyValue) o;
    if(value == null)
    {
      return that.value == null;
    }
    else if(that.value == null)
    {
      return false;
    }
    else
    {
      return value.equals(that.value);
    }
  }

  @Override
  public final int compareTo(AnyValue o)
  {
    return value.compareTo(o.value);
  }
}
