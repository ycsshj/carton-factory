package com.carton.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-07-11 16:00
 ************************************************************/

@SuppressWarnings("Duplicates")
public class EncryptUtil {
    private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    public static final String KEY_MD5 = "MD5";

    public static final String KEY_SHA = "SHA";

    public static String encryptMD5(String inputStr) {
        logger.info("MD5加密前:" + inputStr);

        BigInteger bigInteger = null;

        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return null;
        }

        logger.info("MD5加密后:" + bigInteger.toString(16));
        return bigInteger.toString(16);
    }

    /**
     * SHA加密
     *
     * @param inputStr
     * @return
     * @throws Exception
     */
    public static String encryptSHA(String inputStr) {
        logger.info("SHA加密前: " + inputStr);
        BigInteger bigInteger = null;
        try {
            MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
            byte[] inputData = inputStr.getBytes();
            sha.update(inputData);
            bigInteger = new BigInteger(sha.digest());
        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return null;
        }

        logger.info("SHA加密后: " + bigInteger.toString(32));
        return bigInteger.toString(32);

    }

    /**
     * BASE64加密
     *
     * @param inputStr
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(String inputStr) {
        logger.info("BASE64加密前: " + inputStr);
        String result = null;
        try {
            result = new String(new BASE64Encoder().encode(inputStr.getBytes()));
        } catch (Exception e) {
            logger.error("exception: {}" + LogExceptionStackTrace.errorStackTrace(e));
            return null;
        }

        logger.info("BASE64加密后: " + result);

        return result;
    }

    public static void main(String args[]) {
        try {
            String inputStr = "123456";
            encryptBASE64(inputStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
