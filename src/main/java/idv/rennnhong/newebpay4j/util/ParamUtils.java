package idv.rennnhong.newebpay4j.util;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParamUtils {

    public static String toKVPair(Map<String, Object> map){
        List<String> collect = map.entrySet().stream()
                .map(x -> x.getKey() + "=" + x.getValue())
                .collect(Collectors.toList());
        return StringUtils.join(collect.toArray(),"&");
    }

}
