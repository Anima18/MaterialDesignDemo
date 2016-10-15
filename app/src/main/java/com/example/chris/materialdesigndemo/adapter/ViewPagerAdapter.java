package com.example.chris.materialdesigndemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragmentList;
	
	public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.fragmentList = fragmentList;
	}
	
	@Override
	public Fragment getItem(int index) {
		// TODO Auto-generated method stub
		return fragmentList.get(index);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragmentList.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "热门推荐" + position;
	}
}
