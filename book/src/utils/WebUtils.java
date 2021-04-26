package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-26 21:18
 **/
public class WebUtils {
    /**
     * 将参数注入到bean对象
     * @param map
     * @param t
     */
    public static  <T> T copyParamToBean(Map map , T t) {
        try {
//            这个方法会遍历map<key, value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bean的属性。
            BeanUtils.populate(t,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
