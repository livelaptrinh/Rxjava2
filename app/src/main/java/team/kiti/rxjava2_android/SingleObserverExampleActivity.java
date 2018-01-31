package team.kiti.rxjava2_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class SingleObserverExampleActivity extends AppCompatActivity {
    String TAG  = "OKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_observer_example);
        doSomeWork();
    }

    private void doSomeWork(){
        /*Nhận vào giá trị Amit*/
        Single.just("Amit").subscribe(getSingleObserver());
    }

    /*Nhận giá trị từ just*/
    private SingleObserver<String> getSingleObserver(){
        return new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: "+d.isDisposed());
            }

            @Override
            public void onSuccess(String s) {
                Log.d(TAG, "onSuccess: "+s);
            }

            @Override
            public void onError(Throwable e) {

            }
        };
    }
}
