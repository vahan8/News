package gevorgyan.vahan.com.news.main.data.db;

import android.database.sqlite.SQLiteDatabase;

import gevorgyan.vahan.com.news.main.data.db.dao.ArticleDao;

public class DbCreator {

    public static void createTableArticles(SQLiteDatabase db) {
        db.execSQL("create table " +
                ArticleDao.TABLE_NAME + " ("
                + ArticleDao.TITLE          + " text not null primary key,"
                + ArticleDao.SOURCE_ID      + " text,"
                + ArticleDao.SOURCE_NAME    + " text,"
                + ArticleDao.AUTHOR         + " text,"
                + ArticleDao.DESCRIPTION    + " text,"
                + ArticleDao.URL            + " text,"
                + ArticleDao.URL_TO_IMAGE   + " text,"
                + ArticleDao.PUBLISHED_AT   + " integer,"
                + ArticleDao.CONTENT        + " text,"
                + ArticleDao.CREATION_DATE  + " integer)");
    }

}
