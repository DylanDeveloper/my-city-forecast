package app.dgandroid.eu.mycityforecast.customs;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Duilio on 06/09/2017.
 */

public class LoopViewPager extends ViewPager {

    private static final int ALL_PAGE_COUNT = 100000;
    private int mPages;
    private int mFirstPosition;
    private int mAdapterPages;

    public LoopViewPager(Context context, int pages) {
        super(context);

        mPages = pages;

        if (pages == 0) {
            return;
        }
        if (pages == 1) {
            mAdapterPages = 1;
        } else {
            mAdapterPages = ALL_PAGE_COUNT;
        }
        setAdapter(new LoopPagerAdapter());
        int maxSets = ALL_PAGE_COUNT / mPages;
        mFirstPosition = (maxSets / 2) * mPages;
        setCurrentItem(-1, false);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        int pos = item < 0 ? mFirstPosition : mFirstPosition + item;
        super.setCurrentItem(pos, smoothScroll);
    }

    public void setCurrentItemAfterCancelListener(int item, boolean smoothScroll) {
        int pos = item < 0 ? mFirstPosition : mFirstPosition + item;
        super.setCurrentItem(pos, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        int pos = item < 0 ? mFirstPosition : mFirstPosition + item;
        super.setCurrentItem(pos);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    private class LoopPagerAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return null;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return (mAdapterPages);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }
    }
}