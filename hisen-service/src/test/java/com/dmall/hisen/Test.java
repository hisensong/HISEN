package com.dmall.hisen;

/**
 * Created by HisenSong
 * on 2016/8/30.
 */
public class Test {

    public static void main(String[] args) {
        String a = new String("ab"); // a 为一个引用---指向的是堆内存的String
        String b = new String("ab"); // b为另一个引用,对象的内容一样---指向的是堆内存的String
        String aa = "ab"; // 放在常量池中---指向的是常量池的String
        String bb = "ab"; // 从常量池中查找---指向的是常量池的String

        String str1 = "a";
        String str2 = "b";
        String str = str1 + str2;//用+连接字符串时，实际上是在堆内容创建对象，那么combo指向的是堆内存存

        /**
         *  hashCode()方法是返回字符串内容的哈希码，既然内容相同，哈希码必然相同
         */
        System.out.println("a.hashCode()=="+a.hashCode());
        System.out.println("b.hashCode()==="+b.hashCode());
        System.out.println("aa.hashCode()==="+aa.hashCode());
        System.out.println("bb.hashCode()==="+bb.hashCode());


        System.out.println("aa==bb:"+(aa == bb));//true
        System.out.println("a==b:"+(a==b));// false
        System.out.println("a==aa:"+(a==aa));// false
        /**
         * intern()方法：返回字符串对象的规范化表示形式。怎么理解这句话？实际上过程是这样进行的：
         *该方法现在String池中查找是否存在一个对象，存在了就返回String池中对象的引用。
         */
        System.out.println("a==aa.intern():"+(a.intern()==aa));// true--
        System.out.println("a.equals(b):"+a.equals(b));// true
        System.out.println("aa=str:"+(aa==str));// false

    }

}
