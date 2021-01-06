package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class sqlite extends AppCompatActivity {
    private EditText ed_book,ed_price;
    private Button btn_query,btn_insert,btn_update,btn_delete;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> items=new ArrayList<>();
    private SQLiteDatabase dbrw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sqlite);

        ed_book=findViewById(R.id.ed_book);
        ed_price=findViewById(R.id.ed_price);
        btn_query=findViewById(R.id.btn_query);
        btn_delete=findViewById(R.id.btn_delete);
        btn_insert=findViewById(R.id.btn_insert);
        btn_update=findViewById(R.id.btn_update);
        listView=findViewById(R.id.listView);

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
        dbrw=new MyDBHelper(this).getWritableDatabase();

        btn_query.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Cursor c;
                if(ed_book.length()<1){
                    c=dbrw.rawQuery("Select * From myTable",null);
                }
                else {
                    c=dbrw.rawQuery("Select * From myTable Where book Like'"+ed_book.getText().toString()+"'",null);
                }
                c.moveToFirst();
                items.clear();
                Toast.makeText(sqlite.this,"共有"+c.getCount()+"筆資料",Toast.LENGTH_LONG).show();
                for(int i=0;i<c.getCount();i++){
                    items.add("書名:"+c.getString(0)+"\t\t\t\t價格"+c.getString(1));
                    c.moveToNext();
                }
                adapter.notifyDataSetChanged();
                c.close();

            }

        });
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed_book.length()<1||ed_price.length()<1) {
                    Toast.makeText(sqlite.this, "欄位請勿留空", Toast.LENGTH_SHORT).show();

                }
                else{
                    try{
                        dbrw.execSQL("Insert Into myTable(book,price)Values(?,?)",new Object[]{ed_book.getText().toString(),ed_price.getText().toString()});
                        Toast.makeText(sqlite.this,"新增書名"+ed_book.getText().toString()+"價格"+ed_price.getText().toString(),Toast.LENGTH_LONG).show();
                        ed_price.setText("");
                        ed_book.setText("");
                    }catch(Exception e){
                        Toast.makeText(sqlite.this,"新增失敗",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(ed_book.length()<1||ed_price.length()<1){
                    Toast.makeText(sqlite.this, "欄位請勿留空", Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        dbrw.execSQL("Update myTable Set price="+ed_price.getText().toString()+"Where book like'"+ed_book.getText().toString()+"'");
                        Toast.makeText(sqlite.this,"更新書名"+ed_book.getText().toString()+"價格"+ed_price.getText().toString(),Toast.LENGTH_LONG).show();
                        ed_price.setText("");
                        ed_book.setText("");
                    }catch(Exception e){
                        Toast.makeText(sqlite.this,"更新失敗",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(ed_book.length()<1||ed_price.length()<1){
                    Toast.makeText(sqlite.this, "欄位請勿留空", Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        dbrw.execSQL("Delete from myTable Where book Like'"+ed_book.getText().toString()+"'");
                        Toast.makeText(sqlite.this,"刪除書名"+ed_book.getText().toString()+"價格"+ed_price.getText().toString(),Toast.LENGTH_LONG).show();
                        ed_price.setText("");
                        ed_book.setText("");
                    }catch(Exception e){
                        Toast.makeText(sqlite.this,"刪除失敗",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        dbrw.close();
    }

}