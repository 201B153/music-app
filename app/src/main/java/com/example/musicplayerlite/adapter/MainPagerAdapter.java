package com.example.musicplayerlite.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.musicplayerlite.fragments.AlbumsFragment;
import com.example.musicplayerlite.fragments.ArtistsFragment;
import com.example.musicplayerlite.fragments.PlaylistFragment;
import com.example.musicplayerlite.fragments.SettingsFragment;
import com.example.musicplayerlite.fragments.SongsFragment;
import com.example.musicplayerlite.listener.MusicSelectListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final MusicSelectListener selectListener;
    List<Fragment> fragments = new ArrayList<>();

    public MainPagerAdapter(FragmentManager fm, MusicSelectListener selectListener) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.selectListener = selectListener;

        setFragments();
    }

    public void setFragments() {
        fragments.add(SongsFragment.newInstance(selectListener));
        fragments.add(ArtistsFragment.newInstance());
        fragments.add(AlbumsFragment.newInstance());
        fragments.add(PlaylistFragment.newInstance());
        fragments.add(SettingsFragment.newInstance());
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}