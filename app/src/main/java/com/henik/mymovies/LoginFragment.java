package com.henik.mymovies;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.henik.mymovies.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding = null;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.etLoginEmail.setText("gal@gmail.com");
        binding.etLoginPassword.setText("123456");

        binding.tvLoginSignup.setOnClickListener(view1 -> {
            Navigation.findNavController(requireView()).navigate(R.id.action_LoginFragment_to_signupFragment);
        });

        String username = binding.etLoginEmail.getText().toString();
        String password = binding.etLoginPassword.getText().toString();
        binding.btnLogin.setOnClickListener(v -> {
            login(username, password);
        });
    }

    private void login(String username, String password) {
        SharedPreferences auth = requireContext().getSharedPreferences("auth", Context.MODE_PRIVATE);
        String passwordFromDB = auth.getString(username, "");

        if (passwordFromDB.isEmpty()) {
            Toast.makeText(requireContext(), "Username Not Found", Toast.LENGTH_SHORT).show();
        } else {
            if (password.equals(passwordFromDB)) {
                Navigation.findNavController(requireView()).navigate(R.id.action_LoginFragment_to_homeFragment);
            } else {
                Toast.makeText(requireContext(), "password invalid", Toast.LENGTH_SHORT).show();
            }
        }
    }
}