package blog_management.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private String contentBlog;
    @Column(name = "create_time_blog",columnDefinition = "datetime")
    private String createTimeBlog;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    public Blog() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String firstName) {
        this.author = firstName;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String lastName) {
        this.contentBlog = lastName;
    }

    public String getCreateTimeBlog() {
        return createTimeBlog;
    }

    public void setCreateTimeBlog(String createTime) {
        this.createTimeBlog = createTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
