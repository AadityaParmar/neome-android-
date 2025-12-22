// neome.ai API - do not change
//

package com.neome.java.api.meta.base;

public class Symbol implements Comparable<Symbol>
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

    Symbol that = (Symbol) o;
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
  public final int compareTo(Symbol o)
  {
    return name.compareTo(o.name);
  }
}
