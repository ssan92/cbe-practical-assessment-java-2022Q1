package com.pichincha.store.util;

import com.ibm.icu.text.RuleBasedNumberFormat;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Pattern;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Util {

  public static final Locale LOCALE = Locale.forLanguageTag("es-EC");
  public static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#,###.00");
  private static final NumberFormat numberFormat = NumberFormat.getNumberInstance(
      Locale.forLanguageTag("en-US"));
  private static final RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(LOCALE,
      RuleBasedNumberFormat.SPELLOUT);
  private static MessageDigest sha;
  private static final Charset charset = StandardCharsets.UTF_8;
  private static final Pattern accountPattern = Pattern.compile("^(.{2,2})(.*)(.{4,4})$");
  private static final String patternFormat = "^(.{%d,%d})(.*)(.{%d,%d})$";

  static {
    numberFormat.setMinimumFractionDigits(2);
    NUMBER_FORMAT.setMinimumIntegerDigits(1);
  }

  static {
    try {
      sha = MessageDigest.getInstance("SHA-512");
    } catch (NoSuchAlgorithmException e) {
      log.fatal(e.getMessage(), e);
    }
  }

  private Util() {
  }

  public static String sha512(String target) {
    return toHexString(sha.digest(charset.encode(target).array()));
  }

  public static String mask(String target) {
    return mask(target, accountPattern);
  }

  public static String mask(String target, int start, int end) {
    return mask(target, Pattern.compile(String.format(patternFormat, start, start, end, end)));
  }

  private static String mask(String target, Pattern pattern) {
    return pattern.matcher(target).replaceAll(
        m -> m.group(1) + Pattern.compile(".").matcher(m.group(2)).replaceAll("*") + m.group(3));
  }

  public static String toHexString(byte[] bytes) {
    BigInteger bigInteger = new BigInteger(1, bytes);
    return bigInteger.toString(16);
  }

  public static String spellNumber(Double number) {
    StringBuilder numberString = new StringBuilder(formatter.format(number).toLowerCase());
    int index = numberString.indexOf(" coma ");
    if (index >= 0) {
      numberString.delete(index, numberString.length());
    }
    numberString.append(String.format(" con %s/100",
        numberFormat.format(number).substring(numberFormat.format(number).lastIndexOf(".") + 1)));
    return numberString.toString().toUpperCase();
  }

  public static SimpleDateFormat getDateLongFormat() {
    return new SimpleDateFormat("dd 'días del mes de' MMMM 'del año' yyyy", Util.LOCALE);
  }

}
