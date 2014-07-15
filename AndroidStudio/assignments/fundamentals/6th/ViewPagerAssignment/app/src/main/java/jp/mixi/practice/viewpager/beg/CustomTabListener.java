package jp.mixi.practice.viewpager.beg;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

/**
 * Created by takoika0601 on 2014/07/10.
 */
public class CustomTabListener implements ActionBar.TabListener {

    private ViewPager viewPager;
    
    public CustomTabListener(ViewPager pager) {
        viewPager = pager;
    }
    
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }
}
