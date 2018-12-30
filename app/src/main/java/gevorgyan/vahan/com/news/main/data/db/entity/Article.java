package gevorgyan.vahan.com.news.main.data.db.entity;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import gevorgyan.vahan.com.news.main.data.db.dao.ArticleDao;
import gevorgyan.vahan.com.news.main.domain.model.Source;

@Entity(tableName = ArticleDao.TABLE_NAME)
public class Article {


    private Source source;


    private String author;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "fTITLE")
    private String title;

    private String description;

    private String url;

    private String urlToImage;

    private Date publishedAt;

    private String content;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
