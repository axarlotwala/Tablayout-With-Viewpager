package imageupload.akshar.com.demo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

    EditText user_email,user_password;
    Button btn_submit;
    private String Login_Url = "http://192.168.0.103/shopping/login.php";

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_one, container, false);
        user_email = view.findViewById(R.id.user_email);
        user_password = view.findViewById(R.id.user_password);
        btn_submit = view.findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoggedInUser();
            }
        });

        return view;
    }

    private void LoggedInUser() {

        final String email = user_email.getText().toString().trim();
        final String password = user_password.getText().toString().trim();

        if (email.isEmpty()){
            user_email.setError("Please Enter User Email");
            user_email.requestFocus();
            return;
        }

        if (password.isEmpty()){
            user_password.setError("please Enter Password");
            user_password.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Login_Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    if (!jsonObject.getBoolean("error")){

                        Usermodel usermodel = new Usermodel(
                                jsonObject.getString("cust_email"),
                                jsonObject.getString("cust_password"));
                    } else {

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getActivity(),response, Toast.LENGTH_SHORT).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(),error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("cust_email",email);
                params.put("cust_password",password);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }

}
