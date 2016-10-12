package com.zzr.demo.utils;

import android.util.Log;

import com.zzr.demo.base.BaseFragment;
import com.zzr.demo.modular.four.FourFragment;
import com.zzr.demo.modular.one.OneFragment;
import com.zzr.demo.modular.three.ThreeFragment;
import com.zzr.demo.modular.two.TwoFragment;

import static android.R.attr.tag;

public class FragmentFactory {

	public static BaseFragment getFragmentByTag(String tag) {
		if (tag.equals(OneFragment.class.getName())) {
            return new OneFragment();
		}
        else if (tag.equals(TwoFragment.class.getName())) {
            return new TwoFragment();
        }
        else if (tag.equals(ThreeFragment.class.getName())) {
            return new ThreeFragment();
        }
        else if (tag.equals(FourFragment.class.getName())) {
            return new FourFragment();
        }
		else {
			return null;
		}
	}
}
