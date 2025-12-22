// neome.ai API - do not change
//

package com.neome.java.api.meta.base;

public abstract class AnyName implements Comparable<AnyName>
{
  public String name;

  @Override
  public int hashCode()
  {
    return name == null
      ? 0
      : name.hashCode();
  }

  @Override
  public final String toString()
  {
    return name;
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

    AnyName that = (AnyName) o;
    if(name == null)
    {
      return that.name == null;
    }
    else if(that.name == null)
    {
      return false;
    }
    else
    {
      return name.equals(that.name);
    }
  }

  @Override
  public final int compareTo(AnyName o)
  {
    return name.compareTo(o.name);
  }
}
