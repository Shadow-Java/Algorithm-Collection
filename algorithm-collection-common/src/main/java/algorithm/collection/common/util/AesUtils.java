package algorithm.collection.common.util;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具
 *
 * <p>
 *     <ul>
 *         <li>密码加密</li>
 *         <li>隐私加密</li>
 *     </ul>
 * </p>
 *
 * @author shadow
 * @date 2022/7/23 10:40
 * @since 1.0
 */
@Slf4j
public class AesUtils {

    private static final String CIPHER_OFB_ALGORITHM = "AES/OFB/NoPadding";

    private static String secretKey = "aaabbb";

    private static String ALGORITHM = "aes";

    private static final String IV_PARAMETER = "HIHAIHIH@JIJAD";

    private static final IvParameterSpec IV_PARAMETER_SPEC = new IvParameterSpec(IV_PARAMETER.getBytes());


    public static String encrypt(String data){
        return encrypt(secretKey,data,CIPHER_OFB_ALGORITHM);
    }

    public static String decrypt(String data){
        return encrypt(secretKey,data,CIPHER_OFB_ALGORITHM);
    }

    public static String encrypt(String key,String data,String cipherAlgorithm){
        try{
            Cipher cipher = initCipher(key,Cipher.ENCRYPT_MODE,cipherAlgorithm);
            //加密
            return HexUtil.encodeHexStr(cipher.doFinal(data.getBytes()));
        }catch (Exception e){
            log.error("aes encrypt error,data: {}",data,e);
            return CharSequenceUtil.EMPTY;
        }
    }

    public static String decrypt(String key,String data,String cipherAlgorithm){
        try{
            Cipher cipher = initCipher(key,Cipher.DECRYPT_MODE,cipherAlgorithm);
            //加密
            return StrUtil.str(cipher.doFinal(HexUtil.decodeHex(data)), Charset.defaultCharset());
        }catch (Exception e){
            log.error("aes encrypt error,data: {}",data,e);
            return CharSequenceUtil.EMPTY;
        }
    }

    @SneakyThrows
    private static Cipher initCipher(String key,int cipherMode,String cipherAlgorithm) {
        //初始化
        if(CIPHER_OFB_ALGORITHM.equals(cipherAlgorithm)){
            SecretKeySpec secretKeySpec = new SecretKeySpec(pretreatment(key,32).getBytes(),ALGORITHM);
            //创建密码器
            Cipher cipher = Cipher.getInstance(cipherAlgorithm);
            cipher.init(cipherMode,secretKeySpec,IV_PARAMETER_SPEC);
            return cipher;
        }else{
            SecretKeySpec secretKeySpec = new SecretKeySpec(pretreatment(key,16).getBytes(),ALGORITHM);
            Cipher cipher = Cipher.getInstance(cipherAlgorithm);
            cipher.init(cipherMode,secretKeySpec);
            return cipher;
        }
    }

    private static String pretreatment(String key,int aesKeyLength){
        StringBuilder sb = new StringBuilder(key);
        while(sb.length() < aesKeyLength){
            sb.append(key);
        }
        if(sb.length() >= aesKeyLength){
            key = sb.substring(0,aesKeyLength);
        }
        return key;
    }

}
