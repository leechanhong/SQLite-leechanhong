package com.human.sqlite_leechanhong;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //현재클래스에서 사용할 멤버변수 선언(아래)
    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mSqLiteDatabase;//sql템플릿(insert,select...)이 여기포함.
    private RecyclerAdapter mRecyclerAdapter;
    private List mItemlist = new ArrayList<StudentVO>();//객체생성,셀렉트 쿼리결과 저장객체
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //신규 데이터베이스 객체 생성=메모리에 올리기=실행가능하게 만들기(아래)
        //=데이터베이스헬퍼클래스의 생성자 매서드 실행
        mDatabaseHelper = new DatabaseHelper(this,"school.db",null,1);
        //데이터베이스 파일 만들기(아래)
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        //테스트로 mSqLiteDatabase 객체를 이용해서 더미데이터 인서트 테스트
        //자바의 Hashmap형식과 비슷한 안드로이드 데이터형 ContentValues형
        /*ContentValues contentValues = new ContentValues();
        contentValues.put(StudentTable.GRADE, 1);
        contentValues.put(StudentTable.NUMBER,20210003);
        contentValues.put(StudentTable.NAME,"아무개3");
        mSqLiteDatabase.insert(StudentTable.TABLE_NAME,null,contentValues);
        */
        //mItemList에 셀렉트 쿼리 결과값이 셋 되어 있어야 함.

        //List 실행 리사이클러 어댑터 바인딩(아래)
        bindList();//여서는 공간마련
        //List 반영(화면출력)
        updateList();//여기에서 데이터바인딩돼서 RecyclerAdapter가 화면에 재생됩니다.
    }

    private void updateList() {
        mItemlist.clear();
        mItemlist.addAll(getAllData());
        //안드로이드 전용 클래스이고, 메서드입니다.(아래)
        mRecyclerAdapter.notifyDataSetChanged();//어댑터에 실제값이 들어가면서 화면에
    }
    //셀렉트 쿼리결과를 리턴합니다.
    private List getAllData() {
        List tablelist = new ArrayList<>();//studentTable내용을 담을 예정.
        //쿼리작업
        return tablelist;
    }

    //List 실행 리사이클러 어댑터 바인딩(아래)
    private void bindList() {
        //객체 생성
        mRecyclerAdapter = new RecyclerAdapter(mItemlist);
    }
}