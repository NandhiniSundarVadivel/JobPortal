package com.jobportal.jobseeker.seeker.JobPortalFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jobportal.jobseeker.seeker.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentFour extends Fragment {


    View view;

    Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_four, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

/*
    @OnClick({R.id.imageMale, R.id.imageFemle,R.id.imagForward})
    public void onViewClicked(View view) {

        Log.e("flag", String.valueOf(flag));
        switch (view.getId()) {
            case R.id.imageMale:
                PrefConnect.writeString(getContext(), PrefConnect.USERGENDER,"male");
                rspo = "male";

                SharedPreferences.Editor editor = getContext().getSharedPreferences("PREF", MODE_PRIVATE).edit();
                editor.putString("first", "yes");
                editor.apply();

                flag = true;
                imageMale.setImageResource(R.drawable.signup_btn_active);
                imageFemle.setImageResource(R.drawable.unselecte_image);
                break;
            case R.id.imageFemle:
                PrefConnect.writeString(getContext(),PrefConnect.USERGENDER,"female");
                rspo = "female";

                SharedPreferences.Editor editors = getContext().getSharedPreferences("PREF", MODE_PRIVATE).edit();
                editors.putString("second", "yes");
                editors.apply();

                flag = true;
                imageFemle.setImageResource(R.drawable.signup_btn_active);
                imageMale.setImageResource(R.drawable.unselecte_image);
                break;
            case R.id.imagForward:
                Fragment fragment = new FragmentLVL();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }
*/

}
