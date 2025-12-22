// neome.ai API - do not change
//

package com.neome.java.api.core.otp.msg;

import com.neome.java.api.meta.base.AnyKey;
import com.neome.java.api.nucleus.base.Types.AnyOtpValue;
import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgOtpVerify extends Msg
{
  public AnyOtpValue otp;

  public AnyKey verifyKey;
}
