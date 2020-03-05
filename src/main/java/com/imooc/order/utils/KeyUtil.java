package com.imooc.order.utils;

import java.util.Random;

//生成id
public class KeyUtil {
    //生产唯一的主键
    //格式:时间戳+随机数
    public static synchronized String genUniqueKey(){
        Random random=new Random();
        Integer number=random.nextInt(900000)+100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }
}
