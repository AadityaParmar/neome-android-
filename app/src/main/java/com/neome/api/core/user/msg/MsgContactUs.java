// neome.ai API - do not change
//

package com.neome.api.core.user.msg;

import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class MsgContactUs extends Msg
{
  @Nullable
  public Map<String, String> attrMap;

  @Nullable
  public String companyName;

  @Nullable
  public String content;

  @Nullable
  public String email;

  @Nullable
  public String fullName;

  @Nullable
  public String mobileNumber;

  @Nullable
  public String pageName;
}
