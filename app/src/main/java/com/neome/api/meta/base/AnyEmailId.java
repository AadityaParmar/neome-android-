// neome.ai API - do not change
//

package com.neome.api.meta.base;

public class AnyEmailId implements Comparable<AnyEmailId>
{
  public String emailId;

  @Override
  public int hashCode()
  {
    return emailId == null
      ? 0
      : emailId.hashCode();
  }

  @Override
  public final String toString()
  {
    return emailId;
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

    AnyEmailId that = (AnyEmailId) o;
    if(emailId == null)
    {
      return that.emailId == null;
    }
    else if(that.emailId == null)
    {
      return false;
    }
    else
    {
      return emailId.equals(that.emailId);
    }
  }

  @Override
  public final int compareTo(AnyEmailId o)
  {
    return emailId.compareTo(o.emailId);
  }
}