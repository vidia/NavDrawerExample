package com.davidtschida.navdrawerexample;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;

/**
 * Created by david on 11/9/14.
 */
public class NavigationDrawer implements NavigationDrawerFragment.NavigationDrawerCallbacks {


    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private Activity mActivity;

    public void init(Activity activity) {
        this.mActivity = activity;


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                activity.getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = mActivity.getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) mActivity.findViewById(R.id.drawer_layout));
    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = mActivity.getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {


        switch (number) {
            case 1:

                mTitle = mActivity.getString(R.string.title_section1);
                break;
            case 2:
                mTitle =mActivity.getString(R.string.title_section2);
                break;
            case 3:
                mTitle = mActivity.getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = mActivity.getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    public boolean isDrawerOpen() {
        return mNavigationDrawerFragment.isDrawerOpen();
    }
}
