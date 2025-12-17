// neome.ai API - do not change
//

package com.neome.api.core.otp.msg;

import com.neome.api.meta.base.AnyKey;
import com.neome.api.nucleus.base.Types.AnyOtpValue;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgOtpVerify extends Msg
{
  public AnyOtpValue otp;

  public AnyKey verifyKey;
}