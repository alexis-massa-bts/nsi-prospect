package com.barseghyan_massa.nsi_prospect.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.barseghyan_massa.nsi_prospect.MyApplication;
import com.barseghyan_massa.nsi_prospect.R;
import com.barseghyan_massa.nsi_prospect.db.helper.UserHelper;
import com.barseghyan_massa.nsi_prospect.db.model.User;
import com.barseghyan_massa.nsi_prospect.mail.JavaMailAPI;

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
        //Creer le mail
        Toast.makeText(MyApplication.getAppContext(), "Envoi", Toast.LENGTH_SHORT).show();

        String subject = "Nouveau mot de passe !";
        String message = "Voici votre nouveau mot de passe : 1234";

        JavaMailAPI javaMailAPI = new JavaMailAPI(MyApplication.getAppContext(), et_mail, subject, message);
        javaMailAPI.execute();

        //Changement dans la BDD
        User oldUser = UserHelper.findOne(et_mail);
        User newUser = UserHelper.findOne(et_mail);
        newUser.setMail(et_mail);

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
                generatePassword(et_mail.getText().toString().trim());
                Toast.makeText(MyApplication.getAppContext(), "Success", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Log.d(this.getTag(), e.toString());
            }
        });
    }
}