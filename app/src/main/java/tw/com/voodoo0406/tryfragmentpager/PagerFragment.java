package tw.com.voodoo0406.tryfragmentpager;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import tw.com.voodoo0406.tryfragmentpager.databinding.PagerFragmentBinding;

public class PagerFragment extends Fragment {
  public static final String KEY_PAGER_DATA = "key_pager_data";
  private PagerFragmentBinding binding;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater, R.layout.pager_fragment, container, false);
    return binding.getRoot();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    Bundle args = getArguments();
    if (args != null) {
      binding.fragmentTitle.setText(args.getString(KEY_PAGER_DATA));
    }
  }

}
