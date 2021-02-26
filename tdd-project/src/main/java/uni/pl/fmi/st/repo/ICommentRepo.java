package uni.pl.fmi.st.repo;

import java.util.List;

import uni.pl.fmi.st.models.Comment;

public interface ICommentRepo {
	public List<Comment> findAll();
	public List<Comment> delete();
}
