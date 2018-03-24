package com.music.gaurav.gmusic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.music.gaurav.gmusic.albums.AlbumFragment;
import com.music.gaurav.gmusic.artists.ArtistFragment;
import com.music.gaurav.gmusic.songs.SongsFragment;

/**
 * Created by gaurav on 11/4/2017.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment currFragment = null;
        switch (position){
            case 0:
                currFragment = new SongsFragment();
                break;
            case 1:
                currFragment = new AlbumFragment();
                break;
            case 2:
                currFragment = new ArtistFragment();
                break;

        }
        return currFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
