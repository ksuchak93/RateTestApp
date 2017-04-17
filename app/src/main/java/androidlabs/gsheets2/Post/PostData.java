package androidlabs.gsheets2.Post;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import androidlabs.gsheets2.R;
import androidlabs.gsheets2.model.MyDataModel;

public class PostData extends AppCompatActivity {
    private ProgressDialog progress;

    //Text view sftre

    TextView tvName;

    TextView tvPhoneNumber;

    TextView tvEmailId;

    TextView tvMeal;

    TextView tvCommentsSuggestions;

    RatingBar rbPrice;

    RatingBar rbTaste;

    RatingBar rbLooks;

    RatingBar rbSides;

    RatingBar rbOverall;

    Button bSubmit;

    MyDataModel myDataModel = new MyDataModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        bSubmit=(Button)findViewById(R.id.btn_signup);
        tvName=(EditText)findViewById(R.id.etName);
        tvPhoneNumber=(EditText)findViewById(R.id.etPhoneNumber);
        tvEmailId = (EditText)findViewById(R.id.etEmailId);
        tvMeal = (EditText)findViewById(R.id.etMeal);
        tvCommentsSuggestions = (EditText)findViewById(R.id.etcommentsSuggestions);
        rbPrice = (RatingBar)findViewById(R.id.rbPriceRating);
        rbLooks = (RatingBar)findViewById(R.id.rbLooksRating);
        rbTaste = (RatingBar)findViewById(R.id.rbTasteRating);
        rbOverall = (RatingBar)findViewById(R.id.rbOverallRating);
        rbSides = (RatingBar)findViewById(R.id.rbSidesRating);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                setMyModelData();

                validateData(myDataModel);

                new SendRequest().execute();

                setDefaultValueOfFields();



            }

        }   );

        }







    public class SendRequest extends AsyncTask<String, Void, String> {


        protected void onPreExecute(){}

        protected String doInBackground(String... arg0) {

            try{
                //Change your web app deployed URL or u can use this
                URL url = new URL("https://script.google.com/macros/s/AKfycbyklZx0IGlDV6enQnEZPuqse07MrAIxPUqgUmyFQwd2JQzNxHw/exec");
              
                JSONObject postDataParams = new JSONObject();

                //int i;
                //for(i=1;i<=70;i++)


                //    String usn = Integer.toString(i);

                String id= "1MAMQUAJYOIRWKp83VjUa6G47HM7kqUFrYGvmJ9xchTI";

                postDataParams.put("name",myDataModel.getName());
                postDataParams.put("phoneNumber",myDataModel.getPhoneNumber());
                postDataParams.put("emailId",myDataModel.getEmailId());
                postDataParams.put("meal",myDataModel.getMeal());
                postDataParams.put("tasteRating",myDataModel.getTasteRating());
                postDataParams.put("amountRating",myDataModel.getAmountRating());
                postDataParams.put("looksRating",myDataModel.getLooksRating());
                postDataParams.put("sidesRating",myDataModel.getSidesRating());
                postDataParams.put("priceRating",myDataModel.getPriceRating());
                postDataParams.put("overallRating",myDataModel.getOverallRating());
                postDataParams.put("commentsAndSugg",myDataModel.getCommentsSuggestions());
                postDataParams.put("date",myDataModel.getDate());


                postDataParams.put("id",id);



                Log.e("params",postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();

        }
    }

    public void validateData(MyDataModel myDataModel){

        if(myDataModel.getName().equals("")){

        }


    }

    public void setMyModelData(){

        myDataModel.setName(tvName.getText().toString());
        myDataModel.setPhoneNumber(tvPhoneNumber.getText().toString());
        myDataModel.setEmailId(tvEmailId.getText().toString());
        myDataModel.setMeal(tvMeal.getText().toString());
        myDataModel.setTasteRating(rbTaste.getRating());
        myDataModel.setLooksRating(rbLooks.getRating());
        myDataModel.setPriceRating(rbPrice.getRating());
        myDataModel.setSidesRating(rbSides.getRating());
        myDataModel.setOverallRating(rbOverall.getRating());
        myDataModel.setCommentsSuggestions(tvCommentsSuggestions.getText().toString());



    }

    public void setDefaultValueOfFields(){

        tvName.setText("");
        tvPhoneNumber.setText("");
        tvEmailId.setText("");
        tvMeal.setText("");
        tvCommentsSuggestions.setText("");

    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }
}
