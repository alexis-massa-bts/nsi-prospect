package com.barseghyan_massa.nsi_prospect.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.barseghyan_massa.nsi_prospect.MyApplication;
import com.barseghyan_massa.nsi_prospect.R;
import com.barseghyan_massa.nsi_prospect.db.helper.UserHelper;
import com.barseghyan_massa.nsi_prospect.db.model.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecoverLoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecoverLoginFragment extends Fragment {

    //Refrences
    TextView tw_login;
    Button btn_get;
    EditText et_mail;

    public RecoverLoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RecoverLoginFragment.
     */
    public static RecoverLoginFragment newInstance() {
        RecoverLoginFragment fragment = new RecoverLoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_lost, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_mail = getActivity().findViewById(R.id.lost_acc_mail);
        btn_get = getActivity().findViewById(R.id.btn_get_login);
        tw_login = getActivity().findViewById(R.id.lost_acc_login);

        btn_get.setOnClickListener(v -> {
            try {
                Toast.makeText(MyApplication.getAppContext(), "Success", Toast.LENGTH_SHORT).show();
                                tw_login.setText(recoverLogin(et_mail.getText().toString().trim()));

            } catch (Exception e) {
                Log.d(this.getTag(), e.toString());
            }
        });
    }

    //TODO RECOVER LOGIN FRAGMENT
    public String recoverLogin(String et_mail) {
        User u = UserHelper.findOne(et_mail);
        Toast.makeText(MyApplication.getAppContext(), u.getLogin(), Toast.LENGTH_SHORT).show();
        return u.getLogin();
    }

}