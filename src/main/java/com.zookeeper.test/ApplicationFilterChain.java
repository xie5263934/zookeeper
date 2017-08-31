package com.zookeeper.test;

/**
 * @author JINRUN.XIE
 * @since 2017/8/31
 */
public class ApplicationFilterChain implements FilterChain{
    private final Filter [] filters = new Filter[3];
    private int pos = 0;
    private int n = 0;
    public static void main(String [] args){
        ApplicationFilterChain chain = new ApplicationFilterChain();
        Filter A = new FilterA();
        chain.filters[0] = A;
        Filter B = new FilterB();
        chain.filters[1] = B;
        Filter C = new FilterC();
        chain.filters[2] = C;
        chain.n = chain.filters.length;
        chain.doFilter();
    }

    @Override
    public void doFilter() {
        if(pos < n){
            Filter filter = filters[pos++];
            if(filter != null){
                filter.doFilter(this);
            }
        }
    }
}
