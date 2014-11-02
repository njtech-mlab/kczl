package cn.edu.njut.subsidiary;

import java.util.List;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.Comment;
import cn.edu.njut.entity.CourseAdvice;
import cn.edu.njut.entity.EvlDaily;
import cn.edu.njut.entity.Spit;

public class CommentList {
	private List<Comment> list;

	public List<Comment> getList() {
		return list;
	}

	public void setList(List<Comment> list) {
		this.list = list;
	}

	@SuppressWarnings("unchecked")
	public CommentList(Object object, String kind) {
		Dao dao = new Dao();
		if (kind.equals("Spit")) {
			Spit spit = (Spit) object;
			list = (List<Comment>) dao.getByHql("FROM Comment c WHERE c.infoid=" + spit.getSpitid());
		}
		
		if (kind.equals("CourseAdvice")) {
			CourseAdvice ca = (CourseAdvice) object;
			list = (List<Comment>) dao.getByHql("FROM Advicecomment c WHERE c.infoid=" + ca.getCaid());
		}
		
		if (kind.equals("EvlDaily")) {
			EvlDaily evldaily = (EvlDaily) object;
			list = (List<Comment>) dao.getByHql("FROM Comment c WHERE c.infoid=" + evldaily.getEdid());
		}
	}
}
