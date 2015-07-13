package martin.example.com.newApp;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;

public class SixthFragment extends android.support.v4.app.Fragment {

    private TextView myText;
   // private WeakReference<MyAsyncTask> asyncTaskWeakReference;

    public SixthFragment(){}

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
     //   setRetainInstance(true);
   //     startNewAsyncTask();
    }
/*
    private void startNewAsyncTask() {
        MyAsyncTask asyncTask = new MyAsyncTask(this);
        this.asyncTaskWeakReference = new WeakReference<MyAsyncTask>(asyncTask);
        asyncTask.execute();
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.sixth_fragment, container, false);

        /*DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httppost = new HttpGet("https://en.wikipedia.org/wiki/Thyroid");
        HttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity ht = response.getEntity();

        BufferedHttpEntity buf = null;
        try {
            buf = new BufferedHttpEntity(ht);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = buf.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader r = new BufferedReader(new InputStreamReader(is));

        StringBuilder total = new StringBuilder();
        String line;
        try {
            while((line = r.readLine())!=null ){
                total.append(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       myText.setText(total);
       */
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myText = (TextView) view.findViewById(R.id.textView2);

    }

    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onStop(){
        super.onStop();
    }

   // private static class MyAsyncTask extends AsyncTask<Void, Void, Void> {

      //  private WeakReference<SixthFragment> fragmentWeakRef;
      //  private TextView myText;

      //  private MyAsyncTask(SixthFragment sixthFragment) {
        //    this.fragmentWeakRef = new WeakReference<SixthFragment>(sixthFragment);
     //   }

     /*   @Override
        protected Void doInBackground(Void params) {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httppost = new HttpGet("https://en.wikipedia.org/wiki/Thyroid");
            HttpResponse response = null;
            try {
                response = httpclient.execute(httppost);
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpEntity ht = response.getEntity();

            BufferedHttpEntity buf = null;
            try {
                buf = new BufferedHttpEntity(ht);
            } catch (IOException e) {
                e.printStackTrace();
            }
            InputStream is = null;
            try {
                is = buf.getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }

            BufferedReader r = new BufferedReader(new InputStreamReader(is));

            StringBuilder total = new StringBuilder();
            String line;
            try {
                while ((line = r.readLine()) != null) {
                    total.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            myText = (TextView) view.findViewById(R.id.textView2);
            myText.setText(total);
        }
*/

  //  }
}
