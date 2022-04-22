package com.example.finalproject_parniyanroosta;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewPainting, imgViewPottery, imgViewKnitting, imgViewEmbroidery;
    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDatabase();
        loadTableData();

        imgViewPainting = findViewById(R.id.imageViewPainting);
        imgViewPainting.setOnClickListener(v -> StartPaintingActivity());

        imgViewKnitting = findViewById(R.id.imageViewKnitting);
        imgViewKnitting.setOnClickListener(v -> StartKnittingActivity());

        imgViewPottery = findViewById(R.id.imageViewPottery);
        imgViewPottery.setOnClickListener(v -> StartPotteryActivity());

        imgViewEmbroidery = findViewById(R.id.imageViewEmbroidery);
        imgViewEmbroidery.setOnClickListener(v -> StartEmbroideryActivity());
    }

    public void StartPaintingActivity() {
        Intent intent = new Intent(MainActivity.this, Category_Painting.class);
        startActivity(intent);
    }

    public void StartPotteryActivity() {
        Intent intent = new Intent(MainActivity.this, Category_Pottery.class);
        startActivity(intent);
    }

    public void StartKnittingActivity() {
        Intent intent = new Intent(MainActivity.this, Category_Knitting.class);
        startActivity(intent);
    }

    public void StartEmbroideryActivity() {
        Intent intent = new Intent(MainActivity.this, Category_Embroidery.class);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //TODO
        // to save the page info when the device is rotated-------@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu, this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar will automatically handle clicks
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent intent = new Intent(this, AboutMe.class);
                startActivity(intent);
                return true;
            case R.id.action_contact:
                Intent intent2 = new Intent(this, ContactPage.class);
                startActivity(intent2);
                return true;
            case R.id.action_login:
                Intent intent3 = new Intent(this, LoginPage.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void createDatabase()
    {
        //creating or opening the database and handling the errors
        try {
            db = this.openOrCreateDatabase("MyArtDatabase", MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS itemsTable(id INTEGER PRIMARY KEY, name VARCHAR, description VARCHAR, price INTEGER(4))");

            Cursor query = db.rawQuery("SELECT * FROM itemsTable", null);
            int idIndex = query.getColumnIndex("id");
            int nameIndex = query.getColumnIndex("name");
            int descriptionIndex = query.getColumnIndex("description");
            int priceIndex = query.getColumnIndex("price");

            //query object at the beginning of the table
            query.moveToFirst();


            if ( query.getCount() ==0)   //table does not contain the entry
            {

                for ( int i=0; i<20; i++)
                {
                    mWordList.add("word "+i); //------------------------------------------------------------------------------------------------------------------
                    String sql = "INSERT INTO itemsTable(name, description, price) VALUES (?,?,?)";
                    //compile statement
                    SQLiteStatement statement = db.compileStatement(sql);

                    //initialize the binding
                    statement.clearBindings();
                    //bind variables with these index positions
                    statement.bindString(1, R.id.name);
                    statement.bindString(2, mWordList.get(i).toString());
                    statement.bindLong(3, @@@@@@);

                    statement.executeInsert();
                }

            } else {   // table contains the entry

                while ( query != null)
                {
                    mWordList.addLast(query.getString(wordIndex));

                    query.moveToNext();
                }
            }




            db.execSQL("INSERT INTO MyTable (name, description, price) VALUES ('White Daisies', 'la la la', 240)");
            db.execSQL("INSERT INTO MyTable (name, description, price) VALUES ('green Daisies', 'bababa', 240)");
            db.execSQL("INSERT INTO MyTable (name, description, price) VALUES ('blue Daisies', 'cacaca', 240)");
            db.execSQL("INSERT INTO MyTable (name, description, price) VALUES ('red Daisies', 'dadadad', 240)");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    protected void loadTableData()
    {
        //loading data into the table
        try {
            db = this.openOrCreateDatabase("MyArtDatabase", MODE_PRIVATE, null);
            Cursor query = db.rawQuery("SELECT * FROM itemsTable", null);
            int nameIndex = query.getColumnIndex("name");
            int descriptionIndex = query.getColumnIndex("description");
            int priceIndex = query.getColumnIndex("price");

            //start the loop from the beginning of the table
            query.moveToFirst();
            while (query!=null)
            {
                Toast.makeText(this, query.getString(nameIndex), Toast.LENGTH_SHORT).show();
                query.moveToNext();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }

}