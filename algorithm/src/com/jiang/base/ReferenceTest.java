package com.jiang.base;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceTest {

    private static Object object = new Object();
    public static void main(String[] args) {
        ReferenceQueue queue = new ReferenceQueue();

        WeakReference<Object> reference = new WeakReference(object,queue);

        System.gc();

//        try {
//            Reference reference1 = queue.remove();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        queue.toString();
    }
}
