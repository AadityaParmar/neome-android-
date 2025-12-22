// neome.ai API - do not change
//

package com.neome.java.api.meta.base;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

import java.security.SecureRandom;
import java.util.Random;

public class NanoId
{
  private static final char[] ALPHA_NUMERIC_CHARS =
    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
  private static final Random random = new SecureRandom();

  public static String newGuid()
  {
    return NanoIdUtils.randomNanoId(random, ALPHA_NUMERIC_CHARS, 25);
  }

  public static String newMetaId()
  {
    return NanoIdUtils.randomNanoId(random, ALPHA_NUMERIC_CHARS, 10);
  }

  public static String newGuidBig()
  {
    return NanoIdUtils.randomNanoId(random, ALPHA_NUMERIC_CHARS, 32);
  }
}
