package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class st1_lectureDesk extends AppCompatActivity {
    private Button btn_st1_moveBb;          /// 칠판으로 이동 버튼///
    private Button btn_st1_ld_ps;           /// 교탁 암호 버튼 ///

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st1_lecture_desk);

        ///상단바 제거 ///
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /// hint 버튼 ///

        st1_gv.st1_hintBtn = (Button) findViewById(R.id.btn_st1_hint);
        st1_gv.st1_hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_lectureDesk.this, st1_Popup_hint.class);
                if (st1_gv.st1_hint_count > 0) {                ///hint 잔여개수 0개일 경우 실행x) (초기값 2)
                    st1_gv.st1_hint_count--;
                    startActivity(intent);
                }
                else
                    Toast.makeText(st1_lectureDesk.this, "힌트는 더이상 없는 것 같다.", Toast.LENGTH_SHORT).show();
            }
        });

        /// item 버튼 ///
        st1_gv.st1_itemBtn = (Button) findViewById(R.id.btn_st1_item);
        st1_gv.st1_itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_lectureDesk.this, st1_Popup_item.class);
                startActivity(intent);
            }
        });


        ///칠판으로 이동///
        btn_st1_moveBb = findViewById(R.id.st1_ld_to_bb);
        btn_st1_moveBb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_lectureDesk.this, st1_blackboard.class);
                startActivity(intent);
            }
        });

        ///교탁 암호///

        btn_st1_ld_ps = findViewById(R.id.st1_ldLock);                     /// 교탁 암호 Activity로 이동 ///
        btn_st1_ld_ps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(st1_lectureDesk.this, st1_lectureDeskPw.class);
                startActivity(intent);
            }
        });
    }

    /// 뒤로가기 방지 ///
    public void onBackPressed() {
        return;
    }
}