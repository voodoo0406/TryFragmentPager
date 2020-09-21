package tw.com.voodoo0406.tryfragmentpager;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

  private List<String> mPages = new ArrayList<>();
  private FragmentActivity mFragmentActivity;

  PagerAdapter(FragmentActivity fragmentActivity) {
    super(fragmentActivity.getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    mFragmentActivity = fragmentActivity;
  }

  void setPages(List<String> pages) {
    mPages.clear();
    mPages.addAll(pages);
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    return mFragmentActivity.getSupportFragmentManager().getFragmentFactory()
        .instantiate(ClassLoader.getSystemClassLoader(), PagerFragment.class.getName());
  }

  @Override
  public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    super.setPrimaryItem(container, position, object);
  }

  @NonNull
  @Override
  public Object instantiateItem(@NonNull ViewGroup container, int position) {
    Fragment fragment = (Fragment)super.instantiateItem(container, position);
    String title = mPages.get(position);
    Bundle args = new Bundle();
    args.putString(PagerFragment.KEY_PAGER_DATA, title);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public int getCount() {
    return mPages.size();
  }
}
