package com.barseghyan_massa.nsi_prospect.fragments;

import android.content.Intent;
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
import android.widget.Toast;

import com.barseghyan_massa.nsi_prospect.MyApplication;
import com.barseghyan_massa.nsi_prospect.R;
import com.barseghyan_massa.nsi_prospect.mail.GMailSender;

/**
 * A simple {@link Fragment} subclass.
 */
public class PasswordLostFragment extends Fragment {

    EditText et_mail;
    Button btn_generate;

    public PasswordLostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void generatePassword(String et_mail) throws Exception {
        Toast.makeText(MyApplication.getAppContext(), et_mail, Toast.LENGTH_SHORT).show();

        GMailSender sender = new GMailSender("alexis2massa@gmail.com", "P@ssw0rdSIO");
        sender.sendMail("Nouveau mot de passe !",
                "Voici votre nouveau mot de passe : 1234",
                "alexis2massa@gmail.com",
                et_mail);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_lost, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_mail = getActivity().findViewById(R.id.acc_sett_mail);
        btn_generate = getActivity().findViewById(R.id.btn_generate);

        btn_generate.setOnClickListener(v -> {
            try {
                generatePassword(String.valueOf(et_mail.getText()));
                Toast.makeText(MyApplication.getAppContext(), "Success", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Log.d(this.getTag(), e.toString());
            }
        });
    }
}