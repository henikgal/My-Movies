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

        SharedPreferences auth = requireContext().getSharedPreferences("auth", Context.MODE_PRIVATE);


        binding.btnLogin.setOnClickListener(v -> {
            String username = binding.etLoginEmail.getText().toString();
            String password = binding.etLoginPassword.getText().toString();

            if (username.equals(auth.getString("username", "")) && password.equals(auth.getString("password", ""))) {
                Navigation.findNavController(requireView()).navigate(R.id.action_LoginFragment_to_homeFragment);
            } else {
                Toast.makeText(requireContext(), "Username or password invalid", Toast.LENGTH_SHORT).show();
            }

        });

    }
}