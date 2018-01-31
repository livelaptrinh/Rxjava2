package team.kiti.rxjava2_android.operators.map;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import team.kiti.rxjava2_android.BaseActivity;
import team.kiti.rxjava2_android.R;

public class MapExampleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_example);

        getObservable()
                /*Nhận List UserApi chuyển thành List User*/
                .map(new Function<List<UserApi>, List<User>>() {
                    @Override
                    public List<User> apply(List<UserApi> userApis) throws Exception {
                        Log.d(TAG, "apply: " + Thread.currentThread().getName());
                        return User.convertUserApisToUsers(userApis);
                    }
                })
                /*Khởi tạo và chuyển đổi data trên luồng khác*/
                .subscribeOn(Schedulers.io())
                /*Chuyển về luồng 9*/
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());
    }

    private Observable<List<UserApi>> getObservable() {
        return Observable.create(new ObservableOnSubscribe<List<UserApi>>() {
            @Override
            public void subscribe(ObservableEmitter<List<UserApi>> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    Log.d(TAG, "subscribe: " + Thread.currentThread().getName());
                    emitter.onNext(UserApi.getListUserApi());
                    emitter.onComplete();
                }
            }
        });
    }

    private Observer<List<User>> getObserver() {
        return new Observer<List<User>>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<User> users) {
                Log.d(TAG, "onNext: " + Thread.currentThread().getName());
                Log.d("OKE", "onNext: " + users.size());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }
}
