package gevorgyan.vahan.com.news.main.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gevorgyan.vahan.com.news.main.data.db.DbHelper;
import gevorgyan.vahan.com.news.main.domain.model.Article;
import gevorgyan.vahan.com.news.main.domain.model.Source;
import gevorgyan.vahan.com.news.main.util.DateUtils;

public class ArticleDao {

    public static final String TABLE_NAME = "ARTICLES";

    public static final String SOURCE_ID = "fSOURCEID";
    public static final String SOURCE_NAME = "fSOURCENAME";
    public static final String AUTHOR = "fAUTHOR";
    public static final String TITLE = "fTITLE";
    public static final String DESCRIPTION = "fDESCRIPTION";
    public static final String URL = "fURL";
    public static final String URL_TO_IMAGE = "fURLTOIMAGE";
    public static final String PUBLISHED_AT = "fPUBLISHEDAT";
    public static final String CONTENT = "fCONTENT";
    public static final String CREATION_DATE = "fCREATIONDATE";

    private ArticleDao() {
    }

    public static void insert(Article article) throws SQLiteException {
        SQLiteDatabase db = DbHelper.getInstance().getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            cv.put(SOURCE_ID, article.getSource().getId());
            cv.put(SOURCE_NAME, article.getSource().getName());
            cv.put(AUTHOR, article.getAuthor());
            cv.put(TITLE, article.getTitle());
            cv.put(DESCRIPTION, article.getDescription());
            cv.put(URL, article.getUrl());
            cv.put(URL_TO_IMAGE, article.getUrlToImage());
            cv.put(PUBLISHED_AT, article.getPublishedAt().getTime());
            cv.put(CONTENT, article.getContent());
            cv.put(CREATION_DATE, DateUtils.getCurrentDate().getTime());
            db.insert(TABLE_NAME, null, cv);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public static void delete(String title) throws SQLiteException {
        SQLiteDatabase db = DbHelper.getInstance().getWritableDatabase();
        try {
            db.beginTransaction();
            String whereClause = TITLE + "=?";
            String [] whereArgs = new String[] {title};
            db.delete(TABLE_NAME, whereClause, whereArgs);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    private static Cursor getArticlesCursor(String... orderByColumns) throws SQLiteException {
        SQLiteDatabase db = DbHelper.getInstance().getReadableDatabase();
        String sql = "select "
                + SOURCE_ID    + " , "
                + SOURCE_NAME  + " , "
                + AUTHOR       + " , "
                + TITLE        + " , "
                + DESCRIPTION  + " , "
                + URL          + " , "
                + URL_TO_IMAGE + " , "
                + PUBLISHED_AT + " , "
                + CONTENT      + " , "
                + "rowid as _id "
                + " from "
                + TABLE_NAME;


        if (orderByColumns.length > 0) {
            sql = sql + " order by " + orderByColumns[0];
            for (int i = 1; i < orderByColumns.length; i++) {
                sql = sql + "," + orderByColumns[i];
            }
        }
        return db.rawQuery(sql, null);
    }

    public static List<Article> getArticles() throws SQLiteException {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = getArticlesCursor(null, CREATION_DATE + " asc ");
        if (cursor.moveToFirst()) {
            do {
                Article article = new Article();
                Source source = new Source();
                source.setId(cursor.getString(cursor.getColumnIndex(SOURCE_ID)));
                source.setName(cursor.getString(cursor.getColumnIndex(SOURCE_NAME)));
                article.setSource(source);
                article.setAuthor(cursor.getString(cursor.getColumnIndex(AUTHOR)));
                article.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
                article.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION)));
                article.setPublishedAt(new Date(cursor.getLong(cursor.getColumnIndex(PUBLISHED_AT))));
                article.setUrl(cursor.getString(cursor.getColumnIndex(URL)));
                article.setUrlToImage(cursor.getString(cursor.getColumnIndex(URL_TO_IMAGE)));
                article.setContent(cursor.getString(cursor.getColumnIndex(CONTENT)));
                articles.add(article);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return articles;
    }

}
