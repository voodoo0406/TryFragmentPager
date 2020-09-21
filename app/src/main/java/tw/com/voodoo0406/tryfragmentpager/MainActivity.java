package tw.com.voodoo0406.tryfragmentpager;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import java.util.Arrays;
import tw.com.voodoo0406.tryfragmentpager.databinding.ActivityMainBinding;

public class MainActivity extends FragmentActivity {

  public static final String[] TITLES = {"ABC", "DEF", "GHI", "JKL", "MNO"};
  ActivityMainBinding mBinding;
  PagerAdapter mPagerAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    mPagerAdapter = new PagerAdapter(this);
    mBinding.myViewPager.setAdapter(mPagerAdapter);
    mPagerAdapter.setPages(Arrays.asList(TITLES));
    mPagerAdapter.notifyDataSetChanged();
  }
}
