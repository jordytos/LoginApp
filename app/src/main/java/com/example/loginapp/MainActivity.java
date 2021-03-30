package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button loginBtn;
    private TextView password;
    private TextView username;
    private String user;
    private String pass;
    private List<User> userList;

    class User {
        private String user;
        private String password;

        public User(String u,String p){
            this.user = u;
            this.password = p;
        }

        public String getUser() {
            return user;
        }

        public String getPassword() {
            return password;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(loginBtnListener);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        User user1 = new User("Test","1234");
        User user2 = new User("Jordy","jordy37");
        User user3 = new User("Univ","Tours");
        User user4 = new User("test","test");
        userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

    }


    private View.OnClickListener loginBtnListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            user = username.getText().toString();
            pass = password.getText().toString();

            Intent intent = new Intent(v.getContext(), MainActivity2.class);
            intent.putExtra("cle",user);

            for (User u:userList) {

                if(u.getUser().equals(user) && u.getPassword().equals(pass)){
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Error Login or Password", Toast.LENGTH_LONG).show();
                }
            }


        }
    };
}