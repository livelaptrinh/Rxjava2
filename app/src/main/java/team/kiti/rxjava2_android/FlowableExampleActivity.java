package team.kiti.rxjava2_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

public class FlowableExampleActivity extends AppCompatActivity {
    String TAG = "OKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowable_example);
        doSomeWork();//Gọi hàm thực thi công việc//
    }

    private void doSomeWork(){//
        /*Nhận vào 4 tham số*/
        Flowable<Integer> observable = Flowable.just(1, 2,3,4);
        /*Nhận vào 50 và cộng lần lượt với 4 tham số*/
        /*Trả về giá trị cộng lần cuối cùng*/
        observable.reduce(50, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                Log.d(TAG, "so1: "+integer+" so2: "+integer2);
                return integer + integer2;
            }
        }).subscribe(getObserver());
    }

    /*Nhận giá trị trả về từ reduce*/
    private SingleObserver<Integer> getObserver(){
        return new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: "+d.isDisposed());
            }

            @Override
            public void onSuccess(Integer integer) {
                Log.d(TAG, "onSuccess: "+integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
            }
        };
    }
}
