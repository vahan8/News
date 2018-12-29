package gevorgyan.vahan.com.news.main.data.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import gevorgyan.vahan.com.news.App;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "news";
    private static final int VERSION = 10000;

    private static DbHelper instance;

    private DbHelper() {
        super(App.getContext(), DATABASE_NAME, null, VERSION);

    }

    public static synchronized DbHelper getInstance() {
        if (instance == null) {
            instance = new DbHelper();
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        DbCreator.createTableArticles(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}