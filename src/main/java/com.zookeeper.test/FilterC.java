package com.zookeeper.test;

/**
 * @author JINRUN.XIE
 * @since 2017/8/31
 */
public class FilterC implements Filter{
    @Override
    public void doFilter(FilterChain filterChain) {
        System.out.println("I am filterC");
        filterChain.doFilter();
    }
}
